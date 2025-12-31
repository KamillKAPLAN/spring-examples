package com.kkaplan.spring_jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
		
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost:5433", "hplussport", "postgres", "postgres");
		try {
			Connection connection = dcm.getConnection();
			/*Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM CUSTOMER");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
			}*/
			CustomerDAO customerDAO = new CustomerDAO(connection);
			/*Customer customer = Customer.builder()
					.firstName("George")
					.lastName("Washington")
					.email("george.washington@wh.gov")
					.phone("(555) 555-6543")
					.address("1234 Main St")
					.city("Mount Vernon")
					.state("VA")
					.zipCode("22121").build();
            customerDAO.create(customer);*/
			Customer customer = customerDAO.findById(102);
			System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " + customer.getEmail());
			customer.setEmail("kamilkaplnn@gmail.com");
			customer = customerDAO.update(customer);
			System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " + customer.getEmail());
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
