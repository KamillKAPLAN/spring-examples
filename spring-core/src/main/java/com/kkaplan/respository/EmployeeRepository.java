package com.kkaplan.respository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.kkaplan.model.Employee;
import com.kkaplan.model.UpdateEmployeeRequest;

@Repository
public class EmployeeRepository {
	
	private List<Employee> employeeList;
	
	public EmployeeRepository(List<Employee> employeeistList) {
		this.employeeList = employeeistList;
	}
	
	public List<Employee> getAllEmployeeList() {
		return employeeList;
	}
	
	public Employee getEmployeeById(Integer id) {
		return employeeList.stream()
				.filter(employee -> id.equals(employee.getId()))
				.findFirst()
				.orElse(new Employee());
	}
	
	public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
		List<Employee> employeeWithParams = new ArrayList<>();
		if (firstName == null && lastName == null) {
			return employeeList;
		}
		for (Employee employee : employeeList) {
			if (firstName != null && lastName != null) {
				if (employee.getFirstName().equalsIgnoreCase(firstName) 
						&& employee.getLastName().equalsIgnoreCase(lastName)) {
					employeeWithParams.add(employee);
				}
			}
			if (firstName != null) {
				if (employee.getFirstName().equalsIgnoreCase(firstName)) {
					employeeWithParams.add(employee);
				}
			}
			if (lastName != null) {
				if (employee.getLastName().equalsIgnoreCase(lastName)) {
					employeeWithParams.add(employee);
				}
			}
		}
		return employeeWithParams;
	}
	
	public Employee saveEmployee(Employee newEmployee) {
		newEmployee.setId(employeeList.getLast().getId() + 1);
		employeeList.add(newEmployee);
		return newEmployee;
	}
	
	public boolean deleteEmployee(int id) {
		Optional<Employee> deleteEmployee =  employeeList.stream()
		        .filter(employee -> employee.getId().equals(id))
		        .findFirst();
		if (deleteEmployee.isEmpty()) {
			return false;
		}
		employeeList.remove(deleteEmployee.get());
		return true;
	}
	
	public boolean findEmployee(int id) {
		Employee employee = employeeList.stream()
				.filter(emp -> emp.getId().equals(id))
				.findFirst()
				.orElse(null);
		if (employee != null) {
			return true;
		}
		return false;
	}
	
	public Employee updateEmployee(int id, UpdateEmployeeRequest request) {
		
		if (findEmployee(id)) {
			deleteEmployee(id);
			
			Employee updatedEmployee = Employee.builder()
											   .id(id)
											   .firstName(request.getFirstName())
											   .lastName(request.getLastName()).build();
			employeeList.add(updatedEmployee);
			return updatedEmployee;
		}
		
		return null;
	}
}
