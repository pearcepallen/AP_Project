package project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Entity.Customer;
import Entity.Rate;
import Entity.System1;
import database.CustomerDb;
import database.SystemDb;

public class CustomerDbTest extends CustomerDb 
{
	@Test
	public void shouldAddToSystemDatabase()
	{
		int deff = 1;
		Customer cm = new Customer("Papine", "hwt", 3730990, "Good", Rate.excellent, true, false);
		CustomerDb db = new CustomerDb();
		int success = db.add(cm);	
		assertEquals(deff,success,0);
	}
	
	@Test
	public void shouldGetItem()
	{
		Customer cm = new Customer("Papine", "hwt", 3730990, "Good", Rate.excellent, true, false);
		int id = 123;
		CustomerDb db = new CustomerDb();
		Customer success = db.get(id);
		assertEquals(cm,success);
	}
	
	@Test 
	public void shouldUpdateDatabase()
	{
		int deff = 1;
		int id = 1;
		Customer cm = new Customer("Papine", "hwt", 3730990, "Good", Rate.excellent, true, false);
		CustomerDb db = new CustomerDb();
		int success;
		success = db.update(cm, id);
		assertEquals(deff,success,0);
	}
	
	@Test
	public void shouldPrintObject()
	{
		Customer pr = new Customer("Papine", "hwt", 3730990, "Good", Rate.excellent, true, false); 
		Customer Display = new Customer();
		String loc;
		loc = Display.getLocation();
		System.out.println(loc);
		
		String des;
		des = Display.getDestination();
		System.out.println(des);
		
		int num;
		num = Display.getNumber();
		System.out.println(num);
		
		Rate rate;
		rate = Display.getRating();
		System.out.println(rate);
		
		boolean gt;
		gt = Display.isConfirm_pk();
		System.out.println(gt);
		
		boolean art;
		art = Display.isConfirm_arr();
		System.out.println(art);
	}
	
	@Test 
	public void shouldDeleteFromDatabase()
	{
		CustomerDb delete = new CustomerDb();
		Customer dt = new Customer("Papine", "hwt", 3730990, "Good", Rate.excellent, true, false); 
		
		int Delete;
		int id = 123;
		
		Delete = delete.delete(id);
		System.out.println("Delete Successful");
		assertEquals(id,Delete,0);
	}
	
	@Test
	public void shouldDeleteMultiple()
	{
		CustomerDb mult = new CustomerDb();
		
		Customer dt = new Customer("Papine", "hwt", 3730990, "Good", Rate.excellent, true, false); 
		Customer cm = new Customer("hwt", "downtown kingston", 5749747, "Excellent", Rate.good, true, true);
		
		int mul;
		int id;
		int[] ids = null;
		
		mul = mult.deleteMultiple(ids);
		
	}

}
