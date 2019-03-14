package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Entity.System;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SystemDb extends SQLProvider<System>{

	private static final String TABLE_NAME = "yung_system";
	Logger logger = LogManager.getLogger(SystemDb.class);
	
	@Override
	protected void initSQLDatabase() 
	{
		try {
			statement = connect.createStatement();
			if (statement.execute("create table if not exists "
							+ TABLE_NAME +
							 " (id INTEGER PRIMARY KEY AUTOINCREMENT, location varchar(50),  destination varchar(50), distance INTEGER, fare double")) 
			{
				logger.debug("System table created");
			} 
			else
			{
				logger.debug("System table does not need to be created");
			}
			logger.debug("System table exists");
			
			} catch (SQLException e) 
			{
				e.printStackTrace();
				logger.error("Unable to initialize System Database", e);
			}				
	}

	@Override
	public int add(System item) 
	{
		try 
		{
			String sql = "INSERT INTO "+TABLE_NAME+" (location,destination,distance,fare) VALUES(?,?,?,?)"; 
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.executeUpdate();
			{
				
			}
		}
		catch(SQLException e)
		{
			
		}
		return 0;
	}

	@Override
	public List<System> selectAll() 
	{
		List<System> item = new ArrayList<System>();
		try 
		{		
			Statement stat = connect.createStatement();
			String sql = "SELECT id, location, destination, distance, fare FROM" +TABLE_NAME;
			ResultSet rs = stat.executeQuery(sql);
			if(rs != null)
				{
				while(rs.next())
					{
						System system = new System();						
						system.setId(rs.getInt("id"));
						system.setLocation(rs.getString("location"));
						system.setDestination(rs.getString("destination"));
						system.setDistance(rs.getInt("distance"));
						system.setPrice(rs.getDouble("price"));
						item.add(system);				
					}
				}
		}		
		
		catch(SQLException e) 
			{
				e.printStackTrace();
				logger.error("unable to select all System items",e);
				return null;
			}
			return item;
	}

	@Override
	public System get(int id) 
	{
		System system = new System();
		try
		{		
			Statement stat = connect.createStatement();
			String sql = "SELECT id, location, destination, distance, fare FROM" +TABLE_NAME+ " WHERE (id) ="+id;
			ResultSet rs = stat.executeQuery(sql);
			
			if(rs != null)
			{
				
				while(rs.next())
				{
					
					
					system.setId(rs.getInt("id"));
					system.setLocation(rs.getString("location"));
					system.setDestination(rs.getString("destination"));
					system.setDistance(rs.getInt("distance"));
					system.setPrice(rs.getDouble("price"));
					
				}
			}
		}
		catch(SQLException e)		
		{
			e.printStackTrace();
			logger.error("unable to retrieve system item",e);
			return null;
		}
		return system;
	}
		

	@Override
	public int update(System item, int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMultiple(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
