package com.kkaplan.spring_design_pattern.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kkaplan.spring_design_pattern.builder.Contact;
import com.kkaplan.spring_design_pattern.builder.Contact.ContactBuilder;
import com.kkaplan.spring_design_pattern.factory.Pet;
import com.kkaplan.spring_design_pattern.factory.PetFactory;
import com.kkaplan.spring_design_pattern.repository.PresidentEntity;
import com.kkaplan.spring_design_pattern.repository.PresidentRespository;

@RestController
public class AppController {
	
	private final PetFactory petFactory;
	private final PresidentRespository presidentRespository;
	private final RestTemplate restTemplate;
	
	public AppController(PetFactory petFactory, PresidentRespository presidentRespository, RestTemplate restTemplate) {
		this.petFactory = petFactory;
		this.presidentRespository = presidentRespository;
		this.restTemplate = restTemplate;
	}
	
	/* http://localhost:8080/adoptPet/dog/rover */
	@PostMapping("/adoptPet/{type}/{name}")
	public Pet adoptPet(@PathVariable String type, @PathVariable String name) {
		Pet pet = this.petFactory.createPet(type);
		pet.setName(name);
		pet.feed();
		return pet;
	}
	
	/* http://localhost:8080/contact?firstName=Kamil&lastName=Kaplan&emailAddress=kamilkaplnn@gmail.com */
	@PostMapping("/contact")
	public Contact adoptPet(@RequestParam(required = false) String firstName, 
							@RequestParam(required = false) String lastName, 
							@RequestParam(required = false) String emailAddress) {
		return ContactBuilder.getInstance().setFirstName(firstName).setLastName(lastName).setEmailAddress(emailAddress).build();
	}
	
	@GetMapping("/presidents/{id}")
	public PresidentEntity findPresidentById(@PathVariable Long id) {
		return presidentRespository.findById(id).get();
	}
	
	@GetMapping("/presidentContact/{id}")
	public Contact getPresidentContactById(@PathVariable Long id) {
		PresidentEntity president = this.restTemplate.getForEntity("http://localhost:8080/presidents/{id}", PresidentEntity.class, id).getBody();
		return ContactBuilder.getInstance()
							 .setFirstName(president.getFirstName())
							 .setLastName(president.getLastName())
							 .setEmailAddress(president.getEmailAddress()).build();
	}
	
}
