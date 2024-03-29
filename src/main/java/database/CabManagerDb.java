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

import Entity.CabManager;

public class CabManagerDb extends SQLProvider<CabManager> {

	Logger logger = LogManager.getLogger(CabManagerDb.class);
	public static final String TABLE_NAME = "yung_CabManager";
	
			
	@Override
	protected void initSQLDatabase() {
		try {
			statement = connect.createStatement();
			if (statement
					.execute("create table if not exists "
							+ TABLE_NAME +
							 " (id INTEGER PRIMARY KEY AUTOINCREMENT, email varchar(50), password varchar(50) )")) 
			{
				logger.debug("Cab Manager table created");
			} 
			else
			{
				logger.debug("Cab Manager table does not need to be created");
			}
			logger.debug("Cab Manager table exists");
			
			} catch (SQLException e) 
			{
				e.printStackTrace();
				logger.error("Unable to initialize SQL database", e);
			}
	}

	@Override
	public int add(CabManager item) 
	{
		try{
			String query = "INSERT INTO "+TABLE_NAME
					       + "(email,password)  VALUES (?,?)";
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setString(1, item.getEmail());
			ps.setString(2, item.getPassword());
			return ps.executeUpdate();
					
    	}catch(SQLException e){
    		e.printStackTrace();
			logger.error("Unable to add CabManager",e);
		}
		
		return 0;
		
	}
	
	@Override
	public List<CabManager> selectAll() {
		List<CabManager> items = new ArrayList<CabManager>();
		try {
			Statement statement = connect.createStatement();
			String sql = "select id, email, password from "+TABLE_NAME;
			ResultSet rs = statement.executeQuery(sql);
			if(rs != null) {
				while(rs.next()) {
					CabManager CabManager = new CabManager();
					CabManager.setId( rs.getInt("id") );
					CabManager.setEmail(rs.getString("email"));
					CabManager.setPassword(rs.getString("password"));
					items.add(CabManager);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
			logger.error("unable to select all",e);
			return null;
		}
		return items;
	}

	
	
	@Override
	public CabManager get(int id) {
		try
		{
			Statement stat;
			stat = connect.createStatement();			
			String query = "Select * from " +TABLE_NAME+ " WHERE id = "+id;   
			ResultSet rs= stat.executeQuery(query);
			if(rs != null)
			{
				while(rs.next())
				{					
					CabManager cd = new CabManager();
					cd.setId(rs.getInt("id"));
					cd.setEmail(rs.getString("email"));
					cd.setPassword(rs.getString("password"));
					return cd;
				}								
			}				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			logger.error("Unable to retrieve Cab Manager",e);
		}
		return null;
	}

	@Override
	public int update(CabManager item, int id) 
	{		
		try 
		{	
			String query = " UPDATE " +TABLE_NAME+ " SET email = ?, password = ? " +
					   " WHERE id = ?";
			PreparedStatement ps;		
			ps = connect.prepareStatement(query);			
			ps.setString(1,item.getEmail());
			ps.setString(2,item.getPassword());
			ps.setInt(3,id);
			return ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			logger.error("unable to update",e);
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
			logger.error("Unable to delete Cab Manager with id "+id,e);

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
