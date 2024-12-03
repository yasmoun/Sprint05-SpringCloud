package com.yasmine.oeuvres.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.yasmine.oeuvres.entities.Image;

public interface ImageRepository extends JpaRepository<Image , Long>{

}
