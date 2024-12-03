package com.yasmine.oeuvres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.yasmine.oeuvres.entities.Exposition;
import com.yasmine.oeuvres.entities.Oeuvre;

@SpringBootApplication
@EnableDiscoveryClient
public class OeuvresApplication implements CommandLineRunner  {
	@Autowired 
	private RepositoryRestConfiguration repositoryRestConfiguration; 
	public static void main(String[] args) {
		SpringApplication.run(OeuvresApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Oeuvre.class ,Exposition.class); 
	}

}
