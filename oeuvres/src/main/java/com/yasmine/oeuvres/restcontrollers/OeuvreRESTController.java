package com.yasmine.oeuvres.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yasmine.oeuvres.entities.Oeuvre;
import com.yasmine.oeuvres.service.OeuvreService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class OeuvreRESTController {
	
	@Autowired
	OeuvreService oeuvreService;
	
	@RequestMapping(path="all",method = RequestMethod.GET) 
	public List<Oeuvre> getAllOeuvres() { 
	return oeuvreService.getAllOeuvres(); 
	} 
	
	@RequestMapping(value="/getbyid/{idOeuvre}",method = RequestMethod.GET) 
	public Oeuvre getOeuvreByIdOeuvre(@PathVariable("idOeuvre") Long idOeuvre) {  
	    return oeuvreService.getOeuvre(idOeuvre); 
	} 

	
	@RequestMapping(value="/addoeuv",method = RequestMethod.POST) 
	public Oeuvre createOeuvre(@RequestBody Oeuvre oeuvre) { 
	return oeuvreService.saveOeuvre(oeuvre); 
	} 
	
	 @RequestMapping(value="/updateoeuv/{idOeuvre}", method = RequestMethod.PUT) 
	    public Oeuvre updateOeuvre(@PathVariable("idOeuvre") Long idOeuvre, @RequestBody Oeuvre oeuvre) { 
	        oeuvre.setIdOeuvre(idOeuvre);  
	        return oeuvreService.updateOeuvre(oeuvre); 
	    }
	 
	 @RequestMapping(value="/updateoeuv", method = RequestMethod.PUT) 
	 public Oeuvre updateOeuvre(@RequestBody Oeuvre oeuvre) { 
	     if (oeuvre.getIdOeuvre() == null) {
	         throw new IllegalArgumentException("ID de l'œuvre manquant");
	     }
	     return oeuvreService.updateOeuvre(oeuvre); 
	 }
	
	@RequestMapping(value="/deloeuv/{idOeuvre}",method = RequestMethod.DELETE) 
	public void deleteOeuvre(@PathVariable("idOeuvre") Long idOeuvre) 
	{ 
	oeuvreService.deleteOeuvreByIdOeuvre(idOeuvre); 
	} 
	
	@RequestMapping(value="/oeuvsExp/{idExposition}",method = RequestMethod.GET) 
	public List<Oeuvre> getOeuvressByIdExposition(@PathVariable("idExposition") Long idExposition) { 
	return oeuvreService.findByExpositionIdExposition(idExposition); 
	}
	
	
	@RequestMapping(value="/oeuvresByTitle/{titre}", method = RequestMethod.GET) 
	public List<Oeuvre> findByTitreOeuvreContains(@PathVariable("titre") String titre) { 
	    return oeuvreService.findByTitreOeuvreContains(titre); 
	}
}
