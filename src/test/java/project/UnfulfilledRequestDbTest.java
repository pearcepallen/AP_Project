package project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Entity.UnfulfilledRequest;
import database.UnfulfilledRequestDb;

public class UnfulfilledRequestDbTest extends UnfulfilledRequestDb
{	
	@Test
	public void shouldAddToSystemDatabase()
	{
		int deff = 1;
		UnfulfilledRequest cm = new UnfulfilledRequest(123,903);
		UnfulfilledRequestDb db = new UnfulfilledRequestDb();
		int success = db.add(cm);	
		assertEquals(deff,success,0);
	}
	
	@Test
	public void shouldGetItem()
	{
		UnfulfilledRequest cm = new UnfulfilledRequest(123,903);
		int id = 123; 
		UnfulfilledRequestDb db = new UnfulfilledRequestDb();
		UnfulfilledRequest success = db.get(id);
		assertEquals(cm,success);
	}
	
	@Test 
	public void shouldUpdateDatabase()
	{
		int deff = 1;
		int id = 1;
		UnfulfilledRequest cm = new UnfulfilledRequest(123,903);
		UnfulfilledRequestDb db = new UnfulfilledRequestDb();
		int success;
		success = db.update(cm, id);
		assertEquals(deff,success,0);
	}
	
	@Test
	public void shouldPrintObject()
	{
		UnfulfilledRequest pr = new UnfulfilledRequest(123,903); 
		UnfulfilledRequest Display = new UnfulfilledRequest();
		int vr;
		vr = Display.getC_id();
		System.out.println(vr);
		
		int dis;
		dis = Display.getC_number();
		System.out.println(dis);
		
	}
	
	@Test 
	public void shouldDeleteFromDatabase()
	{
		UnfulfilledRequestDb delete = new UnfulfilledRequestDb();
		UnfulfilledRequest dt = new UnfulfilledRequest(123,903); 
		
		int Delete;
		int id = 123;
		
		Delete = delete.delete(id);
		System.out.println("Delete Successful");
		assertEquals(id,Delete,0);
	}
	
	@Test
	public void shouldDeleteMultiple()
	{
		UnfulfilledRequestDb mult = new UnfulfilledRequestDb();
		UnfulfilledRequest dt = new UnfulfilledRequest(123,903); 
		UnfulfilledRequest cm = new UnfulfilledRequest(111,938);
		
		int mul;
		int id;
		int[] ids = null;
		
		mul = mult.deleteMultiple(ids);
		
	}
}
