package com.appmite.androiddataplayground.data.models;




import java.util.Date;

import com.appmite.androiddataplayground.data.repo.Repo;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

//CREATE TABLE "goal" ("id" INTEGER PRIMARY KEY ,"profile_id" INTEGER,"template_id" INTEGER,"title" TEXT,"description" TEXT,
//"goaldate" DATE,"syncdate" DATETIME,"metgoal" BOOL,"thingid_guid" TEXT,"thingversion_guid" TEXT,
//"lastupdate" DATE)

@DatabaseTable
public class Goal 
{
	@DatabaseField(generatedId = true) 
	private int id;
	
	@DatabaseField
	private String title;
	
	@DatabaseField
	private String description;
	
	@DatabaseField(foreign=true,foreignAutoRefresh=true)
	private Profile profile;
	
	@DatabaseField(foreign=true,foreignAutoRefresh=true)
	private Template template;

	@DatabaseField
	private Date goaldate;

	@DatabaseField
	private Date syncdate;
	
	@DatabaseField
	private boolean metgoal;
	
	@DatabaseField
	private String thingid_guid;
	
	@DatabaseField
	private String thingversion_guid;
	
	@DatabaseField
	private Date lastupdate;
	
	
	public Goal() 
	{
		// needed by ormlite
	}
	
	public Goal(String title, String description, Profile profile, Template template, Date goaldate, Date lastupdate) {
		this.title = title;
		this.description = description;
		this.profile = profile;
		this.template = template;
		this.goaldate = goaldate;
		this.lastupdate = lastupdate;
	}
	
//	public void setId(int id){
//		this.id = id;
//	}
	public int getId(){
		return this.id;
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
	
	public void setProfile(Profile profile){
		this.profile = profile;
	}
	public Profile getProfile(){
		return this.profile;
	}
	
	public void setTemplate(Template template){
		this.template = template;
	}
	public Template getTemplate(){
		return this.template;
	}


	
	public void setGoalDate(Date goaldate){
		this.goaldate = goaldate;
	}
	public Date getGoalDate(){
		return this.goaldate;
	}
	
	public void setSyncDate(Date syncdate){
		this.syncdate = syncdate;
	}
	public Date getSyncDate(){
		return this.syncdate;
	}
	
	public void setLastUpdate(Date lastupdate){
		this.lastupdate = lastupdate;
	}
	public Date getLastUpdate(){
		return this.lastupdate;
	}
	
	public void setMetGoal(boolean metgoal){
		this.metgoal = metgoal;
	}
	public boolean getMetGoal(){
		return this.metgoal;
	}
	
	public void setThingIdGuid(String thingid_guid){
		this.thingid_guid = thingid_guid;
	}
	public String getThingIdGuid(){
		return this.thingid_guid;
	}
	
	public void setThingVersionGuild(String thingversion_guid){
		this.thingversion_guid = thingversion_guid;
	}
	public String getThingVersionGuild(){
		return this.thingversion_guid;
	}


	
	public int save(Repo repo){
		if(repo.Goals.getGoalByTitle(this.title) == null)
			return repo.Goals.create(this);
		else
			return repo.Goals.update(this);
	}
	public int delete(Repo repo){
		return repo.Goals.delete(this);
	}

	public String toString(){
		return this.title;
	}
	
}
