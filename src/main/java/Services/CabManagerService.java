
package Services;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Entity.Cab;
import Entity.CabManager;
//import Entity.Report;
import database.CabDb;


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
	
	public void requestDistance()
	{
		int id=1;
		Cab cab = new Cab();
		CabDb cabDb = new CabDb();
		
		cab.setDistance(cabDb.get(id).getDistance());
		
	}
	

}
