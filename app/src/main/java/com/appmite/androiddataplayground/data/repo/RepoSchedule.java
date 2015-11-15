package com.appmite.androiddataplayground.data.repo;

import java.sql.SQLException;
import java.util.List;

import com.appmite.androiddataplayground.data.DatabaseHelper;
import com.appmite.androiddataplayground.data.models.Schedule;
import com.appmite.androiddataplayground.data.models.Template;
import com.appmite.androiddataplayground.Constants;
import com.appmite.androiddataplayground.TemplateTypes;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

public class RepoSchedule 
{
	Dao<Schedule, String> scheduleDao;
	
	public RepoSchedule(DatabaseHelper db)
	{
		try 
		{
			scheduleDao = db.getScheduleDao();
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
	}
	
	public int create(Schedule schedule)
	{
		try {
			return scheduleDao.create(schedule);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public int update(Schedule schedule)
	{
		try {
			return scheduleDao.update(schedule);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public int delete(Schedule schedule)
	{
		try {
			return scheduleDao.delete(schedule);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	
	public Schedule getByScheduleId(int scheduleId)
	{
		try 
		{
			Schedule schedule =
					scheduleDao.queryForFirst(
							scheduleDao.queryBuilder()
							.where()
							.eq(Constants.COLUMN_SCHEDULE_ID, scheduleId)
							.prepare());

			return schedule;
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;	
	}
	public Schedule getByTitle(String title)
	{		
		try 
		{
			QueryBuilder<Schedule, String> qb = scheduleDao.queryBuilder();
			
			qb.where().eq("title", title);
			
			PreparedQuery<Schedule> pq = qb.prepare();
			return scheduleDao.queryForFirst(pq);
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Schedule> getAll()
	{		
		try 
		{
			return scheduleDao.queryForAll();
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}

}
