package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import Entity.System1;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SystemDb extends SQLProvider<System1>{

	private static final String TABLE_NAME = "yung_system";
	Logger logger = LogManager.getLogger(SystemDb.class);
	
	@Override
	protected void initSQLDatabase() 
	{
		try {
			statement = connect.createStatement();
			if (statement
					.execute("CREATE TABLE if not exists "
							+ TABLE_NAME +
							 " (id INTEGER PRIMARY KEY AUTOINCREMENT, location varchar(50),  destination varchar(50), distance INTEGER, fare double)")) 
			{
				logger.debug("System1 table created");
			} 
			else
			{
				logger.debug("System1 table does not need to be created");
			}
			logger.debug("System1 table exists");
			
			} catch (SQLException e) 
			{
				e.printStackTrace();
				logger.error("Unable to initialize System1 Database", e);
			}				
	}

	@Override
	public int add(System1 item) 
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
	public List<System1> selectAll() 
	{
		List<System1> item = new ArrayList<System1>();
		try 
		{		
			Statement stat = connect.createStatement();
			String sql = "SELECT id, location, destination, distance, fare FROM" +TABLE_NAME;
			ResultSet rs = stat.executeQuery(sql);
			if(rs != null)
				{
				while(rs.next())
					{
						System1 system1 = new System1();						
						system1.setId(rs.getInt("id"));
						system1.setLocation(rs.getString("location"));
						system1.setDestination(rs.getString("destination"));
						system1.setDistance(rs.getInt("distance"));
						system1.setPrice(rs.getDouble("price"));
						item.add(system1);				
					}
				}
		}		
		
		catch(SQLException e) 
			{
				e.printStackTrace();
				logger.error("unable to select all System1 items",e);
				return null;
			}
			return item;
	}

	@Override
	public System1 get(int id) 
	{
		System1 system1 = new System1();
		try
		{		
			Statement stat = connect.createStatement();
			String sql = "SELECT id, location, destination, distance, fare FROM" +TABLE_NAME+ " WHERE (id) ="+id;
			ResultSet rs = stat.executeQuery(sql);
			
			if(rs != null)
			{				
				while(rs.next())
				{									
					system1.setId(rs.getInt("id"));
					system1.setLocation(rs.getString("location"));
					system1.setDestination(rs.getString("destination"));
					system1.setDistance(rs.getInt("distance"));
					system1.setPrice(rs.getDouble("price"));
					
				}
			}
		}
		catch(SQLException e)		
		{
			e.printStackTrace();
			logger.error("unable to retrieve system item",e);
			return null;
		}
		return system1;
	}
		

	@Override
	public int update(System1 item, int id) 
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
			logger.error("System1 item not updated");
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
			logger.debug("System1 record was not deleted");
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