package com.appmite.androiddataplayground.data.repo;

import com.appmite.androiddataplayground.data.DatabaseHelper;
import com.appmite.androiddataplayground.data.DatabaseManager;

import android.content.Context;

public class Repo 
{
	
	DatabaseHelper db;
	
	public RepoPreference Preferences;
	public RepoProfile Profiles;
	public RepoCategory Categories;
	public RepoTemplate Templates;
	public RepoTemplateProperty TemplateProperties;	
	public RepoGoal Goals;
	public RepoGoalProperty GoalProperties;
	public RepoSchedule Schedules;
	public RepoScheduleProperty ScheduleProperties;

	
	public Repo(Context context)
	{
		DatabaseManager<DatabaseHelper> manager = new DatabaseManager<DatabaseHelper>();
		db = manager.getHelper(context, DatabaseHelper.class);
		
		Preferences = new RepoPreference(db);
		Profiles = new RepoProfile(db);
		Categories = new RepoCategory(db);
		Templates = new RepoTemplate(db);
		TemplateProperties = new RepoTemplateProperty(db);
		Goals = new RepoGoal(db);
		GoalProperties = new RepoGoalProperty(db);
		Schedules = new RepoSchedule(db);
		ScheduleProperties = new RepoScheduleProperty(db);
	}	
	
}
