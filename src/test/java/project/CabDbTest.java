package project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Entity.Cab;
import database.CabDb;

public class CabDbTest extends CabDb
{
	@Test
	public void shouldAddToSystemDatabase()
	{
		int deff = 1;
		Cab cm = new Cab(111, 2536372, 2019, "Wagon", "Corolla",true, 550.0, 10);
		CabDb db = new CabDb();
		int success = db.add(cm);	
		assertEquals(deff,success,0);
	}
	
	@Test
	public void shouldGetItem()
	{
		Cab cm = new Cab(111, 2536372, 2019, "Wagon", "Corolla",true, 550.0, 10);
		int id = 111; 
		CabDb db = new CabDb();
		Cab success = db.get(id);
		assertEquals(cm,success);
	}
	
	@Test 
	public void shouldUpdateDatabase()
	{
		int deff = 1;
		int id = 1;
		Cab cm = new Cab(111, 2536372, 2019, "Wagon", "Corolla",true, 550.0, 10);
		CabDb db = new CabDb();
		int success;
		success = db.update(cm, id);
		assertEquals(deff,success,0);
	}
	
	@Test
	public void shouldPrintObject()
	{
		Cab pr = new Cab(111, 2536372, 2019, "Wagon", "Corolla",true, 550.0, 10); 
		Cab Display = new Cab();
		int vr;
		vr = Display.getC_id();
		System.out.println(vr);
		
		int tr;
		tr = Display.getTrn();
		System.out.println(tr);
		
		int yr;
		yr = Display.getYear();
		System.out.println(yr);
		
		String mod_l;
		mod_l = Display.getModel();
		System.out.println(mod_l);
		
		String name;
		name = Display.getName();
		System.out.println(name);
		
		boolean ava;
		ava = Display.isAvailable();
		System.out.println(ava);
		
		double fare;
		fare = Display.getFare();
		System.out.println(fare);
		
		int dis_tance;
		dis_tance = Display.getDistance();
		System.out.println(dis_tance);
		
	}
	
	@Test 
	public void shouldDeleteFromDatabase()
	{
		CabDb delete = new CabDb();
		Cab dt = new Cab(111, 2536372, 2019, "Wagon", "Corolla",true, 550.0, 10); 
		
		int Delete;
		int id = 111;
		
		Delete = delete.delete(id);
		System.out.println("Delete Successful");
		assertEquals(id,Delete,0);
	}
	
	@Test
	public void shouldDeleteMultiple()
	{
		CabDb mult = new CabDb();
		Cab dt = new Cab(111, 2536372, 2019, "Wagon", "Corolla",true, 550.0, 10); 
		Cab cm = new Cab(112, 2005672, 2018, "Cedan", "Subaru",false, 450.0, 8);
		
		int mul;
		int id;
		int[] ids = null;
		
		mul = mult.deleteMultiple(ids);
		
	}
}
