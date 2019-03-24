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

import Entity.RequestModel;


public class RequestModelDb extends SQLProvider <RequestModel>  {

	Logger logger = LogManager.getLogger(RequestModelDb.class);
	public static final String TABLE_NAME = "yung_Request";
	
			
	@Override
	protected void initSQLDatabase() {
		try {
			statement = connect.createStatement();
			if (statement
					.execute("CREATE TABLE if not exists "+TABLE_NAME+
							"(id INTEGER PRIMARY KEY AUTOINCREMENT, req_id INTEGER, c_number INTEGER, c_id INTEGER, location VARCHAR(50), destination VARCHAR(50), distance INT, fare DOUBLE)"))
			{
				logger.debug("RequestModel table created");
			} 
			else
			{
				logger.debug("RequestModel table does not need to be created");
			}
			logger.debug("RequestModel table exists");
			
			} catch (SQLException e) 
			{
				e.printStackTrace();
				logger.error("Unable to initialize SQL database, RequestModel Table not created ", e);
			}
	}

	@Override
	public int add(RequestModel item) 
	{
		try{
			String query = "INSERT INTO "+TABLE_NAME
					       + "(req_id, c_number, c_id, location, destination, distance, fare)  VALUES (?,?,?,?,?,?,?)";
			PreparedStatement ps = connect.prepareStatement(query);			
			ps.setInt(1, item.getReq_id());
			ps.setInt(2, item.getC_number());
			ps.setInt(3, item.getC_id());
			ps.setString(4, item.getLocation());
			ps.setString(5, item.getDestination());
			ps.setInt(6, item.getDistance());
			ps.setDouble(7, item.getFare());
			return ps.executeUpdate();
					
    	}catch(SQLException e){
    		e.printStackTrace();
			logger.error("Unable to add RequestModel",e);
		}
		
		return 0;
		
	}
	
	@Override
	public List<RequestModel> selectAll() {
		List<RequestModel> items = new ArrayList<RequestModel>();
		try {
			Statement statement = connect.createStatement();
			String sql = "SELECT req_id, c_number, c_id, location, destination, distance, fare"+TABLE_NAME;
			ResultSet rs = statement.executeQuery(sql);
			if(rs != null) 
			{
				while(rs.next()) 
				{				
					RequestModel RequestModel = new RequestModel();
					RequestModel.setReq_id(rs.getInt("req_id"));					
					RequestModel.setC_number(rs.getInt("c_number"));
					RequestModel.setC_id(rs.getInt("c_id"));
					RequestModel.setLocation(rs.getString("location"));
					RequestModel.setDestination(rs.getString("destination"));
					RequestModel.setDistance(rs.getInt("distance"));
					RequestModel.setFare(rs.getDouble("fare"));
					
					items.add(RequestModel);					
				}
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			logger.error("unable to select elements in RequestModel database",e);
			return null;
		}
		return items;
	}

	
	@Override
	public RequestModel get(int id) {
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
					RequestModel RequestModel = new RequestModel();
					RequestModel.setReq_id(rs.getInt("req_id"));					
					RequestModel.setC_number(rs.getInt("c_number"));
					RequestModel.setC_id(rs.getInt("c_id"));
					RequestModel.setLocation(rs.getString("location"));
					RequestModel.setDestination(rs.getString("destination"));
					RequestModel.setDistance(rs.getInt("distance"));
					RequestModel.setFare(rs.getDouble("fare"));
					
					return RequestModel;
				}								
			}				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			logger.error("Unable to retrieve RequestModel recorf=d",e);
		}
		return null;
	}

	
	@Override
	public int update(RequestModel item, int id) 
	{		
		try 
		{	
			String query = " UPDATE " +TABLE_NAME+ " SET req_id = ?, c_number = ?, c_id = ?, location = ?, destination = ?, distance = ? , fare = ?" +
					   " WHERE id = ?";
			//req_id, c_number, c_id, location, destination, distance, fare
			PreparedStatement ps;		
			ps = connect.prepareStatement(query);				
			ps.setInt(1, item.getReq_id());
			ps.setInt(2, item.getC_number());
			ps.setInt(3, item.getC_id());
			ps.setString(4, item.getLocation());
			ps.setString(5,item.getDestination());
			ps.setInt(6,item.getDistance());
			ps.setDouble(7,item.getFare());
			ps.setInt(8,id);
			return ps.executeUpdate();
		} 
		/*RequestModel RequestModel = new RequestModel();
					RequestModel.setReq_id(rs.getInt("req_id"));					
					RequestModel.setC_number(rs.getInt("c_number"));
					RequestModel.setC_id(rs.getInt("c_id"));
					RequestModel.setLocation(rs.getString("location"));
					RequestModel.setDestination(rs.getString("destination"));*/
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			logger.error("unable to update RequestModel record",e);
		}
		return 0;
	}
	

	@Override
	public int delete(int id) 
	{
		try 
		{
			String query = "DELETE FROM "+TABLE_NAME+ " WHERE id = ?";
			PreparedStatement ps = connect.prepareStatement(query);			
			ps.setInt(1,id);
			return ps.executeUpdate();
		}
	
		catch (SQLException e) 
		{
			e.printStackTrace();
			logger.error("Unable to delete RequestModel Manager with c_id "+id,e);

		}
		return 0;
	}

	@Override
	public int deleteMultiple(int[] ids)
	{
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


