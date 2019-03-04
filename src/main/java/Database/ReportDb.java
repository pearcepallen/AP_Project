package Database;

import java.util.List;

import Entity.Cab;

public class ReportDb extends SQLProvider<Cab>{

	public ReportDb() {
		// TODO Auto-generated constructor stub
	}

	
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
