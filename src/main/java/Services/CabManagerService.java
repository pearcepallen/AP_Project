
package Services;
import java.util.ArrayList;
import java.util.List;


import Entity.Cab;
import Entity.CabManager;
import Entity.RequestModel;
import database.CabDb;
import database.CustomerDb;


public class CabManagerService extends CabManager
{
	int id;
/*	int i = 0,b=0,c=0;
	String mail = "@";
	String pass = "death";
	Scanner a = new Scanner(System.in);
	
	
	public boolean login()
	{
		boolean success;
		success = true;
		
	   System.out.println("\tEnter credentials\t\n");
	   do {
			System.out.println("\tEmail: ");
			String email = a.nextLine();
	        b=1;
	        
		   while(i<email.length())
		   {
			   if(email.charAt(i) != mail.charAt(0))
			   {
					System.out.println("\nIncorrect email format\n");
					b=2;
			   }
			  i++;
		    }
		 }while(b==2);
	   
	   do {
		System.out.println("\tPassword: ");
		password = a.nextLine();
		c=1;
		
			if(password!=pass)
			{
				c=2;
			}
	   }while(c ==2);
	   
		return success;
	}*/
	
	
	public boolean addCab(Cab c)
	{
		return false;
	}
	
	public boolean deleteCab(Cab c)
	{
		return false;
	}
	
	public List<RequestModel> requestDistance()
	{
		String concat;
		int combined;
		
		int id=1;
		List<RequestModel>  requests = new ArrayList<RequestModel>();				
		CabDb cabDb = new CabDb();
		CustomerDb cust = new CustomerDb();
		
		for (RequestModel request : requests )
		{					
			request.setC_id(cabDb.get(id).getC_id());
			request.setC_number(cust.get(id).getNumber());
			concat = Integer.toString(cust.get(id).getNumber()) + Integer.toString(cabDb.get(id).getC_id());
			combined = Integer.parseInt(concat);
			request.setReq_id(combined);
			request.setLocation(cust.get(id).getLocation());
			request.setDestination(cust.get(id).getDestination());
			request.setDistance(cabDb.get(id).getDistance());
			request.setFare(cabDb.get(id).getFare());							
		}
		return requests;			
	}	

}
