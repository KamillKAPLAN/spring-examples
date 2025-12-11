package com.kkaplan.spring_design_pattern.repository;

import org.springframework.data.repository.CrudRepository;

public interface PresidentRespository extends CrudRepository<PresidentEntity, Long>{
	
	PresidentEntity findByEmailAddress(String emailAddress);
}
