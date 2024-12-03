package com.yasmine.oeuvres.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yasmine.oeuvres.entities.Exposition;

@RepositoryRestResource(path = "exp") 
@CrossOrigin("http://localhost:4200/")  
public interface ExpositionRepository extends JpaRepository<Exposition, Long> {

}
