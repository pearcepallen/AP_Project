
package Services;
import java.util.Scanner;

import Entity.Cab;
import Entity.CabManager;
import Entity.Report;

public class CabManagerService extends CabManager
{
	int i = 0,b=0,c=0;
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
	}
	
	
	
	public boolean Add_Cab(Cab c)
	{
		return false;
	}
	
	public boolean Delete_Cab(Cab c)
	{
		return false;
	}
}
