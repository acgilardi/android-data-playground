package com.appmite.androiddataplayground.data.repo;

import java.sql.SQLException;
import java.util.List;

import com.appmite.androiddataplayground.data.DatabaseHelper;
import com.appmite.androiddataplayground.data.models.Profile;
import com.appmite.androiddataplayground.data.models.Template;
import com.appmite.androiddataplayground.Constants;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

public class RepoProfile 
{
	Dao<Profile, String> profileDao;
	
	public RepoProfile(DatabaseHelper db)
	{
		try 
		{
			profileDao = db.getProfileDao();
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
	}
	
	public int create(Profile profile)
	{
		try {
			return profileDao.create(profile);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public int update(Profile profile)
	{
		try {
			return profileDao.update(profile);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public int delete(Profile profile)
	{
		try {
			return profileDao.delete(profile);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	
	public Profile getById(int id)
	{
		try
		{
			Profile profile =
					profileDao.queryForFirst(
							profileDao.queryBuilder()
							.where()
							.eq(Constants.COLUMN_PROFILE_ID, id)
							.prepare());

			return profile;
		}
		catch(SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();	
		}
		
		return null;
	}
	public Profile getProfileByName(String name)
	{		
		try 
		{
			QueryBuilder<Profile, String> qb = profileDao.queryBuilder();
			
			qb.where().eq("name", name);
			
			PreparedQuery<Profile> pq = qb.prepare();
			return profileDao.queryForFirst(pq);
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Profile> getAll()
	{		
		try 
		{
			return profileDao.queryForAll();
		} 
		catch (SQLException e) 
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}

}
