package com.appmite.androiddataplayground.data.repo;

import java.sql.SQLException;
import java.util.List;

import com.appmite.androiddataplayground.data.DatabaseHelper;
import com.appmite.androiddataplayground.data.models.Preference;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

public class RepoPreference 
{
	Dao<Preference, String> preferenceDao;
	
	public RepoPreference(DatabaseHelper db)
	{
		try 
		{
			preferenceDao = db.getPreferenceDao();
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
	}
	
	public int create(Preference preference)
	{
		try {
			return preferenceDao.create(preference);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public int update(Preference preference)
	{
		try {
			return preferenceDao.update(preference);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public int delete(Preference preference)
	{
		try {
			return preferenceDao.delete(preference);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public Preference getByName(String name)
	{		
		try 
		{
			QueryBuilder<Preference, String> qb = preferenceDao.queryBuilder();
			
			qb.where().eq("name", name);
			
			PreparedQuery<Preference> pq = qb.prepare();
			return preferenceDao.queryForFirst(pq);
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Preference> getAll()
	{		
		try 
		{
			return preferenceDao.queryForAll();
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}

}
