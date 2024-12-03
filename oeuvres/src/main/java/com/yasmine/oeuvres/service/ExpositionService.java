package com.yasmine.oeuvres.service;

import com.yasmine.oeuvres.entities.Exposition;

public interface ExpositionService {
	Exposition saveExposition(Exposition o); 
    Exposition updateExposition(Long idExposition, Exposition o); // Mise à jour
    void deleteExposition(Long idExposition); // Suppression par ID
    void deleteExpositionByIdExposition(Long idExposition); 
}
