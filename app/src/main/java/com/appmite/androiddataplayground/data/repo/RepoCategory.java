package com.appmite.androiddataplayground.data.repo;

import java.sql.SQLException;
import java.util.List;


import com.appmite.androiddataplayground.data.DatabaseHelper;
import com.appmite.androiddataplayground.data.models.Category;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

public class RepoCategory
{
	Dao<Category, String> categoryDao;
	
	public RepoCategory(DatabaseHelper db)
	{
		try 
		{
			categoryDao = db.getCategoryDao();
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
	}
	
	public int create(Category category)
	{
		try {
			return categoryDao.create(category);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public int update(Category category)
	{
		try {
			return categoryDao.update(category);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public int delete(Category category)
	{
		try {
			return categoryDao.delete(category);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public Category getByCategoryName(String categoryName)
	{		
		try 
		{
			QueryBuilder<Category, String> qb = categoryDao.queryBuilder();
			
			qb.where().eq("CategoryName", categoryName);
			
			PreparedQuery<Category> pq = qb.prepare();
			return categoryDao.queryForFirst(pq);
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}
	public List<Category> getAll()
	{		
		try 
		{
			return categoryDao.queryForAll();
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}

}
