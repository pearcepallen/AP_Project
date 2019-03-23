package database;
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
							 " (id INTEGER PRIMARY KEY AUTOINCREMENT, location varchar(50),  destination varchar(50), distance INTEGER, price double)")) 
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
			String sql = "INSERT INTO "+TABLE_NAME
					+" (location,destination,distance,price) VALUES (?,?,?,?)"; 
			PreparedStatement ps = connect.prepareStatement(sql);
			
				ps.setString(1,item.getLocation());
				ps.setString(2,item.getDestination());
				ps.setInt(3, item.getDistance());
				ps.setDouble(4,item.getPrice());
				return ps.executeUpdate();
			
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
			String sql = "SELECT id, location, destination, distance, price FROM " +TABLE_NAME;
			logger.trace(sql);
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
			String sql = "SELECT id, location, destination, distance, price FROM" +TABLE_NAME+ " WHERE (id) ="+id;
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
			String sql = "DELETE * from "+TABLE_NAME+ " WHERE (id) = ?";
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

	public int populateDb()
	{
		SQLProvider<System1> db  = new SystemDb();	
		
		int max = 0;	
		logger.info("populating System Database");
		max = db.add(new System1(1,"papine","papine",0,0.0))
				+db.add(new System1(2,"papine","hwt",3,410.0))
				+db.add(new System1(3,"papine","mountain view",6,470.0))
				+db.add(new System1(4,"papine","downtown kingston",10,550.0))
				+db.add(new System1(5,"papine","liguanea",2,390.0))
				
				+db.add(new System1(6,"hwt","hwt",0,0.0))
				+db.add(new System1(7,"hwt","papine",3,410.0))
				+db.add(new System1(8,"hwt","mountain view",9,530.0))
				+db.add(new System1(9,"hwt","downtown kingston",13,610.0))
				+db.add(new System1(10,"hwt","liguanea",5,450.0))
				
				+db.add(new System1(11,"mountain view","mountain view",0,0.0))
				+db.add(new System1(12,"mountain view","papine",6,470.0))
				+db.add(new System1(13,"mountain view","hwt",9,530.0))
				+db.add(new System1(14,"mountain view","downtown kingston",4,430.0))
				+db.add(new System1(15,"mountain view","liguanea",4,430.0))
				
				+db.add(new System1(16,"downtown kingston","downtown kingston",0,0.0))
				+db.add(new System1(17,"downtown kingston","liguanea",8,510.0))
				+db.add(new System1(18,"downtown kingston","papine",10,550.0))
				+db.add(new System1(19,"downtown kingston","hwt",13,610.0))
				+db.add(new System1(20,"downtown kingston kingston","mountain view",4,430.0))
				
				+db.add(new System1(21,"liguanea","liguanea",0,0.0))
				+db.add(new System1(22,"liguanea","papine",2,390.0))
				+db.add(new System1(23,"liguanea","hwt",5,450.0))
				+db.add(new System1(24,"liguanea","mountain view",4,430.0))
				+db.add(new System1(25,"liguanea","downtown kingston",8,510.0));
				
		return max;
	

	
}
}
	


/*
papine              		papine 					0 			0.0
papine 						hwt						3 			410.0
papine						mountain view			6 			470.0
papine 						downtown kingston		10 		550.0
papine 						liguanea 				2 			390.0

hwt							hwt						0 			0.0
hwt							papine 					3 			410.0
hwt							mountain view			9 			530.0
hwt							downtown kingston		13 		610.0
hwt							liguanea 				5 			450.0

mountain view               mountain view			0 			0.0
mountain view				papine 					6 			470.0
mountain view				hwt						9 			530.0
mountain view				downtown kingston		4 			430.0
mountain view				liguanea 				4 			430.0

downtown kingston			downtown kingston		0 			0.0
downtown kingston			liguanea 				8 			510.0
downtown kingston			papine 					10 		550.0
downtown kingston			hwt						13 		610.0
downtown kingston			mountain view			4 			430.0

liguanea					liguanea				0 			0.0
liguanea					papine 					2 			390.0
liguanea					hwt						5 			450.0
liguanea					mountain view			4 			430.0
liguanea					downtown kingston		8 			510.0
*/