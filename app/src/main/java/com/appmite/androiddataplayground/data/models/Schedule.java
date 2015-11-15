package com.appmite.androiddataplayground.data.models;

import java.util.Date;

import com.appmite.androiddataplayground.Frequency;
import com.appmite.androiddataplayground.data.repo.Repo;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

//CREATE TABLE "schedule" ("id" INTEGER PRIMARY KEY ,"template_id" INTEGER,
//"profile_id" INTEGER,"days" INTEGER,"title" TEXT,"description" TEXT,
//"startdate" DATE,"enddate" DATE)

@DatabaseTable
public class Schedule 
{
	@DatabaseField(generatedId = true) 
	private int id;
	
	@DatabaseField(foreign=true,foreignAutoRefresh=true)
	private Template template;
	
	@DatabaseField(foreign=true,foreignAutoRefresh=true)
	private Profile profile;
	
	@DatabaseField
	private int days;

	@DatabaseField
	private String title;
	
	@DatabaseField
	private String description;
	
	@DatabaseField
	private Date startdate;
	
	@DatabaseField
	private Date enddate;
	
	@DatabaseField
	private String frequency;
	
	@DatabaseField
	private int repeat;
	
	@DatabaseField
	private int interval;
	
	@DatabaseField
	private String endtype;
	
	@DatabaseField
	private int endeventcount;
	
	public Schedule() 
	{
		// needed by ormlite
	}
	
	public Schedule(String title, String description, int days,
			Date startdate, Date enddate, Template template, Profile profile,
			String frequency, int repeat, int interval, String endtype, int endeventcount) {
		this.title = title;
		this.description = description;
		this.days = days;
		this.startdate = startdate;
		this.enddate = enddate;
		this.template = template;
		this.profile = profile;
		this.frequency = frequency;
		this.repeat = repeat;
		this.interval = interval;
		this.endtype = endtype;
		this.endeventcount = endeventcount;
	}
	
	public void setId(int id){
		this.id = id;
	}
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

	public void setDays(int days){
		this.days = days;
	}
	public int getDays(){
		return this.days;
	}
	
	public void setStartDate(Date startdate){
		this.startdate = startdate;
	}
	public Date getStartDate(){
		return this.startdate;
	}
	
	public void setEndDate(Date enddate){
		this.enddate = enddate;
	}
	public Date getEndDate(){
		return this.enddate;
	}

	public void setTemplate(Template template){
		this.template = template;
	}
	public Template getTemplate(){
		return this.template;
	}
	
	public void setProfile(Profile profile){
		this.profile = profile;
	}
	public Profile getProfile(){
		return this.profile;
	}
	
	public void setFrequency(String frequency){
		this.frequency = frequency;
	}
	public String getFrequency() {
		return this.frequency;
	}
	
	public void setRepeat(boolean repeat){
		if(repeat)
			this.repeat = 1;
		else
			this.repeat = 0;
	}
	public boolean getRepeat(){
		if(this.repeat == 1)
			return true;
		else
			return false;
	}
	
	
	public void setInterval(int interval){
		this.interval = interval;
	}
	public int getInterval(){
		return this.interval;
	}
	
	
	public void setEndType(String endtype){
		this.endtype = endtype;
	}
	public String getEndType(){
		return this.endtype;
	}

	
	public void setEndEventCount(int endeventcount){
		this.endeventcount = endeventcount;
	}
	public int getEndEventCount(){
		return this.endeventcount;
	}

	
	
	public int save(Repo repo){		
		if(repo.Schedules.getByTitle(this.title) == null)
			return repo.Schedules.create(this);
		else
			return repo.Schedules.update(this);
	}
	public int delete(Repo repo){
		return repo.Schedules.delete(this);
	}

	public String toString(){
		return this.title;
	}
	
}
