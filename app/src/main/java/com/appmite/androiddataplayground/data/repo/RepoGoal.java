package com.appmite.androiddataplayground.data.repo;

import java.sql.SQLException;
import java.util.List;

import com.appmite.androiddataplayground.data.DatabaseHelper;
import com.appmite.androiddataplayground.data.models.Goal;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

public class RepoGoal 
{
	Dao<Goal, String> goalDao;
	
	public RepoGoal(DatabaseHelper db)
	{
		try 
		{
			goalDao = db.getGoalDao();
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
	}
	
	public int create(Goal goal)
	{
		try {
			return goalDao.create(goal);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public int update(Goal goal)
	{
		try {
			return goalDao.update(goal);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public int delete(Goal goal)
	{
		try {
			return goalDao.delete(goal);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public Goal getGoalByTitle(String title)
	{		
		try 
		{
			QueryBuilder<Goal, String> qb = goalDao.queryBuilder();
			
			qb.where().eq("title", title);
			
			PreparedQuery<Goal> pq = qb.prepare();
			return goalDao.queryForFirst(pq);
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Goal> getAll()
	{		
		try 
		{
			return goalDao.queryForAll();
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}

}
