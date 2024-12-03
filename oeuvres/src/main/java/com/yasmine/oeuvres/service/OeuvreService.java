package com.yasmine.oeuvres.service;

import java.util.List;

import com.yasmine.oeuvres.entities.Exposition;
import com.yasmine.oeuvres.entities.Oeuvre;

public interface OeuvreService {
	  Oeuvre saveOeuvre(Oeuvre o); 
	  Oeuvre updateOeuvre(Oeuvre o); 
	  void deleteOeuvre(Oeuvre o); 
	  void deleteOeuvreByIdOeuvre(Long idOeuvre); 
	  Oeuvre getOeuvre(Long idOeuvre); 
	  List<Oeuvre> getAllOeuvres();
	  
	  List<Oeuvre> findByTitreOeuvre(String titre); 
	  List<Oeuvre> findByTitreOeuvreContains(String titre); 
	  List<Oeuvre> findByTitrePrix (String titre, Double prix); 
	  List<Oeuvre> findByExposition (Exposition exposition); 
	  List<Oeuvre> findByExpositionIdExposition(Long idExposition); 
	  List<Oeuvre> findByOrderByTitreOeuvreAsc(); 
	  List<Oeuvre> trierOeuvresTitresPrix();
	  
}
