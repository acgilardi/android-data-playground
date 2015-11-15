package com.appmite.androiddataplayground;

public class Constants {

    //Activity
    public static String ACTION_ENTRY_ACTIVITY = "EntryActivityAction";
    public static String SCHEDULE_SCHEDULEID = "ScheduleScheduleId";
    public static String TEMPLATEEDIT_TEMPLATETYPE = "TemplateEditTemplateType";

    //URLs
    public static String URL_BLOG_ROOT = "http://apptips.lifemite.com/apptips";



    // UI Constants
    public static String TIMER_ENTRY_HINT = "Enter Goal in Minutes";
    public static String DISTANCE_ENTRY_HINT = "Enter Goal in Miles";
    public static String CALORIE_ENTRY_HINT = "Enter Goal in Calories";
    public static String SERVINGS_ENTRY_HINT = "Enter Daily Servings Goal";
    public static String SPIRITUALITY_ENTRY_HINT = "Enter Goal in Hours";

    // Database

    // Template Columns
    public static String COLUMN_TEMPLATE_ID = "id";
    public static String COLUMN_TEMPLATE_TYPE = "type";
    public static String COLUMN_TEMPLATE_DESCRIPTION = "description";
    public static String COLUMN_TEMPLATE_CATEGORY_ID = "category_id";
    public static String COLUMN_TEMPLATE_ICON = "icon";
    public static String COLUMN_TEMPLATE_ISMEDICATION = "ismedication";
    public static String COLUMN_TEMPLATE_ISSERVING = "isserving";
    public static String COLUMN_TEMPLATE_ISSCHEDULED = "isscheduled";
    public static String COLUMN_TEMPLATE_ISGOALTRACKED = "isgoaltracked";
    public static String COLUMN_TEMPLATE_ISSYNCABLE = "issyncable";
    public static String COLUMN_TEMPLATE_ALLOWMULTIPLE = "allowmultiple";
    public static String COLUMN_TEMPLATE_TITLE = "title";

    // Schedule Columns
    public static String COLUMN_SCHEDULE_ID = "id";
    public static String COLUMN_SCHEDULE_TEMPLATE_ID = "template_id";
    public static String COLUMN_SCHEDULE_PROFILE_ID = "profile_id";
    public static String COLUMN_SCHEDULE_TITLE = "title";
    public static String COLUMN_SCHEDULE_DESCRIPTION = "description";
    public static String COLUMN_SCHEDULE_STARTDATE = "startdate";
    public static String COLUMN_SCHEDULE_FREQUENCY = "frequency";
    public static String COLUMN_SCHEDULE_REPEAT = "repeat";
    public static String COLUMN_SCHEDULE_INTERVAL = "interval";
    public static String COLUMN_SCHEDULE_ENDTYPE = "endtype";
    public static String COLUMN_SCHEDULE_ENDEVENTCOUNT = "endeventcount";
    public static String COLUMN_SCHEDULE_DAYS = "days";
    public static String COLUMN_SCHEDULE_ENDDATE = "enddate";

    // TemplateProperty Columns
    public static String COLUMN_TEMPLATEPROPERTY_ID = "id";
    public static String COLUMN_TEMPLATEPROPERTY_TEMPLATE_ID = "template_id";
    public static String COLUMN_TEMPLATEPROPERTY_NAME = "name";
    public static String COLUMN_TEMPLATEPROPERTY_INITIALVALUE = "initialvalue";

    // ScheduleProperty Columns
    public static String COLUMN_SCHEDULEPROPERTY_ID = "id";
    public static String COLUMN_SCHEDULEPROPERTY_TEMPLATE_ID = "schedule_id";
    public static String COLUMN_SCHEDULEPROPERTY_NAME = "name";
    public static String COLUMN_SCHEDULEPROPERTY_INITIALVALUE = "goalvalue";

    // Profile Columns
    public static String COLUMN_PROFILE_ID = "id";
    public static String COLUMN_PROFILE_NAME = "name";
}
