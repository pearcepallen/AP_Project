package project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Entity.RequestModel;
import database.RequestModelDb;


public class RequestModelTest extends RequestModel
{
	@Test
	public void shouldAddToSystemDatabase()
	{
		int deff = 1;
		RequestModel cm = new RequestModel(123, 12536, 2635, "papine","hwt", 3, 410.0);
		RequestModelDb db = new RequestModelDb();
		int success = db.add(cm);	
		assertEquals(deff,success,0);
	}
	
	@Test
	public void shouldGetItem()
	{
		RequestModel cm = new RequestModel(123, 12536, 2635, "papine","hwt", 3, 410.0);
		int id = 123; 
		RequestModelDb db = new RequestModelDb();
		RequestModel success = db.get(id);
		assertEquals(cm,success);
	}
	
	@Test 
	public void shouldUpdateDatabase()
	{
		int deff = 1;
		int id = 1;
		RequestModel cm = new RequestModel(123, 12536, 2635, "papine","hwt", 3, 410.0);
		RequestModelDb db = new RequestModelDb();
		int success;
		success = db.update(cm, id);
		assertEquals(deff,success,0);
	}
	
	@Test
	public void shouldPrintObject()
	{
		RequestModel pr = new RequestModel(123, 12536, 2635, "papine","hwt", 3, 410.0); 
		RequestModel Display = new RequestModel();
		int vr;
		vr = Display.getReq_id();
		System.out.println(vr);
		
		int c_num;
		c_num = Display.getC_number();
		System.out.println(c_num);
		
		int cid;
		cid = Display.getC_id();
		System.out.println(cid);
		
		String loc;
		loc = Display.getDestination();
		System.out.println(loc);
		
		String des;
		des = Display.getDestination();
		System.out.println(des);
		
		int dis;
		dis = Display.getDistance();
		System.out.println(dis);
		
		double cost;
		cost = Display.getFare();
		System.out.println(cost);
		
	}
	
	@Test 
	public void shouldDeleteFromDatabase()
	{
		RequestModelDb delete = new RequestModelDb();
		RequestModel dt = new RequestModel(123, 12536, 2635, "papine","hwt", 3, 410.0); 
		
		int Delete;
		int id = 123;
		
		Delete = delete.delete(id);
		System.out.println("Delete Successful");
		assertEquals(id,Delete,0);
	}
	
	@Test
	public void shouldDeleteMultiple()
	{
		RequestModelDb mult = new RequestModelDb();
		RequestModel dt = new RequestModel(123, 12536, 2635, "papine","hwt", 3, 410.0); 
		RequestModel cm = new RequestModel(102, 73648, 1000, "hwt","papine", 3, 410.0);
		
		int mul;
		int id;
		int[] ids = null;
		
		mul = mult.deleteMultiple(ids);
		
	}

	
}
