package com.kkaplan.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kkaplan.model.Employee;
import com.kkaplan.model.UpdateEmployeeRequest;
import com.kkaplan.respository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public List<Employee> getAllEmployeeList() {
		return employeeRepository.getAllEmployeeList();
	}
	
	public Employee getEmployeeById(Integer id) {
		return employeeRepository.getEmployeeById(id);
	}
	
	public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
		return employeeRepository.getEmployeeWithParams(firstName, lastName);
	}
	
	public Employee saveEmployee(Employee newEmployee) {
		return employeeRepository.saveEmployee(newEmployee);
	}
	
	public boolean deleteEmployee(int id) {
		return employeeRepository.deleteEmployee(id);
	}
	
	public Employee updateEmployee(int id, UpdateEmployeeRequest request) {
		return employeeRepository.updateEmployee(id, request);
	}
}
