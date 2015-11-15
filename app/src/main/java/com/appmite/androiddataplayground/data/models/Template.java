package com.appmite.androiddataplayground.data.models;




import java.util.List;

import com.appmite.androiddataplayground.data.repo.Repo;
import com.appmite.androiddataplayground.TemplateTypes;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

//CREATE TABLE "template" ("id" INTEGER PRIMARY KEY ,"title" TEXT,"description" TEXT,"category_id" INTEGER,"icon" TEXT,
//"ismedication" BOOL DEFAULT (0) ,"isserving" BOOL DEFAULT (0) ,"isscheduled" BOOL DEFAULT (0) ,"isgoaltracked" BOOL DEFAULT (0) ,
//"issyncable" BOOL DEFAULT (0) ,"allowmultiple" BOOL DEFAULT (0) )

@DatabaseTable
public class Template 
{
	@DatabaseField(generatedId = true) 
	private int id;
	
	@DatabaseField
	private TemplateTypes type;
	
	@DatabaseField
	private String title;
	
	@DatabaseField
	private String description;
	
	@DatabaseField(foreign=true,foreignAutoRefresh=true)
	private Category category;
	
	@DatabaseField
	private String icon;
	
	@DatabaseField
	private boolean ismedication;
	
	@DatabaseField
	private boolean isserving;
	
	@DatabaseField
	private boolean isscheduled;
	
	@DatabaseField
	private boolean isgoaltracked;
	
	@DatabaseField
	private boolean issyncable;
	
	@DatabaseField
	private boolean allowmultiple;
	
	
	
	public Template() 
	{
		// needed by ormlite
	}
	
	public Template(String title, TemplateTypes type, String description, String icon, Category category,
			boolean ismedication, boolean isserving, boolean isscheduled, boolean isgoaltracked, 
			boolean issyncable, boolean allowmultiple) {
		this.type = type;
		this.title = title;
		this.description = description;
		this.icon = icon;
		this.category = category;
		this.ismedication = ismedication;
		this.isserving = isserving;
		this.isscheduled = isscheduled;
		this.isgoaltracked = isgoaltracked;
		this.issyncable = issyncable;
		this.allowmultiple = allowmultiple;
	}
	
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	
	public void setType(TemplateTypes type) {
		this.type = type;
	}
	public TemplateTypes getType(){
		return this.type;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle(){
		return this.title;
	}

	public void setDescription(String description){
		this.description = description;
	}
	public String getDescription() 
	{
		return this.description;
	}

	public void setCategory(Category category){
		this.category = category;
	}
	public Category getCategory(){
		return this.category;
	}
	
	public void setIcon(String icon){
		this.icon = icon;
	}
	public String getIcon(){
		return this.icon;
	}
	
	public void setIsMedication(boolean ismedication){
		this.ismedication = ismedication;
	}
	public boolean getIsMedication(){
		return this.ismedication;
	}
	
	public void setIsServing(boolean isserving){
		this.isserving = isserving;
	}
	public boolean getIsServing(){
		return this.isserving;
	}
	
	public void setIsScheduled(boolean isscheduled){
		this.isscheduled = isscheduled;
	}
	public boolean getIsScheduled(){
		return this.isscheduled;
	}
	
	public void setIsGoalTracked(boolean isgoaltracked){
		this.isgoaltracked = isgoaltracked;
	}
	public boolean getIsGoalTracked(){
		return this.isgoaltracked;
	}
	
	public void setIsSyncable(boolean issyncable){
		this.issyncable = issyncable;
	}
	public boolean getIsSyncable(){
		return this.issyncable;
	}
	
	public void setAllowMultiple(boolean allowmultiple){
		this.allowmultiple = allowmultiple;
	}
	public boolean getAllowMultiple(){
		return this.allowmultiple;
	}

	
	public int save(Repo repo){
		if(repo.Templates.getByTemplateTitle(this.title) == null)
			return repo.Templates.create(this);
		else
			return repo.Templates.update(this);
	}
	public int delete(Repo repo){
		return repo.Templates.delete(this);
	}

	public String toString(){
		return this.title;
	}
}
