package com.appmite.androiddataplayground;


import android.util.Log;

import com.parse.DeleteCallback;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class DbManager {

    private OnDbManagerDoneListener mListenerDone;

    // Shared Preferences
    public static String logUpgrade = "UPGRADE_DB";

    public DbManager() {
    }

    public interface OnDbManagerDoneListener{
        public void onDone(Integer currentDatabaseVersion);   //method, which can have parameters
    }

    public void setOnDbManagerDoneListener(OnDbManagerDoneListener eventListener) {
        mListenerDone = eventListener;
    }

    public void initialize(Integer expectedDatabaseVersion, Integer currentDatabaseVersion,
                           Boolean forceDatabaseClear) {
        // Force clearing the static data
        if (forceDatabaseClear) {
            currentDatabaseVersion = 0;
            clearCategories(expectedDatabaseVersion, currentDatabaseVersion);
        } else {
            upgradeDatabase(expectedDatabaseVersion, currentDatabaseVersion);
        }
    }

    public void clearCategories(final Integer expectedVersion, final Integer currentVersion) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Category");
        //query.whereEqualTo("playerName", "Dan Stemkoski");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> categories, ParseException e) {
                if (e == null) {

                    Log.d("CLEAR_CATEGORIES", "Retrieved " + categories.size() + " categories");

                    ParseObject.deleteAllInBackground(categories, new DeleteCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                Log.d("CLEAR_CATEGORIES", "Cleared all categories");
                            } else {
                                Log.d("CLEAR_CATEGORIES", "ERROR: " + e.getMessage());
                            }

                            upgradeDatabase(expectedVersion, currentVersion);
                        }
                    });

                } else {
                    Log.d("CLEAR_CATEGORIES", "ERROR: " + e.getMessage());
                }
            }
        });
    }

    public void upgradeDatabase(Integer expectedVersion, Integer currentVersion) {
        // Upgrade the database incrementally for each version
        if(!currentVersion.equals(expectedVersion)) {

            for(int i = currentVersion; i < expectedVersion; i++) {

                switch (i)
                {
                    case 0:
                        //DbUpgrade1 upgrade1 = new DbUpgrade1();
                        Log.d(logUpgrade, "Upgrade Db from 0 to 1");
                        currentVersion = 1;
                        break;

                    case 1:
                        Log.d(logUpgrade, "Upgrade Db from 1 to 2");
                        currentVersion = 2;
                        break;
                }
            }
        }

        mListenerDone.onDone(currentVersion);
    }

}
