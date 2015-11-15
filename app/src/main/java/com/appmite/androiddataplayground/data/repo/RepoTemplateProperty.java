package com.appmite.androiddataplayground.data.repo;

import java.sql.SQLException;
import java.util.List;

import com.appmite.androiddataplayground.data.DatabaseHelper;
import com.appmite.androiddataplayground.data.models.Template;
import com.appmite.androiddataplayground.data.models.TemplateProperty;
import com.appmite.androiddataplayground.Constants;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

public class RepoTemplateProperty 
{
	Dao<TemplateProperty, String> templatePropertyDao;
	
	public RepoTemplateProperty(DatabaseHelper db)
	{
		try 
		{
			templatePropertyDao = db.getTemplatePropertyDao();
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
	}
	
	public int create(TemplateProperty goalProperty)
	{
		try {
			return templatePropertyDao.create(goalProperty);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public int update(TemplateProperty goalProperty)
	{
		try {
			return templatePropertyDao.update(goalProperty);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public int delete(TemplateProperty goalProperty)
	{
		try {
			return templatePropertyDao.delete(goalProperty);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public TemplateProperty getByName(String name)
	{		
		try 
		{
			QueryBuilder<TemplateProperty, String> qb = templatePropertyDao.queryBuilder();
			
			qb.where().eq("name", name);
			
			PreparedQuery<TemplateProperty> pq = qb.prepare();
			return templatePropertyDao.queryForFirst(pq);
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}
	
	public List<TemplateProperty> getByTemplate(Template template)
	{
		try
		{
			List<TemplateProperty> templateProperties =
					templatePropertyDao.query(
							templatePropertyDao.queryBuilder()
							.where()
							.eq(Constants.COLUMN_TEMPLATEPROPERTY_TEMPLATE_ID, template.getId())
							.prepare());

			return templateProperties;
		}
		catch(SQLException e){
			//TODO: Exception handling
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<TemplateProperty> getAll()
	{		
		try 
		{
			return templatePropertyDao.queryForAll();
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}

}
