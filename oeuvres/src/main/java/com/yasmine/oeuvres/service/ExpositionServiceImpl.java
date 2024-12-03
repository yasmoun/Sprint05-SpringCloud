package com.yasmine.oeuvres.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yasmine.oeuvres.entities.Exposition;
import com.yasmine.oeuvres.repos.ExpositionRepository;

@Service
public class ExpositionServiceImpl implements ExpositionService {

    @Autowired
    private ExpositionRepository expositionRepository;

    @Override
    public Exposition saveExposition(Exposition exposition) {
        return expositionRepository.save(exposition);
    }

    @Override
    public Exposition updateExposition(Long idExposition, Exposition exposition) {
        // Vérifier si l'exposition existe
        if (expositionRepository.existsById(idExposition)) {
            exposition.setIdExposition(idExposition);
            return expositionRepository.save(exposition);
        } else {
            throw new RuntimeException("Exposition non trouvée avec l'ID: " + idExposition);
        }
    }

    @Override
    public void deleteExposition(Long idExposition) {
        expositionRepository.deleteById(idExposition);
    }

    @Override
    public void deleteExpositionByIdExposition(Long idExposition) {
        expositionRepository.deleteById(idExposition);
    }
}