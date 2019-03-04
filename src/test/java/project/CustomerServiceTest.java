package project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Services.CustomerService;

public class CustomerServiceTest {
	@Test
	public void shouldReqPrice()
	{
		CustomerService cs = new CustomerService(); 
		int diff= 0;
		double 	exPrice = 350 + (diff * 20);
		double calcPrice = cs.req_price(diff);
		
		assertEquals(calcPrice,exPrice,0);
	}

}
