package com.yasmine.oeuvres.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.yasmine.oeuvres.entities.Exposition;
import com.yasmine.oeuvres.entities.Oeuvre;

@RepositoryRestResource(path = "rest") 
public interface OeuvreRepository extends JpaRepository<Oeuvre, Long> {
	List <Oeuvre> findByTitre(String titre);
	List <Oeuvre> findByTitreContains(String titre);
	/*@Query("select o from Oeuvre o where o.titre like %? and o.prix > ?") 
	List<Oeuvre> findByTitreOeuvre (String nom, Double prix); */
	
	@Query("select o from Oeuvre o where o.titre like %:titre and o.prix > :prix")
	List<Oeuvre> findByTitrePrix(@Param("titre") String titre, @Param("prix") Double prix);
	
	@Query("select o from Oeuvre o where o.exposition = ?1") 
	List<Oeuvre> findByExposition (Exposition exposition);
	
	List<Oeuvre> findByExpositionIdExposition(Long idExposition); 
	List<Oeuvre> findByOrderByTitreAsc();
	
	@Query("select o from  Oeuvre o order by o.titre ASC, o.prix DESC") 
	List<Oeuvre> trierOeuvresTitresPrix ();
	
	
}
