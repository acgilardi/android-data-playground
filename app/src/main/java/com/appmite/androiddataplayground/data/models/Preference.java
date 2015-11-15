package com.appmite.androiddataplayground.data.models;


import com.appmite.androiddataplayground.data.repo.Repo;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

//CREATE TABLE "preference" ("id" INTEGER PRIMARY KEY ,"name" TEXT,
//"description" TEXT,"value" TEXT, "initialvalue" TEXT)

@DatabaseTable
public class Preference 
{
	@DatabaseField(generatedId = true) 
	private int id;
	
	@DatabaseField
	private String name;
	
	@DatabaseField
	private String description;
	
	@DatabaseField
	private String value;
	
	@DatabaseField
	private String initialvalue;
	
	public Preference() 
	{
		// needed by ormlite
	}
	
	public Preference(String name, String description, String value, String initialvalue) {
		this.name = name;
		this.description = description;
		this.value = value;
		this.initialvalue = initialvalue;
	}
	
	public void setId(int id){
		this.id = id;
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

	public void setDescription(String description){
		this.description = description;
	}
	public String getDescription() 
	{
		return this.description;
	}

	public void setValue(String value){
		this.value = value;
	}
	public String getValue(){
		return this.value;
	}
	
	public void setInitialValue(String initialvalue){
		this.initialvalue = initialvalue;
	}
	public String getInitialValue(){
		return this.initialvalue;
	}

	
	public int save(Repo repo){
		if(repo.Preferences.getByName(this.name) == null)
			return repo.Preferences.create(this);
		else
			return repo.Preferences.update(this);
	}
	public int delete(Repo repo){
		return repo.Preferences.delete(this);
	}

	public String toString(){
		return this.name;
	}
	
}
