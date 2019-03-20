package Main;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import Entity.System1;
import database.SQLProvider;
import database.SystemDb;

public class SystemDriver {
	public static void main(String[] args) {

		Logger logger = null;	
		logger = LogManager.getLogger(SystemDriver.class);
		
			SQLProvider<System1> db  = new SystemDb();	
			int max = 0;
			if(max == 25)
			{
				logger.info("System Database already populated");			
			}
			else
			{		
			logger.info("populating System Database");
			max = db.add(new System1(1,"papine","papine",0,0.0))
					+db.add(new System1(2,"papine","hwt",0,0.0))
					+db.add(new System1(3,"papine","mountain view",0,0.0))
					+db.add(new System1(4,"papine","downtown kingston",0,0.0))
					+db.add(new System1(5,"papine","liguanea",0,0.0))
					
					+db.add(new System1(6,"hwt","hwt",0,0.0))
					+db.add(new System1(7,"hwt","papine",0,0.0))
					+db.add(new System1(8,"hwt","mountain view",0,0.0))
					+db.add(new System1(9,"hwt","downtown kingston",0,0.0))
					+db.add(new System1(10,"hwt","liguanea",0,0.0))
					
					+db.add(new System1(11,"mountain view","mountain view",0,0.0))
					+db.add(new System1(12,"mountain view","papine",0,0.0))
					+db.add(new System1(13,"mountain view","hwt",0,0.0))
					+db.add(new System1(14,"mountain view","downtown kingston",0,0.0))
					+db.add(new System1(15,"mountain view","liguanea",0,0.0))
					
					+db.add(new System1(16,"downtown kingston","downtown kingston",0,0.0))
					+db.add(new System1(17,"downtown kingston","liguanea",0,0.0))
					+db.add(new System1(18,"downtown kingston","papine",0,0.0))
					+db.add(new System1(19,"downtown kingston","hwt",0,0.0))
					+db.add(new System1(20,"downtown kingston kingston","mountain view",0,0.0))
					
					+db.add(new System1(21,"liguanea","liguanea",0,0.0))
					+db.add(new System1(22,"liguanea","papine",0,0.0))
					+db.add(new System1(23,"liguanea","hwt",0,0.0))
					+db.add(new System1(24,"liguanea","mountain view",0,0.0))
					+db.add(new System1(25,"liguanea","downtown kingston",0,0.0));
					logger.info("System Database successfully populated");
			}
		}
	

}
