package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Entity.Customer;

public class CustomerDb extends SQLProvider<Customer>{

	
	Logger logger = LogManager.getLogger(CustomerDb.class);
	public static final String TABLE_NAME = "yung_Customer";
	
			
	@Override
	protected void initSQLDatabase() {
		try {
			statement = connect.createStatement();
			if (statement
					.execute("create table if not exists "
							+ TABLE_NAME +
							 " (id INTEGER PRIMARY KEY AUTOINCREMENT, location varchar(50),  destination varchar(50), number INTEGER, feedback varchar(500)")) 
			{
				logger.debug("Customer table created");
			} 
			else
			{
				logger.debug("Customer table does not need to be created");
			}
			logger.debug("Customer table exists");
			
			} catch (SQLException e) 
			{
				e.printStackTrace();
				logger.error("Unable to initialize SQL Database", e);
			}
	}

	@Override
	public int add(Customer item) 
	{
		
		try{
			String query = "INSERT INTO "+TABLE_NAME
					       + "(location,destination,number,feedback)  VALUES (?,?,?,?)";
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setString(1, item.getLocation());
			ps.setString(2, item.getDestination());
			ps.setInt(3,item.getNumber());
			ps.setString(4,item.getFeedback());
			return ps.executeUpdate();
					
    	}
		catch(SQLException e)
		{
    		e.printStackTrace();
			logger.error("Unable to add Customer",e);
		}
		
		return 0;
		
	}
	
	@Override
	public List<Customer> selectAll() {
		List<Customer> items = new ArrayList<Customer>();
		try {
			Statement statement = connect.createStatement();
			String sql = "select id, location,destination,number,feedback from "+TABLE_NAME;
			ResultSet rs = statement.executeQuery(sql);
			if(rs != null) {
				while(rs.next()) {
					Customer Customer = new Customer (); 
					Customer.setLocation(rs.getString("location"));
					Customer.setDestination(rs.getString("destination"));
					Customer.setNumber(rs.getInt("number"));
					Customer.setFeedback(rs.getString("feedback"));
					items.add(Customer);
				}
			}
		}catch(SQLException e) 
		{
			e.printStackTrace();
			logger.error("unable to select all",e);
			return null;
		}
		return items;
	}

	
	
	@Override
	public Customer get(int id) {
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
					Customer Customer = new Customer();
					Customer.setLocation(rs.getString("location"));
					Customer.setDestination(rs.getString("destination"));
					Customer.setNumber(rs.getInt("number"));
					Customer.setFeedback(rs.getString("feedback"));
					return Customer;
				}								
			}				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			logger.error("Unable to retrieve Customer",e);
		}
		return null;
	}

	@Override
	public int update(Customer item, int id) 
	{		
		try 
		{	
			String query = " UPDATE " +TABLE_NAME+ " SET  location = ?, destination = ?, number = ?, feedback = ?" +
					   " WHERE id = ?";
			PreparedStatement ps;		
			ps = connect.prepareStatement(query);			
			ps.setString(1, item.getLocation());
			ps.setString(2, item.getDestination());
			ps.setInt(3,item.getNumber());
			ps.setString(4,item.getFeedback());
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
			logger.error("Unable to delete Customer with id "+id,e);

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
