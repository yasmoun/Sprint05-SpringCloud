package com.yasmine.oeuvres;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import com.yasmine.oeuvres.entities.Oeuvre;
import com.yasmine.oeuvres.repos.OeuvreRepository;

@SpringBootTest
class OeuvresApplicationTests {
	@Autowired 
	   private OeuvreRepository oeuvreRepository;
	/*@Test 
	public void testCreateOeuvre() { 
	Oeuvre oeuv = new Oeuvre("Poesie"," Emmanuelle Vroelant",new Date(),"peinture","10*10","the war 1990",35.00); 
	oeuvreRepository.save(oeuv); 
	} */
	
	@Test 
	public void testFindOeuvre() 
	{ 
	Oeuvre o = oeuvreRepository.findById(1L).get();     
	System.out.println(o); 
	} 
	@Test 
	public void testUpdateOeuvre() 
	{ 
	Oeuvre o = oeuvreRepository.findById(1L).get(); 
	o.setPrix(1000.0); 
	oeuvreRepository.save(o); 
	}
	@Test 
	 public void testDeleteOeuvre() 
	  { 
	   oeuvreRepository.deleteById(1L);; 
	    
	  } 
	 
	    
	@Test 
	 public void testListerTousOeuvres() 
	  { 
	   List<Oeuvre>  oeuvrs = oeuvreRepository.findAll();   
	   for (Oeuvre o : oeuvrs) 
	   { 
	    System.out.println(o); 
	   }   
	  } 
}
