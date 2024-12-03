package com.yasmine.oeuvres.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "titreOeuv", types = { Oeuvre.class }) 
public interface OeuvreProjection {
	public String getTitre(); 
}
