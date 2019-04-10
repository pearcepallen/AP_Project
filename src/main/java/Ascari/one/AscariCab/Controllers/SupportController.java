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


import database.SupportDb;
import Entity.Support;
import Exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/api/support")
public class SupportController {

	Logger logger = LogManager.getLogger(SupportController.class);
	private SupportDb suppdb = new SupportDb();
	
	@GetMapping("/all")
	public List<Support> getAll() {
		return suppdb.selectAll(); 		
	}
	
	@PostMapping("/add")
	public Support create(@Valid @RequestBody Support data) {
		suppdb.add(data);
		return data;
	}
	
	@GetMapping("/{id}")
	public Support get(@PathVariable(value="id")  int id) {
				
		Support item = new Support();	
		
		item = suppdb.get(id);	 
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
	
	// Update a Note
	@PutMapping("/{id}")
	public Support update(@PathVariable(value = "id") int id,@Valid @RequestBody Support details) {
	    
   
		Support support = suppdb.get(id);	
		
		try
		{		
			 if (support != null)
			 {
				 	support.setFirstName(details.getFirstName());
					support.setLastName(details.getLastName());  
					support.setEmail(details.getEmail());  
					support.setType(details.getType());
					support.setDate(details.getDate());
					support.setTime(details.getTime());
					
				    suppdb.add(support);				    
			 }	    
			 return support;
		}
		catch(ResourceNotFoundException e ) 
			{
				e.printStackTrace();
				return null;
			}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") int id) {
		
	    Support support = suppdb.get(id);	        
	    try
		{		
			 if (support != null)
			 {
				 suppdb.delete(id);
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
