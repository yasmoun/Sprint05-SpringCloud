package com.yasmine.oeuvres.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.yasmine.oeuvres.entities.Exposition;
import com.yasmine.oeuvres.entities.Oeuvre;
import com.yasmine.oeuvres.repos.ImageRepository;
import com.yasmine.oeuvres.repos.OeuvreRepository;

@Service
public class OeuvreServiceImpl implements OeuvreService{
	@Autowired 
	   private OeuvreRepository oeuvreRepository;
	@Autowired 
	   private ImageRepository imageRepository;
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@Override
	public Oeuvre saveOeuvre(Oeuvre o) {
		return oeuvreRepository.save(o);
	}

	/*@Override
	public Oeuvre updateOeuvre(Oeuvre o) {
		return oeuvreRepository.save(o);
	}*/
	
	@Override
	public Oeuvre updateOeuvre(Oeuvre o) {
	/*Long oldProdImageId = 
	this.getOeuvre(o.getIdOeuvre()).getImage().getIdImage();
	Long newOeuvImageId = o.getImage().getIdImage();*/
	Oeuvre oeuvUpdated = oeuvreRepository.save(o);
	/*if (oldProdImageId != newOeuvImageId) //si l'image a été modifiée
	imageRepository.deleteById(oldProdImageId);*/
	return oeuvUpdated;
	}
	

	@Override
	public void deleteOeuvre(Oeuvre o) {
		oeuvreRepository.delete(o);
		
	}

	public void deleteOeuvreByIdOeuvre(Long id) {
		oeuvreRepository.deleteById(id);
		
	}

	@Override
	public Oeuvre getOeuvre(Long id) {
		return oeuvreRepository.findById(id).get();
	}

	@Override
	public List<Oeuvre> getAllOeuvres() {
		return oeuvreRepository.findAll();
	}

	@Override
	public List<Oeuvre> findByTitreOeuvre(String titre) {
		return oeuvreRepository.findByTitre(titre);
	}

	@Override
	public List<Oeuvre> findByTitreOeuvreContains(String titre) {
		return oeuvreRepository.findByTitreContains(titre);
	}

	@Override
	public List<Oeuvre> findByTitrePrix(String titre, Double prix) {
		return oeuvreRepository.findByTitrePrix(titre,prix);
	}

	@Override
	public List<Oeuvre> findByExposition(Exposition exposition) {
		return oeuvreRepository.findByExposition(exposition);
	}

	@Override
	public List<Oeuvre> findByExpositionIdExposition(Long idExposition) {
		return oeuvreRepository.findByExpositionIdExposition(idExposition);
	}

	@Override
	public List<Oeuvre> findByOrderByTitreOeuvreAsc() {
		return oeuvreRepository.findByOrderByTitreAsc();

	}

	@Override
	public List<Oeuvre> trierOeuvresTitresPrix() {
		return oeuvreRepository.trierOeuvresTitresPrix();

	}

}
