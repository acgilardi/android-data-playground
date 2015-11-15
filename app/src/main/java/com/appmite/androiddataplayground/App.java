package com.appmite.androiddataplayground;

import android.app.Application;
import android.util.Log;

import com.appmite.androiddataplayground.entities.Template;
import com.appmite.androiddataplayground.utility.PreferenceUtils;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class App extends Application {

    private static App singleton;

    // Global contants
    public static String PARSE_APPID = "v3e9oxNMWBlk7doKfqzVMnpwVDEmlmM8UNDZNc56";
    public static String PARSE_CLIENT_KEY = "ywfzr4PLyYmG80WoJv9Adk4v4oASU8qjafxwLXzc";
    public static int VAL_EXPECTED_DB_VERSION = 1;
    public static boolean VAL_FORCE_DB_CLEAR = true;
    public static String KEY_CURRENT_DB_VERSION = "CURRENT_DATABASE_VERSION";
    public static String KEY_CLOUD_SYNC_ENABLED = "CLOUD_SYNC_ENABLED";
    public static String KEY_PROMPT_FOR_CLOUD_SYNC = "PROMPT_FOR_CLOUD_SYNC";

    public static App getInstance()
    {
        return singleton;
    }

    @Override
    public final void onCreate()
    {
        super.onCreate();
        singleton = this;

        initializeParseDataStore();
    }

    private void initializeApplication() {
        Integer currentDatabaseVersion = PreferenceUtils.readPreferenceValue(getApplicationContext(), KEY_CURRENT_DB_VERSION, 0);

        DbManager dbManager = new DbManager();
        dbManager.setOnDbManagerDoneListener(new DbManager.OnDbManagerDoneListener() {
            @Override
            public void onDone(Integer currentVersion) {
                PreferenceUtils.writePreferenceValue(getApplicationContext(), KEY_CURRENT_DB_VERSION, currentVersion);
            }
        });
        dbManager.initialize(VAL_EXPECTED_DB_VERSION, currentDatabaseVersion, VAL_FORCE_DB_CLEAR);
    }


    private void initializeParseDataStore() {
        // Enable Local Data storage.
        Parse.enableLocalDatastore(this);

        // Setup Parse Subclasses
        ParseObject.registerSubclass(Template.class);

        Parse.initialize(getApplicationContext(), PARSE_APPID, PARSE_CLIENT_KEY);
        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        ParseACL.setDefaultACL(defaultACL, true);

        ParseInstallation.getCurrentInstallation().saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
            if (e == null) {
                initializeApplication();
            } else {
                Log.d("INITIALIZE_PARSE", "Problem initializing parse");
            }
            }
        });
    }

    @Override
    public void onTerminate() {
        // TODO Auto-generated method stub
        super.onTerminate();
    }

}

