package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
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
				ps.setString(1,item.getLocation());
				ps.setString(2,item.getDestination());
				ps.setInt(3, item.getDistance());
				ps.setDouble(4,item.getPrice());
				return ps.executeUpdate();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
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
	public int update(System item, int id) 
	{
		try 
		{				
		String sql ="UPDATE "+TABLE_NAME+ "SET location= ?, destination=?, distance=?, price=? WHERE id = ?";
		PreparedStatement ps = connect.prepareStatement(sql);
		ps.setString(1,item.getLocation());
		ps.setString(2,item.getDestination());
		ps.setInt(3,item.getDistance());
		ps.setDouble(4,item.getPrice());
		return ps.executeUpdate();
		}
		catch(SQLException e)		
		{
			e.printStackTrace();
			logger.error("System item not updated");
		}
		return 0;
	}

	@Override
	public int delete(int id) {
		try
		{								
			String sql = "DELETE * from"+TABLE_NAME+ " WHERE (id) = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1,id);
			return ps.executeUpdate();
		}
		catch(SQLException e)		
		{
			e.printStackTrace();
			logger.debug("System record was not deleted");
			return 0;
		}	
	}

	@Override
	public int deleteMultiple(int[] ids) {
		try 
		{
			String groupedIds = Arrays.toString(ids).replace("[","").replace("]","");
			String query = "DELETE FROM "+TABLE_NAME+ " WHERE id in ("+groupedIds+")";
			PreparedStatement ps = connect.prepareStatement(query);			
			return ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			logger.error("unable to update",e);
		}
		return 0;
	}

	
}
/*
papine                  			papine 			0km			0.0
papine 				hwt			3km			
papine				mountain view		6km
papine 				downtown kingston		10km
papine 				liguanea 			2km

hwt				hwt			0km
hwt				papine 			3km
hwt				mountain view		9km
hwt				downtown kingston		13km
hwt				liguanea 			5km

mountain view                                             mountain view		0km
mountain view			papine 			6km
mountain view			hwt			9km
mountain view			downtown kingston		4km
mountain view			liguanea 			4km

downtown kingston			downtown kingston		0km
downtown kingston			liguanea 			8km
downtown kingston			papine 			10km
downtown kingston			hwt			13km
downtown kingston			mountain view		4km

liguanea				liguanea			0km
liguanea				papine 			2km
liguanea				hwt			5km
liguanea				mountain view		4km
liguanea				downtown kingston		8km
*/