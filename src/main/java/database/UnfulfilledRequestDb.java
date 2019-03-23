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

import Entity.UnfulfilledRequest;

public class UnfulfilledRequestDb extends SQLProvider <UnfulfilledRequest> 
{
	Logger logger = LogManager.getLogger(UnfulfilledRequest.class);
	public static final String TABLE_NAME = "yung_UnfulfilledRequest";
	
			
	@Override
	protected void initSQLDatabase() {
		try {
			statement = connect.createStatement();
			if (statement
					.execute("CREATE TABLE if not exists "+TABLE_NAME+
							"(c_id INTEGER PRIMARY KEY AUTOINCREMENT, c_number INTEGER)"))
			{
				logger.debug("UnfulfilledRequest table created");
			} 
			else
			{
				logger.debug("UnfulfilledRequest table does not need to be created");
			}
			logger.debug("UnfulfilledRequest table exists");
			
			} catch (SQLException e) 
			{
				e.printStackTrace();
				logger.error("Unable to initialize SQL database, UnfulfilledRequest Table not created ", e);
			}
	}

	@Override
	public int add(UnfulfilledRequest item) 
	{
		try{
			String query = "INSERT INTO "+TABLE_NAME
					       + "(trn,year,model,name,available,fare,distance)  VALUES (?,?,?,?,?,?,?)";
			PreparedStatement ps = connect.prepareStatement(query);			
			ps.setInt(1, item.getC_id());
			ps.setInt(2, item.getC_number());
			return ps.executeUpdate();
					
    	}catch(SQLException e){
    		e.printStackTrace();
			logger.error("Unable to add unfulfilled request",e);
		}
		
		return 0;
		
	}
	
	@Override
	public List<UnfulfilledRequest> selectAll() {
		List<UnfulfilledRequest> items = new ArrayList<UnfulfilledRequest>();
		try {
			Statement statement = connect.createStatement();
			String sql = "SELECT c_id, c_name from "+TABLE_NAME;
			ResultSet rs = statement.executeQuery(sql);
			if(rs != null) 
			{
				while(rs.next()) 
				{				
					UnfulfilledRequest UnfulfilledRequest = new UnfulfilledRequest();
					UnfulfilledRequest.setC_id(rs.getInt("c_id"));					
					UnfulfilledRequest.setC_number(rs.getInt("c_number"));
					items.add(UnfulfilledRequest);					
				}
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			logger.error("unable to select elements in UnfulfilledRequest database",e);
			return null;
		}
		return items;
	}

	
	@Override
	public UnfulfilledRequest get(int id) {
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
					UnfulfilledRequest UnfulfilledRequest = new UnfulfilledRequest();
					UnfulfilledRequest.setC_id(rs.getInt("c_id"));	
					UnfulfilledRequest.setC_number(rs.getInt("c_name"));
					return UnfulfilledRequest;
				}								
			}				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			logger.error("Unable to retrieve UnfulfilledRequest record=d",e);
		}
		return null;
	}

	
	@Override
	public int update(UnfulfilledRequest item, int id) 
	{		
		try 
		{	
			String query = " UPDATE " +TABLE_NAME+ " SET  c_id = ?, c_name = ?, model = ?, name = ?, available = ?, fare = ? , distance = ?" +
					   " WHERE c_id = ?";
			PreparedStatement ps;		
			ps = connect.prepareStatement(query);				
			ps.setInt(1, item.getC_id());
			ps.setInt(2, item.getC_number());
			ps.setInt(3,id);
			return ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			logger.error("unable to update UnfulfilledRequest record",e);
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
			logger.error("Unable to delete UnfulfilledRequest Manager with c_id "+id,e);

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
