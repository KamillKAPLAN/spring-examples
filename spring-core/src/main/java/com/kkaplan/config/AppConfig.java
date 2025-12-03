package com.kkaplan.config;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kkaplan.services.UserService;

import com.github.javafaker.Faker;
import com.kkaplan.model.Employee;
import com.kkaplan.model.User;

@Configuration
public class AppConfig {

	@Bean
	public UserService userService() {	
		UserService userService = new UserService();
		
		List<User> users = new ArrayList<>();
		users.add(new User("Kamil"));
		users.add(new User("Melih"));
		
		userService.setUserList(users);
		
		return userService;
	}
	
	@Bean
	public List<Employee> employeeList() {
		
		List<Employee> employees = new ArrayList<>();
		Faker faker = new Faker(new Locale("tr"));
		for (int i = 1; i <= 50; i++) {
			employees.add(new Employee(
					i,
					faker.name().firstName(),
					faker.name().lastName(),
					faker.date().birthday(),
					faker.name().title(),
					faker.educator().secondarySchool(),
					faker.educator().university(),
					faker.educator().course(),
					faker.educator().campus()
			));
		}
		return employees.stream()
                .sorted(Comparator.comparing(Employee::getId))
                .toList();
	}
}
