package com.yasmine.oeuvres.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yasmine.oeuvres.entities.Exposition;
import com.yasmine.oeuvres.repos.ExpositionRepository;
import com.yasmine.oeuvres.service.ExpositionService;

@RestController 
@RequestMapping("/api/exp") 
@CrossOrigin(origins = "http://localhost:4200")

public class ExpositionRESTController {
	@Autowired
	 ExpositionRepository expositionRepository; 
	@Autowired
	ExpositionService expositionService;
	  
	 @RequestMapping(method=RequestMethod.GET) 
	 public List<Exposition> getAllExpositions() 
	 { 
	  return expositionRepository.findAll(); 
	 } 
	  
	 @RequestMapping(value="/{idExposition}",method = RequestMethod.GET) 
	 public Exposition getExpositionByIdExposition(@PathVariable("idExposition") Long idExposition) { 
	  return expositionRepository.findById(idExposition).get(); 
	  }
	 
	 
	 @RequestMapping(method = RequestMethod.POST) 
	 public Exposition createExposition(@RequestBody Exposition exposition) { 
	     return expositionService.saveExposition(exposition); 
	 }
	 
	 @RequestMapping(value="/{idExposition}", method = RequestMethod.PUT) 
	 public Exposition updateExposition(@PathVariable("idExposition") Long idExposition, @RequestBody Exposition exposition) { 
	     return expositionService.updateExposition(idExposition, exposition); 
	 }
	 
	 
}
