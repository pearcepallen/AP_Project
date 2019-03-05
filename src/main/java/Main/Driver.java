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
		/*
		 //add
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
		
	*/
/*
 		//get
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
			}*/
			/*
		CabManager cn = new CabManager(0,"newwww@email","newpw");
		int id=19;
		int recordsAffected = db.update(cn,id);
		if(recordsAffected == 1)
			{
				logger.debug("records Updated successfully");
				System.out.println("--- Updated! -- ");			
			}
		else
			{			
				logger.error("records not Updated successfully");
				System.out.println("--- Update failed -- ");			
			}
			*/
	/*	
	//	Delete 
		int id=20;
		int recordsAffected = db.delete(id);
		if(recordsAffected == 1)
		{
			logger.debug("record deleted successfully");
			System.out.println("--- deleted! -- ");			
		}
		else
		{			
			logger.error("record not deleted successfully");
			System.out.println("--- delete failed -- ");			
		}
		*/
		/*
		// Delete Multiple
		int id[]= {10,11,12};
		int recordsAffected = db.deleteMultiple(id);
		if(recordsAffected == 3)
		{
			logger.debug("records deleted successfully");
			System.out.println("--- deleted! -- ");			
		}
		else
		{			
			logger.error("records not deleted successfully");
			System.out.println("--- delete failed -- ");			
		}
		*/
		
		//selectAll
			List<CabManager> results = db.selectAll();
			System.out.println(CabManagerDb.TABLE_NAME);
			System.out.println("--- Retrieved -- ");
			
			for(CabManager cm : results) 
				{
					System.out.println(cm);
				}
	}	
	}
