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

import Entity.RequestModel;
import Exceptions.ResourceNotFoundException;
import database.RequestModelDb;


@RestController
@RequestMapping("/api/request/")

public class RequestModelController {

RequestModelDb requestdb = new RequestModelDb();
Logger logger = LogManager.getLogger(RequestModelController.class);

@GetMapping("/all")
public List<RequestModel> getAll()
{
	return requestdb.selectAll();			
}                           
                           
@PostMapping("/add")           
public RequestModel create(@Valid @RequestBody RequestModel item )
{             
	 requestdb.add(item);
	 return item;
}                          



@GetMapping("/{id}")
public RequestModel get(@PathVariable(value="id") int id) 
{
	RequestModel item = new RequestModel();	
	
	item = requestdb.get(id);	 
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
public RequestModel update(@PathVariable(value = "id") int id,@Valid @RequestBody RequestModel details) 
{

	RequestModel request = requestdb.get(id);	
	try
	{		
		 if (request != null)
		 {
			 request.setC_number(details.getC_number());			
			 request.setLocation(details.getLocation());
			 request.setDestination(details.getDestination());
			 request.setC_id(details.getC_id());
			 request.setFare(details.getFare());
			 request.setReq_id(details.getReq_id());
			 request.setDistance(details.getDistance());
			 			
			 requestdb.add(request);			 
		 }	 
			return request; 
	}
	catch(ResourceNotFoundException e ) 
		{
		e.printStackTrace();
		return null;
		}
 
}
*/


@PutMapping("/{id}")
public RequestModel update(@PathVariable(value = "id") int id,@Valid @RequestBody RequestModel details) 
{
	
	try
	{				
		requestdb.update(details, id);			
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
	RequestModel request = requestdb.get(id);
           
			try
			{				
				 if (request != null)
				 {
					 requestdb.delete(id);
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
