package project;

import database.SystemDb;
import Entity.System1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SystemDbTest extends SystemDb
{
	@Test
	public void shouldAddToSystemDatabase()
	{
		int deff = 1;
		System1 cm = new System1(123,"papine","hwt", 3, 410.0);
		SystemDb db = new SystemDb();
		int success = db.add(cm);	
		assertEquals(deff,success,0);
	}
	
	@Test
	public void shouldGetItem()
	{
		System1 cm = new System1(123,"papine","hwt", 3, 410.0);
		int id = 123; 
		SystemDb db = new SystemDb();
		System1 success = db.get(id);
		assertEquals(cm,success);
	}
	
	@Test 
	public void shouldUpdateDatabase()
	{
		int deff = 1;
		int id = 1;
		System1 cm = new System1(123,"papine","hwt", 3, 410.0);
		SystemDb db = new SystemDb();
		int success;
		success = db.update(cm, id);
		assertEquals(deff,success,0);
	}
	
	@Test
	public void shouldPrintObject()
	{
		System1 pr = new System1(123,"papine","hwt", 3, 410.0); 
		System1 Display = new System1();
		int vr;
		vr = Display.getId();
		System.out.println(vr);
		
		String location;
		location = Display.getLocation();
		System.out.println(location);
		
		String des;
		des = Display.getDestination();
		System.out.println(des);
		
		int dis;
		dis = Display.getDistance();
		System.out.println(dis);
		
		double cost;
		cost = Display.getPrice();
		System.out.println(cost);
		
	}
	
	@Test 
	public void shouldDeleteFromDatabase()
	{
		SystemDb delete = new SystemDb();
		System1 dt = new System1(123,"papine","hwt", 3, 410.0); 
		
		int Delete;
		int id = 123;
		
		Delete = delete.delete(id);
		System.out.println("Delete Successful");
		assertEquals(id,Delete,0);
	}
	
	@Test
	public void shouldDeleteMultiple()
	{
		SystemDb mult = new SystemDb();
		System1 dt = new System1(123,"papine","hwt", 3, 410.0); 
		System1 cm = new System1(637,"papine","downtown kingston", 10, 550.0);
		
		int mul;
		int id;
		int[] ids = null;
		
		mul = mult.deleteMultiple(ids);
		
	}
	
}
