package com.appmite.androiddataplayground.data.models;

import com.appmite.androiddataplayground.data.repo.Repo;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

//CREATE TABLE "goalproperty" ("id" INTEGER PRIMARY KEY ,"goal_id" INTEGER,"name" TEXT,
//"value" TEXT,"intialvalue" TEXT)

@DatabaseTable
public class GoalProperty 
{
	@DatabaseField(generatedId = true) 
	private int id;
	
	@DatabaseField
	private String name;
	
	@DatabaseField
	private String value;
	
	@DatabaseField
	private String initialvalue;
	
	@DatabaseField(foreign=true,foreignAutoRefresh=true)
	private Goal goal;

	
	public GoalProperty() 
	{
		// needed by ormlite
	}
	
	public GoalProperty(String name, String value, String initialvalue, Goal goal) {
		this.name = name;
		this.value = value;
		this.initialvalue = initialvalue;
		this.goal = goal;
	}
	
//	public void setId(int id){
//		this.id = id;
//	}
	public int getId(){
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName(){
		return this.name;
	}

	public void setValue(String value){
		this.value = value;
	}
	public String getValue() 
	{
		return this.value;
	}
	
	public void setInitialValue(String initialvalue){
		this.initialvalue = initialvalue;
	}
	public String getInitialValue() 
	{
		return this.initialvalue;
	}
	
	public void setGoal(Goal goal){
		this.goal = goal;
	}
	public Goal getGoal(){
		return this.goal;
	}


	
	public int save(Repo repo){
		if(repo.GoalProperties.getByName(this.name) == null)
			return repo.GoalProperties.create(this);
		else
			return repo.GoalProperties.update(this);
	}
	public int delete(Repo repo){
		return repo.GoalProperties.delete(this);
	}

	public String toString(){
		return this.name;
	}
	
}
