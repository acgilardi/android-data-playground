package com.appmite.androiddataplayground.data.models;

import com.appmite.androiddataplayground.data.repo.Repo;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

//CREATE TABLE "templateproperty" ("id" INTEGER PRIMARY KEY ,"template_id" INTEGER, 
//"name" TEXT, "initialvalue" TEXT)

@DatabaseTable
public class TemplateProperty 
{
	@DatabaseField(generatedId = true) 
	private int id;
	
	@DatabaseField(foreign=true,foreignAutoRefresh=true)
	private Template template;
	
	@DatabaseField
	private String name;
	
	@DatabaseField
	private String initialvalue;

	
	public TemplateProperty() 
	{
		// needed by ormlite
	}
	
	public TemplateProperty(String name, String initialvalue, Template template) {
		this.name = name;
		this.initialvalue = initialvalue;
		this.template = template;
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
	
	public void setInitialValue(String initialvalue){
		this.initialvalue = initialvalue;
	}
	public String getInitialValue() 
	{
		return this.initialvalue;
	}
	
	public void setTemplate(Template template){
		this.template = template;
	}
	public Template getTemplate(){
		return this.template;
	}


	
	public int save(Repo repo){
		if(repo.TemplateProperties.getByName(this.name) == null)
			return repo.TemplateProperties.create(this);
		else
			return repo.TemplateProperties.update(this);
	}
	public int delete(Repo repo){
		return repo.TemplateProperties.delete(this);
	}

	public String toString(){
		return this.name;
	}
	
}
