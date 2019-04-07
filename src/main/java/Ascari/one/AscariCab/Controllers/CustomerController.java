package Ascari.one.AscariCab.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Entity.Customer;
import Exceptions.ResourceNotFound.ResourceNotFoundException;
import database.CustomerDb;

@RestController
@RequestMapping("/api/customer/")

public class CustomerController 
{


CustomerDb custdb = new CustomerDb();
Logger logger = LogManager.getLogger(CustomerController.class);

@GetMapping("/get")
public List<Customer> getAll()
{
	return custdb.selectAll();			
}                           
                           
@PostMapping("/add")           
public Customer create(@Valid @RequestBody Customer item )
{             
	 custdb.add(item);
	 return item;
}                          



@GetMapping("/{id}")
public Customer get(@PathVariable(value="id") int id) 
{
	Customer item = new Customer();	
	
	item = custdb.get(id);	 
	try 
	{		
		if (item != null )	
		{
			logger.info("item exits");				
		}	
		return item;
		
	}
catch(ResourceNotFoundException e ) 
	{
	e.printStackTrace();
	return null;
	}
}

/*
@PutMapping("/{id}")
public Customer update(@PathVariable(value = "id") int id,@Valid @RequestBody Customer details) 
{
	Customer cust = custdb.get(id);	
	try
	{		
		 if (cust != null)
		 {
			 cust.setNumber(details.getNumber());
			 cust.setLocation(details.getLocation());
			 cust.setDestination(details.getDestination());
			 cust.setFeedback(details.getFeedback());
			 cust.setRating(details.getRating());
			 cust.setConfirm_arr(details.isConfirm_arr());
			 cust.setConfirm_pk(details.isConfirm_pk());
			 custdb.add(cust);			 
		 }	 
			return cust;  
	}
	catch(ResourceNotFoundException e ) 
		{
		e.printStackTrace();
		return null;
		}

}
*/


@PutMapping("/{id}")
public Customer update(@PathVariable(value = "id") int id,@Valid @RequestBody Customer details) 
{
	
	try
	{				
		custdb.update(details, id);			
		return details;
	}
	catch(ResourceNotFoundException e ) 
		{
		e.printStackTrace();
		return null;
		}

}





@DeleteMapping("/{id}")
public ResponseEntity<?> delete(@PathVariable(value = "id") int id) {
	Customer cust = custdb.get(id);
           
			try
			{				
				 if (cust != null)
				 {
					 custdb.delete(id);
				 }
				 return ResponseEntity.ok().build();
			}
	catch(ResourceNotFoundException e )
	{
		e.printStackTrace();
		return null;
	}
    
}
}
