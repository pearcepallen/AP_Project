package project;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import Database.CabManagerDb;
import Entity.CabManager;

public class CabManagerDbTest extends CabManagerDb {
	/*
	@Test
	public void shouldPrintObject()
	{
		CabManager cm = new CabManager(123,"oosh","oosshAgain");
		CabManager cd = new CabManager(123,"oosh","oosshAgain");
		assertEquals(cm,cd);
	}

	@Test
	public void shouldAddToDatabase()
	{
		int deff = 1;
		CabManager cm = new CabManager(0,"email","passworrdd");
		CabManagerDb db = new CabManagerDb();
		int success = db.add(cm);	
		assertEquals(deff,success,0);
		
	}
	*/
	@Test
	public void shouldGetItem()
	{
		CabManager  cm = new CabManager(22,"demarBlackgmail.com","demar");
		int id = 22; 
		CabManagerDb db = new CabManagerDb();
		CabManager success = db.get(id);
		assertEquals(cm,success);
	}

	
	
	/*
	@Test 
	public void shouldUpdateobject()
	{
		int deff = 1;
		int id = 1;
		CabManager cm = new CabManager(0,"email","passworrdd");
		CabManagerDb db = new CabManagerDb();
		int success;
		success = db.update(cm, id);
		assertEquals(deff,success,0);

		
	}
	
	Merge test
	
		return 0;*/
	
}
