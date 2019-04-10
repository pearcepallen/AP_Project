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

import Entity.Support;

public class SupportDb extends SQLProvider<Support>{

	Logger logger = LogManager.getLogger(SupportDb.class);
	public static final String TABLE_NAME = "yung_Support";
	
			
	@Override
	protected void initSQLDatabase() {
		try {
			statement = connect.createStatement();
			if (statement
					.execute("CREATE TABLE if not exists "+TABLE_NAME+
							"(id INTEGER PRIMARY KEY AUTOINCREMENT, firstName VARCHAR(50), lastName VARCHAR(50), email VARCHAR(50) ,type VARCHAR(50), date VARCHAR(50), time VARCHAR(50))"))
			{
				logger.debug("Support table created");
			} 
			else
			{
				logger.debug("Support table does not need to be created");
			}
			logger.debug("Support table exists");
			
			} catch (SQLException e) 
			{
				e.printStackTrace();
				logger.error("Unable to initialize SQL database, Support Table not created ", e);
			}
	}

	@Override
	public int add(Support item) 
	{
		try{
			String query = "INSERT INTO "+TABLE_NAME
					       + "(firstName,lastName,email,type,date,time)  VALUES (?,?,?,?,?,?)";
			
			PreparedStatement ps = connect.prepareStatement(query);			
			ps.setString(1, item.getFirstName());
			ps.setString(2, item.getLastName());
			ps.setString(3, item.getEmail());
			ps.setString(4, item.getType());
			ps.setString(5, item.getDate());
			ps.setString(6, item.getTime());			
			return ps.executeUpdate();
					
    	}catch(SQLException e){
    		e.printStackTrace();
			logger.error("Unable to add Support",e);
		}
		
		return 0;
		
	}
	
	@Override
	public List<Support> selectAll() {
		List<Support> items = new ArrayList<Support>();
		try {
			Statement statement = connect.createStatement();
			String sql = "SELECT id, firstName,lastName,email,type,date,time from "+TABLE_NAME;
			ResultSet rs = statement.executeQuery(sql);
			if(rs != null) 
			{
				while(rs.next()) 
				{				
					Support Support = new Support();
					Support.setId(rs.getInt("id"));					
					Support.setFirstName(rs.getString("firstName"));
					Support.setLastName(rs.getString("lastName"));
					Support.setEmail(rs.getString("email"));
					Support.setType(rs.getString("type"));
					Support.setDate(rs.getString("date"));
					Support.setTime(rs.getString("time"));		
				
					items.add(Support);					
				}
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			logger.error("unable to select elements in Support database",e);
			return null;
		}
		return items;
	}

	
	@Override
	public Support get(int id) {
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
					Support Support = new Support();
					
					Support.setId(rs.getInt("id"));					
					Support.setFirstName(rs.getString("firstName"));
					Support.setLastName(rs.getString("lastName"));
					Support.setEmail(rs.getString("email"));
					Support.setType(rs.getString("type"));
					Support.setDate(rs.getString("date"));
					Support.setTime(rs.getString("time"));		
				
					return Support;
				}								
			}				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			logger.error("Unable to retrieve Support recorf=d",e);
		}
		return null;
	}

	
	@Override
	public int update(Support item, int id) 
	{		
		try 
		{	
			String query = " UPDATE " +TABLE_NAME+ " SET  firstName = ?, lastName = ?, email = ?, type = ?, date = ?, time = ? " +
					   " WHERE id = ?";
			PreparedStatement ps;		
			ps = connect.prepareStatement(query);				
			ps.setString(1, item.getFirstName());
			ps.setString(2, item.getLastName());
			ps.setString(3, item.getEmail());
			ps.setString(4, item.getType());
			ps.setString(5, item.getDate());
			ps.setString(6, item.getTime());		
			ps.setInt(7,id);
			return ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			logger.error("unable to update Support record",e);
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
			logger.error("Unable to delete Support Manager with id "+id,e);

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
			logger.error("unable to delete multiple",e);
		}
		return 0;
	}

	
}