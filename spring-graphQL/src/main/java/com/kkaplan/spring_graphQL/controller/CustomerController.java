package com.kkaplan.spring_graphQL.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.kkaplan.spring_graphQL.data.Customer;
import com.kkaplan.spring_graphQL.data.CustomerRepository;

@Controller
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    /* http://localhost:8080/graphiql
     * GraphQL Playground Chrome Extension
     */

    @QueryMapping
    public Iterable<Customer> customers() {
        return customerRepository.findAll();
    }

    @QueryMapping
    public Customer customerById(@Argument Long id) {
        return customerRepository.findById(id).orElseThrow();
    }

    @QueryMapping
    public Customer customerByEmail(@Argument String email) {
    	
        return customerRepository.findCustomerByEmail(email);
    }
    
    @MutationMapping
    public Customer addCustomer(@Argument(name="input") CustomerInput customerInput){
        return customerRepository.save(customerInput.getCustomerEntity());
    }

}
