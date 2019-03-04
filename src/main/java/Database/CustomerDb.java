package Database;

import java.util.List;

import Entity.Customer;

public class CustomerDb extends SQLProvider<Customer>{

	public CustomerDb() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initSQLDatabase() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int add(Customer item) {
		
		return 0;
	}

	@Override
	public List<Customer> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Customer item, int id) {
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
