package com.appmite.androiddataplayground.data.repo;

import java.sql.SQLException;
import java.util.List;

import com.appmite.androiddataplayground.data.DatabaseHelper;
import com.appmite.androiddataplayground.data.models.ScheduleProperty;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

public class RepoScheduleProperty 
{
	Dao<ScheduleProperty, String> schedulePropertyDao;
	
	public RepoScheduleProperty(DatabaseHelper db)
	{
		try 
		{
			schedulePropertyDao = db.getSchedulePropertyDao();
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
	}
	
	public int create(ScheduleProperty scheduleProperty)
	{
		try {
			return schedulePropertyDao.create(scheduleProperty);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public int update(ScheduleProperty scheduleProperty)
	{
		try {
			return schedulePropertyDao.update(scheduleProperty);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public int delete(ScheduleProperty scheduleProperty)
	{
		try {
			return schedulePropertyDao.delete(scheduleProperty);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public ScheduleProperty getByName(String name)
	{		
		try 
		{
			QueryBuilder<ScheduleProperty, String> qb = schedulePropertyDao.queryBuilder();
			
			qb.where().eq("name", name);
			
			PreparedQuery<ScheduleProperty> pq = qb.prepare();
			return schedulePropertyDao.queryForFirst(pq);
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}
	
	public List<ScheduleProperty> getAll()
	{		
		try 
		{
			return schedulePropertyDao.queryForAll();
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}

}
