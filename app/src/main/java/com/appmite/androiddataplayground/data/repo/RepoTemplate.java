package com.appmite.androiddataplayground.data.repo;

import java.sql.SQLException;
import java.util.List;

import com.appmite.androiddataplayground.data.DatabaseHelper;
import com.appmite.androiddataplayground.data.models.Template;
import com.appmite.androiddataplayground.TemplateTypes;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

public class RepoTemplate 
{
	Dao<Template, String> templateDao;
	
	public RepoTemplate(DatabaseHelper db)
	{
		try 
		{
			templateDao = db.getTemplateDao();
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
	}
	
	public int create(Template template)
	{
		try {
			return templateDao.create(template);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public int update(Template template)
	{
		try {
			return templateDao.update(template);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public int delete(Template template)
	{
		try {
			return templateDao.delete(template);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public Template getByTemplateTitle(String title)
	{		
		try 
		{
			QueryBuilder<Template, String> qb = templateDao.queryBuilder();
			
			qb.where().eq("title", title);
			
			PreparedQuery<Template> pq = qb.prepare();
			return templateDao.queryForFirst(pq);
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}
	
	public Template getByTemplateType(TemplateTypes type)
	{
		try 
		{
			Template template =
					templateDao.queryForFirst(
							templateDao.queryBuilder()
							.where()
							.eq("type", type)
							.prepare());

			return template;
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;	
	}
	public List<Template> getAll()
	{		
		try 
		{
			//orderBy(String columnName, boolean ascending)
			// query for all accounts that have that password
			List<Template> templateList =
					templateDao.query(
							templateDao.queryBuilder()
							.orderBy("category_id", true)
							.prepare());
			//return templateDao.queryForAll();
			
			//templateDao.queryRaw("Select * from template order by category_id");
			//List<Template>
			
			return templateList;
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}

}
