package Database;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Entity.Cab;

public class CabDb extends SQLProvider <Cab>
{
	
	private static final String TABLE_NAME = "YUNG_cab";
	private static Logger logger = LogManager.getLogger(CabDb.class);
	
	@Override
	protected void initSQLDatabase() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int add(Cab item) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<Cab> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cab get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Cab item, int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMultiple(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}



}
