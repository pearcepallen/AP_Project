package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import Entity.Cab;


public class CabDb extends SQLProvider <Cab>
{

	Logger logger = LogManager.getLogger(CabDb.class);
	public static final String TABLE_NAME = "yung_Cab";
	
			
	@Override
	protected void initSQLDatabase() {
		try {
			statement = connect.createStatement();
			if (statement
					.execute("CREATE TABLE if not exists "+TABLE_NAME+
							"(c_id INTEGER PRIMARY KEY AUTOINCREMENT, trn	INTEGER, year INTEGER, model VARCHAR(50), name VARCHAR(50), available BOOLEAN, fare double, distance INTEGER)"))
			{
				logger.debug("Cab table created");
			} 
			else
			{
				logger.debug("Cab table does not need to be created");
			}
			logger.debug("Cab table exists");
			
			} catch (SQLException e) 
			{
				e.printStackTrace();
				logger.error("Unable to initialize SQL database, Cab Table not created ", e);
			}
	}

	@Override
	public int add(Cab item) 
	{
		try{
			String query = "INSERT INTO "+TABLE_NAME
					       + "(trn,year,model,name,available,fare,distance)  VALUES (?,?,?,?,?,?,?)";
			PreparedStatement ps = connect.prepareStatement(query);			
			ps.setInt(1, item.getTrn());
			ps.setInt(2, item.getYear());
			ps.setString(3, item.getModel());
			ps.setString(4, item.getName());
			ps.setBoolean(5,item.isAvailable());
			ps.setDouble(6,item.getFare());
			ps.setInt(7, item.getDistance());
			return ps.executeUpdate();
					
    	}catch(SQLException e){
    		e.printStackTrace();
			logger.error("Unable to add Cab",e);
		}
		
		return 0;
		
	}
	
	@Override
	public List<Cab> selectAll() {
		List<Cab> items = new ArrayList<Cab>();
		try {
			Statement statement = connect.createStatement();
			String sql = "SELECT c_id, trn,year,model,name,available,fare,distance from "+TABLE_NAME;
			ResultSet rs = statement.executeQuery(sql);
			if(rs != null) 
			{
				while(rs.next()) 
				{				
					Cab Cab = new Cab();
					Cab.setC_id(rs.getInt("c_id"));					
					Cab.setTrn(rs.getInt("trn"));
					Cab.setYear(rs.getInt("year"));
					Cab.setModel(rs.getString("model"));
					Cab.setName(rs.getString("name"));
					Cab.setAvailable(rs.getBoolean("available"));
					Cab.setFare(rs.getDouble("fare"));		
					Cab.setDistance(rs.getInt("distance"));
					items.add(Cab);					
				}
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			logger.error("unable to select elements in Cab database",e);
			return null;
		}
		return items;
	}

	
	@Override
	public Cab get(int id) {
		try
		{
			Statement stat;
			stat = connect.createStatement();			
			String query = "Select * from " +TABLE_NAME+ " WHERE c_id = "+id;   
			ResultSet rs= stat.executeQuery(query);
			if(rs != null)
			{
				while(rs.next())
				{					
					Cab Cab = new Cab();
					Cab.setC_id(rs.getInt("c_id"));					
					Cab.setTrn(rs.getInt("trn"));
					Cab.setYear(rs.getInt("year"));
					Cab.setModel(rs.getString("model"));
					Cab.setName(rs.getString("name"));
					Cab.setAvailable(rs.getBoolean("available"));
					Cab.setFare(rs.getDouble("fare"));			
					Cab.setDistance(rs.getInt("distance"));
					return Cab;
				}								
			}				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			logger.error("Unable to retrieve Cab recorf=d",e);
		}
		return null;
	}

	
	@Override
	public int update(Cab item, int id) 
	{		
		try 
		{	
			String query = " UPDATE " +TABLE_NAME+ " SET  trn = ?, year = ?, model = ?, name = ?, available = ?, fare = ? , distance = ?" +
					   " WHERE c_id = ?";
			PreparedStatement ps;		
			ps = connect.prepareStatement(query);				
			ps.setInt(1, item.getTrn());
			ps.setInt(2, item.getYear());
			ps.setString(3, item.getModel());
			ps.setString(4, item.getName());
			ps.setBoolean(5,item.isAvailable());
			ps.setDouble(6,item.getFare());
			ps.setInt(7, item.getDistance());
			ps.setInt(8,id);
			return ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			logger.error("unable to update Cab record",e);
		}
		return 0;
	}
	

	@Override
	public int delete(int id) 
	{
		try 
		{
			String query = "DELETE FROM "+TABLE_NAME+ " WHERE c_id = ?";
			PreparedStatement ps = connect.prepareStatement(query);			
			ps.setInt(1,id);
			return ps.executeUpdate();
		}
	
		catch (SQLException e) 
		{
			e.printStackTrace();
			logger.error("Unable to delete Cab Manager with c_id "+id,e);

		}
		return 0;
	}

	@Override
	public int deleteMultiple(int[] ids)
	{
		try 
		{
			String groupedIds = Arrays.toString(ids).replace("[","").replace("]","");
			String query = "DELETE FROM "+TABLE_NAME+ " WHERE c_id in ("+groupedIds+")";
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
