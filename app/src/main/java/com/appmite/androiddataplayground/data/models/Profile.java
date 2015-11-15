package com.appmite.androiddataplayground.data.models;




import com.appmite.androiddataplayground.data.repo.Repo;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

//CREATE TABLE "profile" ("id" INTEGER PRIMARY KEY ,"name" TEXT)

@DatabaseTable
public class Profile 
{
	@DatabaseField(generatedId = true) 
	private int id;
	@DatabaseField
	private String name;

	
	public Profile() 
	{
		// needed by ormlite
	}
	
	public Profile(String name) {
		this.name = name;
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
	
	
	
	public int save(Repo repo){
		if(repo.Profiles.getProfileByName(this.name) == null)
			return repo.Profiles.create(this);
		else
			return repo.Profiles.update(this);
	}
	public int delete(Repo repo){
		return repo.Profiles.delete(this);
	}

	public String toString(){
		return this.name;
	}
	
}
