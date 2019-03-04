package Main;


import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import Database.CabManagerDb;
import Database.SQLProvider;
import Entity.CabManager;
import Services.CabManagerService;
public class Driver 
{
	public static void main(String[] args) 
	{
		Logger logger = null;
		logger = LogManager.getLogger(CabManagerDb.class);
		
		SQLProvider<CabManager> db = new CabManagerDb();
		int recordsAffected = db.add(new CabManager(0,"newnew@gmail.com","tobago"));
		
		if(recordsAffected == 1)
		{
			logger.debug("records added successfully");
			System.out.println("records added successfully");
		}
		else
		{			
			logger.debug("records not added successfully");
			System.out.println("records not added successfully");
		}
		
		List<CabManager> results = db.selectAll();
		System.out.println(CabManagerDb.TABLE_NAME);
		System.out.println("--- Retrieved -- ");
		
		for(CabManager cm : results) 
			{
				System.out.println(cm);
			}

		CabManager cmm;
		cmm = db.get(10);
		System.out.println("Returning Cab Manager with the id of 10");	
	
			if (cmm != null)
			{			
				System.out.println(cmm);
			}
			else
			{
				System.out.println("No records found");
				logger.error("object is empty");
			}
			
			CabManager cn = new CabManager(0,"newwww@email","newpw");
			
			db.update(cn, 10);
			System.out.println("--- Retrieved -- ");
			
			for(CabManager cm : results) 
				{
					System.out.println(cm);
				}
			

			CabManagerService C = new CabManagerService();
			C.login();
				
	}	
	}
