package com.kkaplan.spring_design_pattern.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kkaplan.spring_design_pattern.builder.Contact;
import com.kkaplan.spring_design_pattern.builder.Contact.ContactBuilder;
import com.kkaplan.spring_design_pattern.factory.Pet;
import com.kkaplan.spring_design_pattern.factory.PetFactory;

@RestController
public class AppController {
	
	private final PetFactory petFactory;
	
	public AppController(PetFactory petFactory) {
		this.petFactory = petFactory;
	}
	
	/* http://localhost:8080/adoptPet/dog/rover */
	@PostMapping("/adoptPet/{type}/{name}")
	public Pet adoptPet(@PathVariable String type, @PathVariable String name) {
		Pet pet = this.petFactory.createPet(type);
		pet.setName(name);
		pet.feed();
		return pet;
	}
	
	/*  */
	@PostMapping("/contact")
	public Contact adoptPet(@RequestParam(required = false) String firstName, 
							@RequestParam(required = false) String lastName, 
							@RequestParam(required = false) String emailAddress) {
		return ContactBuilder.getInstance().setFirstName(firstName).setLastName(lastName).setEmailAddress(emailAddress).build();
	}
	
	
}
