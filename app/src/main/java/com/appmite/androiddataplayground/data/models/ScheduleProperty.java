package com.appmite.androiddataplayground.data.models;

import com.appmite.androiddataplayground.data.repo.Repo;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

//CREATE TABLE "scheduleproperty" ("id" INTEGER PRIMARY KEY ,"schedule_id" INTEGER, 
//"name" TEXT, "goalvalue" TEXT)

@DatabaseTable
public class ScheduleProperty 
{
	@DatabaseField(generatedId = true) 
	private int id;
	
	@DatabaseField(foreign=true,foreignAutoRefresh=true)
	private Schedule schedule;
	
	@DatabaseField
	private String name;
	
	@DatabaseField
	private String goalvalue;

	
	public ScheduleProperty() 
	{
		// needed by ormlite
	}
	
	public ScheduleProperty(String name, String goalvalue, Schedule schedule) {
		this.name = name;
		this.goalvalue = goalvalue;
		this.goalvalue = goalvalue;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	public void setGoalValue(String goalvalue){
		this.goalvalue = goalvalue;
	}
	public String getGoalValue() 
	{
		return this.goalvalue;
	}
	
	public void setSchedule(Schedule schedule){
		this.schedule = schedule;
	}
	public Schedule getSchedule(){
		return this.schedule;
	}


	
	public int save(Repo repo){
		if(repo.ScheduleProperties.getByName(this.name) == null)
			return repo.ScheduleProperties.create(this);
		else
			return repo.ScheduleProperties.update(this);
	}
	public int delete(Repo repo){
		return repo.ScheduleProperties.delete(this);
	}

	public String toString(){
		return this.name;
	}
	
}
