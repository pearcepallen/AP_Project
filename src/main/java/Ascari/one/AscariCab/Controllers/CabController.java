package Ascari.one.AscariCab.Controllers;

import java.util.List;

<<<<<<< HEAD

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


@GetMapping("")
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

	Cab cab = new Cab();
	cabdb.update(details,id);	
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
=======
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

import Entity.Cab;
import Exceptions.ResourceNotFound.ResourceNotFoundException;
import database.CabDb;

@RestController
@RequestMapping(value="/api/cab")
public class CabController {

Logger logger = LogManager.getLogger(CabController.class);

CabDb cabdb = new CabDb();


@GetMapping(value="/all")
public List<Cab> getAll()
{
	return cabdb.selectAll();			
}   

@GetMapping(value="/avl")
public List<Cab> getavl()
{
	return cabdb.selectAll();			
}   
                           
@PostMapping("/add")           
public Cab create(@Valid @RequestBody Cab item )
{             
	 cabdb.add(item);
	 return item;
}                          



@GetMapping("/{c_id}")
public Cab get(@PathVariable(value="c_id") int id) 
{
	Cab item = new Cab(0,0,0,0,"civic","John Jones",false,0.0,0);	
	item = cabdb.get(id);
	 
	
		if (item != null )	
		{
			logger.info("item exits");				
		}	
		return item;
	
}


@PutMapping("/{id}")
public Cab update(@PathVariable(value = "id") int id,@Valid @RequestBody Cab details) 
{

	Cab cab = new Cab();
	cabdb.update(details,id);	
	try
	{		
		 if (cab != null)
		 {
			 cab.setDistance(details.getDistance());
			 cab.setFare(details.getFare());
			 cab.setModel(details.getModel());
			 cab.setName(details.getName());
			 cab.setReq_id(details.getReq_id());
			 cab.setTrn(details.getTrn());
			 cab.setYear(details.getYear());
			 cab.setAvailable(details.isAvailable());			 
			 cabdb.add(cab);			 
		 }	 
	}
	catch(ResourceNotFoundException e ) 
		{
		e.printStackTrace();
		return null;
		}
	return cab;  
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
	
			}
	catch(ResourceNotFoundException e )
	{
		e.printStackTrace();
		return null;
	}
    return ResponseEntity.ok().build();
}

}

/*
package jm.edu.utech.fruitbasketmone.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jm.edu.utech.fruitbasketmone.repositories.IBasketRepository;
import jm.edu.utech.fruitbasketmone.entities.Basket;
import jm.edu.utech.fruitbasketmone.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/api/baskets")
public class BasketController {
	
	@Autowired
	private IBasketRepository repo;
	
	@GetMapping("")
	public List<Basket> getAll() {
		return repo.findAll(); 
	}
	
	@PostMapping("")
	public Basket create(@Valid @RequestBody Basket data) {
		return repo.save(data);
	}
	
	@GetMapping("/{id}")
	public Basket get(@PathVariable(value="id")  int id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Basket","id",id));
	}
	
	// Update a Note
	@PutMapping("/{id}")
	public Basket update(@PathVariable(value = "id") int id,
	                                        @Valid @RequestBody Basket details) {

	    Basket basket = repo.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Basket", "id", id));

	    basket.setOwnerName(details.getOwnerName());

	    basket = repo.save(basket);
	    return basket;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") int id) {
		Basket basket = repo.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Basket", "id", id));

	    repo.delete(basket);

	    return ResponseEntity.ok().build();
	}


}*/
>>>>>>> refs/heads/frontend
