/*package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Entity.DistanceModel;
 
public class DistanceReportDb extends SQLProvider<DistanceModel>
{

	Logger logger = LogManager.getLogger(CabDb.class);
	public static final String TABLE_NAME = "yung_distanceReport";
	
	@Override
	protected void initSQLDatabase() {
		try {
			statement = connect.createStatement();
			if (statement
					.execute("CREATE TABLE if not exists "+TABLE_NAME+
							"(id INTEGER PRIMARY KEY AUTOINCREMENT, Cab_id INTEGER, distance INTEGER, fare double)"))
			{
				logger.debug("DistanceModel table created");
			} 
			else
			{
				logger.debug("DistanceModel table does not need to be created");
			}
			logger.debug("DistanceModel table exists");
			
			} catch (SQLException e) 
			{
				e.printStackTrace();
				logger.error("Unable to initialize SQL Database, DistanceModel Table not created ", e);
			}
	}

	@Override
	public int add(DistanceModel item) 
	{
		try{
			String query = "INSERT INTO "+TABLE_NAME
					       + "(id,Cab_id,distance,fare)  VALUES (?,?,?,?)";
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setInt(1, item.getId());
			ps.setInt(2, item.getC_id());
			ps.setDouble(3,item.getFare());
			ps.setInt(4, item.getDistance());
			return ps.executeUpdate();
					
    	}catch(SQLException e){
    		e.printStackTrace();
			logger.error("Unable to add DistanceModel",e);
		}
		
		return 0;		
	}
	
	@Override
	public List<DistanceModel> selectAll() {
		List<DistanceModel> items = new ArrayList<DistanceModel>();
		try {
			Statement statement = connect.createStatement();
			String sql = "SELECT id, Cab_id,distance,fare from "+TABLE_NAME;
			ResultSet rs = statement.executeQuery(sql);
			if(rs != null) 
			{
				while(rs.next()) 
				{				
					DistanceModel DistanceModel = new DistanceModel();
					DistanceModel.setId(rs.getInt("id"));
					DistanceModel.setC_id(rs.getInt("Cab_id"));
					DistanceModel.setDistance(rs.getInt("distance"));
					DistanceModel.setFare(rs.getDouble("fare"));						
					items.add(DistanceModel);					
				}
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			logger.error("unable to select elements in DistanceModel database",e);
			return null;
		}
		return items;
	}

	
	
	@Override
	public DistanceModel get(int id) {
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
					DistanceModel DistanceModel = new DistanceModel();
					DistanceModel.setId(rs.getInt("id"));
					DistanceModel.setC_id(rs.getInt("Cab_id"));
					DistanceModel.setDistance(rs.getInt("distance"));
					DistanceModel.setFare(rs.getDouble("fare"));							
					return DistanceModel;
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
	public int update(DistanceModel item, int id) 
	{		
		try 
		{	
			String query = " UPDATE " +TABLE_NAME+ " SET  Cab_id = ?, fare = ? , distance = ?" +
					   " WHERE id = ?";
			PreparedStatement ps;		
			ps = connect.prepareStatement(query);	
			ps.setInt(1, item.getC_id());
			ps.setInt(2, item.getDistance());
			ps.setDouble(3,item.getFare());
			ps.setInt(4,id);
			return ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			logger.error("unable to update DistanceModel record",e);
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
			logger.error("Unable to delete DistanceModel with id "+id,e);

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
			logger.error("unable to delete multiple from DistanceModel",e);
		}
		return 0;
	}


	
}*/