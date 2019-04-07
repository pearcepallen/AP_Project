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

import Entity.System1;
import Exceptions.ResourceNotFound.ResourceNotFoundException;
import database.SystemDb;


@RestController
@RequestMapping("/api/system/")

public class SystemController {

SystemDb sysdb = new SystemDb();
Logger logger = LogManager.getLogger(SystemController.class);

@GetMapping("/get")
public List<System1> getAll()
{
	return sysdb.selectAll();			
}                           
                           
@PostMapping("/add")           
public System1 create(@Valid @RequestBody System1 item )
{             
	 sysdb.add(item);
	 return item;
}                          



@GetMapping("/{id}")
public System1 get(@PathVariable(value="id") int id) 
{
	System1 item = new System1();	
	
	item = sysdb.get(id);	 
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
public System1 update(@PathVariable(value = "id") int id,@Valid @RequestBody System1 details) 
{

	System1 system = sysdb.get(id);	
	try
	{		
		 if (system != null)
		 {			 
			 system.setLocation(details.getLocation());
			 system.setDestination(details.getDestination());
			 system.setDistance(details.getDistance());
			 system.setPrice(details.getPrice());
			 
			 sysdb.add(system);			 
		 }	 
			return system;  
	}
	catch(ResourceNotFoundException e ) 
		{
		e.printStackTrace();
		return null;
		}

}
*/




@PutMapping("/{id}")
public System1 update(@PathVariable(value = "id") int id,@Valid @RequestBody System1 details) 
{
	
	try
	{				
		sysdb.update(details, id);			
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
	System1 system = sysdb.get(id);
           
			try
			{				
				 if (system != null)
				 {
					 sysdb.delete(id);
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
