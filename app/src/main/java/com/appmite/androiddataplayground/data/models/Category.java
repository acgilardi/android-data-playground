package com.appmite.androiddataplayground.data.models;


import com.appmite.androiddataplayground.data.repo.Repo;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

//CREATE TABLE "Category" ("CategoryId" INTEGER PRIMARY KEY  NOT NULL ,"CategoryName" TEXT NOT NULL ,"Description" TEXT,"Icon" TEXT)
//CREATE TABLE "Category" ("CategoryId" INTEGER PRIMARY KEY  NOT NULL ,"Name" TEXT NOT NULL ,"Description" TEXT,"Icon" TEXT)

@DatabaseTable
public class Category 
{
	@DatabaseField(generatedId = true) 
	private int id;
	@DatabaseField
	private String name;
	@DatabaseField
	private String description;
	@DatabaseField
	private String icon;
	
	public Category() 
	{
		// needed by ormlite
	}
	
	public Category(String name, String description, String icon) {
		this.name = name;
		this.description = description;
		this.icon = icon;
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

	public void setIcon(String icon){
		this.icon = icon;
	}
	public String getIcon(){
		return this.icon;
	}

	
	public int save(Repo repo){
		if(repo.Categories.getByCategoryName(this.name) == null)
			return repo.Categories.create(this);
		else
			return repo.Categories.update(this);
	}
	public int delete(Repo repo){
		return repo.Categories.delete(this);
	}

	public String toString(){
		return this.name;
	}
	
}
