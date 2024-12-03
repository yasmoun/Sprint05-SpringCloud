package com.yasmine.oeuvres.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Exposition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long idExposition ;
	private String nom ;
	private String lieu ;
	private String organisateur ;
	private String description ;
	private Double prixEntree ;

	@OneToMany(mappedBy = "exposition")
	@JsonIgnore
	private List<Oeuvre> oeuvres;
	
	
}
