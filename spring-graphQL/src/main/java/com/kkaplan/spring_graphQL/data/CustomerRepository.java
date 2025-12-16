package com.kkaplan.spring_graphQL.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	Customer findCustomerByEmail(String email);
}
