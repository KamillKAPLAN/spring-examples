package com.kkaplan.spring_graphQL.controller;

import com.kkaplan.spring_graphQL.data.Customer;

import lombok.Data;

@Data
public class CustomerInput {
	
	private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    
    public Customer getCustomerEntity() {
    	
        return Customer.builder()
        		.firstName(firstName)
        		.lastName(lastName)
        		.email(email)
        		.phoneNumber(phoneNumber)
        		.address(address)
        		.city(city)
        		.state(state)
        		.zipCode(zipCode)
        		.build();
    }

}
