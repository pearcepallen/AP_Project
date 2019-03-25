package Ascari.one.AscariCab.Controllers;

import java.util.List;


import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import database.CabDb;
import Entity.Cab;
import Exceptions.ResourceNotFound.ResourceNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api/cab")
public class CabController {

Logger logger = LogManager.getLogger(CabController.class);

CabDb cabdb = new CabDb();


@GetMapping("/all")
public List<Cab> getAll()
{
	return cabdb.selectAll();			
}                           
                           
@PostMapping("/add")           
public Cab create(@Valid @RequestBody Cab item )
{             
	 cabdb.add(item);
	 return item;
}                          



@GetMapping("/{id}")
public Cab get(@PathVariable(value="id") int id) 
{
	Cab item = new Cab();	
	
	item = cabdb.get(id);	 
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


@PutMapping("/{id}")
public Cab update(@PathVariable(value = "id") int id,@Valid @RequestBody Cab details) 
{

	Cab cab = cabdb.get(id);	
	
	try
	{		
		 if (cab != null)
		 {
			 cab.setDistance(details.getDistance());
			 cab.setFare(details.getFare());
			 cab.setModel(details.getModel());
			 cab.setName(details.getName());			 
			 cab.setTrn(details.getTrn());
			 cab.setYear(details.getYear());
			 cab.setAvailable(details.isAvailable());			 
			 cabdb.add(cab);			 
		 }	 
			return cab;  
	}
	catch(ResourceNotFoundException e ) 
		{
		e.printStackTrace();
		return null;
		}

}


@DeleteMapping("/{id}")
public ResponseEntity<?> delete(@PathVariable(value = "id") int id) {
	Cab cab = cabdb.get(id);
           
			try
			{				
				 if (cab != null)
				 {
					 cabdb.delete(id);
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
