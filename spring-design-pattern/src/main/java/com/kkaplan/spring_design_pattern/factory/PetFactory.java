package com.kkaplan.spring_design_pattern.factory;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class PetFactory {

	public Pet createPet(String animalTye) {
		if(!StringUtils.hasLength(animalTye)) {
			throw new UnsupportedOperationException("animal type must be specified");
		}
		switch (animalTye.toLowerCase()) {
		  case "dog": {
			return new Dog();
		  }
		  default:
			throw new UnsupportedOperationException("unknow animal type");
		}
	}
	
}
