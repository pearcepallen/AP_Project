/**
 * 
 */
package Services;

import Entity.Customer;
import Entity.Station;


/**
 * @author Demar Johnson
 *
 */

public class CustomerService extends Customer implements Station
{	
	public boolean req_av(Station s) // check for taxi's availability in the station
	{
		boolean available = false;
		if (Station_count()>0 )
		{
			available = true; 
		}
		else
		{
			available = false;
		}			 
		return available;
	}
	
	public boolean con_cab()  // books a cab for trip
	{
		boolean confirm = false;
		/*if ( ) // something
		{
			confirm = true;
		}
		else
		{
			confirm = false;
		}*/
		return confirm;
	}
	
	public int req_dist(int l, int d)  // string length as parameters  |   checks distance of journey
	{
		int diff;
		diff = d - l; 
		return diff;
	}
	
	public double req_price (int diff) //checks the price of the selected journey length
	{
		double price = 0.0;
		price = 350 + (diff * 20);
		return price;
	}
	

	public boolean con_pkup()  //signals that the confirmed cab has arrived to do pickup
	{
		return false;
	}
	
	public boolean con_arr()  //signals that the confirmed cab has delivered passenger to correct destination 
	{
		return false;
		
	}

	public int Station_count() 
	{
		return 0;
	}
}

