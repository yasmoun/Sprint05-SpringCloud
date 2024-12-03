package com.yasmine.oeuvres.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Oeuvre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOeuvre ;
	private String titre ;
	private String artiste ;
	private LocalDate dateCreation ;
	private String categorie ;
	private String dimensions ;
	private String description ;
	private Double prix ;
	
		
	@ManyToOne
	private Exposition exposition ;
	
	 /*@OneToOne
	 private Image image;*/
	 
	 @OneToMany (mappedBy = "oeuvre")
	 private List<Image> images;


	@Override
	public String toString() {
		return "Oeuvre [idOeuvre=" + idOeuvre + ", titre=" + titre + ", artiste=" + artiste + ", dateCreation="
				+ dateCreation + ", Categorie=" + categorie + ", dimensions=" + dimensions + ", description="
				+ description + ", prix=" + prix + "]";
	}

	
}
