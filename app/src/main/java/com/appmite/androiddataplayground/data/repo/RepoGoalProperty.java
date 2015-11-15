package com.appmite.androiddataplayground.data.repo;

import java.sql.SQLException;
import java.util.List;

import com.appmite.androiddataplayground.data.DatabaseHelper;
import com.appmite.androiddataplayground.data.models.GoalProperty;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

public class RepoGoalProperty 
{
	Dao<GoalProperty, String> goalPropertyDao;
	
	public RepoGoalProperty(DatabaseHelper db)
	{
		try 
		{
			goalPropertyDao = db.getGoalPropertyDao();
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
	}
	
	public int create(GoalProperty goalProperty)
	{
		try {
			return goalPropertyDao.create(goalProperty);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public int update(GoalProperty goalProperty)
	{
		try {
			return goalPropertyDao.update(goalProperty);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public int delete(GoalProperty goalProperty)
	{
		try {
			return goalPropertyDao.delete(goalProperty);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public GoalProperty getByName(String name)
	{		
		try 
		{
			QueryBuilder<GoalProperty, String> qb = goalPropertyDao.queryBuilder();
			
			qb.where().eq("name", name);
			
			PreparedQuery<GoalProperty> pq = qb.prepare();
			return goalPropertyDao.queryForFirst(pq);
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}
	
	public List<GoalProperty> getAll()
	{		
		try 
		{
			return goalPropertyDao.queryForAll();
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}

}
