package com.appmite.androiddataplayground.data;


        import java.io.IOException;
        import java.sql.SQLException;

        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.util.Log;


        import com.appmite.androiddataplayground.data.models.*;
        import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;

        import com.j256.ormlite.dao.Dao;
        import com.j256.ormlite.dao.DaoManager;
        import com.j256.ormlite.support.ConnectionSource;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper
{
    private Dao<Category, String> categoryDao = null;
    private Dao<Template, String> templateDao = null;
    private Dao<Profile, String> profileDao = null;
    private Dao<Goal, String> goalDao = null;
    private Dao<GoalProperty, String> goalPropertyDao = null;
    private Dao<Preference, String> preferenceDao = null;
    private Dao<TemplateProperty,String> templatePropertyDao = null;
    private Dao<Schedule,String> scheduleDao = null;
    private Dao<ScheduleProperty,String> schedulePropertyDao = null;

    public DatabaseHelper(Context context)
    {
        super(context, DatabaseInitializer.DB_NAME, null, DatabaseInitializer.DB_VERSION);

        DatabaseInitializer initializer = new DatabaseInitializer(context);
        try
        {
            initializer.createDatabase();
            initializer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource)
    {
        //try {
        Log.i(DatabaseHelper.class.getName(), "onCreate");

        //TableUtils.createTable(connectionSource, Category.class);

//		} catch (SQLException e) {
//			Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
//			throw new RuntimeException(e);
//		}
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        //try {
        Log.i(DatabaseHelper.class.getName(), "onUpgrade");

        //TableUtils.dropTable(connectionSource, Category.class, true);

        onCreate(db);
//		} catch (SQLException e) {
//			Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
//			throw new RuntimeException(e);
//		}
    }


    public Dao<Category,String> getCategoryDao() throws SQLException
    {
        if(categoryDao == null)
        {
            categoryDao = DaoManager.createDao(getConnectionSource(), Category.class);
        }
        return categoryDao;
    }

    public Dao<Template,String> getTemplateDao() throws SQLException
    {
        if(templateDao == null)
        {
            templateDao = DaoManager.createDao(getConnectionSource(), Template.class);
        }
        return templateDao;
    }

    public Dao<Profile,String> getProfileDao() throws SQLException
    {
        if(profileDao == null)
        {
            profileDao = DaoManager.createDao(getConnectionSource(), Profile.class);
        }
        return profileDao;
    }

    public Dao<Goal,String> getGoalDao() throws SQLException
    {
        if(goalDao == null)
        {
            goalDao = DaoManager.createDao(getConnectionSource(), Goal.class);
        }
        return goalDao;
    }

    public Dao<GoalProperty,String> getGoalPropertyDao() throws SQLException
    {
        if(goalPropertyDao == null)
        {
            goalPropertyDao = DaoManager.createDao(getConnectionSource(), GoalProperty.class);
        }
        return goalPropertyDao;
    }



    public Dao<Preference,String> getPreferenceDao() throws SQLException
    {
        if(preferenceDao == null)
        {
            preferenceDao = DaoManager.createDao(getConnectionSource(), Preference.class);
        }
        return preferenceDao;
    }



    public Dao<TemplateProperty,String> getTemplatePropertyDao() throws SQLException
    {
        if(templatePropertyDao == null)
        {
            templatePropertyDao = DaoManager.createDao(getConnectionSource(), TemplateProperty.class);
        }
        return templatePropertyDao;
    }


    public Dao<Schedule,String> getScheduleDao() throws SQLException
    {
        if(scheduleDao == null)
        {
            scheduleDao = DaoManager.createDao(getConnectionSource(), Schedule.class);
        }
        return scheduleDao;
    }

    public Dao<ScheduleProperty,String> getSchedulePropertyDao() throws SQLException
    {
        if(schedulePropertyDao == null)
        {
            schedulePropertyDao = DaoManager.createDao(getConnectionSource(), ScheduleProperty.class);
        }
        return schedulePropertyDao;
    }



    @Override
    public void close()
    {
        super.close();
        categoryDao = null;
        templateDao = null;
        profileDao = null;
        goalDao = null;
        goalPropertyDao = null;
        templatePropertyDao = null;
        preferenceDao = null;
        scheduleDao = null;
    }
}
