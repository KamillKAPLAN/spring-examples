package com.kkaplan.spring_jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

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
			/*Customer customer = customerDAO.findById(102);
			System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " + customer.getEmail());
			customer.setEmail("kamilkaplnn@gmail.com");
			customer = customerDAO.update(customer);
			System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " + customer.getEmail());*/
			/*Customer customer = Customer.builder()
					.firstName("John")
					.lastName("Adams")
					.email("jadams.wh.gov")
					.address("1234 Main St")
					.city("Arlington")
					.state("VA")
					.phone("555) 555-9845")
					.zipCode("01234")
					.build();
            Customer dbCustomer = customerDAO.create(customer);
            System.out.println(dbCustomer);
            dbCustomer = customerDAO.findById(dbCustomer.getId());
            System.out.println(dbCustomer);
            dbCustomer.setEmail("john.adams@wh.gov");
            dbCustomer = customerDAO.update(dbCustomer);
            System.out.println(dbCustomer);
            customerDAO.delete(dbCustomer.getId());*/
			OrderDAO orderDAO = new OrderDAO(connection);
			/*Order order = orderDAO.findById(1086);
			System.out.println(order);*/
			/*orderDAO.getOrdersForCustomer(789).forEach(System.out::println); */
			/*customerDAO.findAllSorted(20).forEach(System.out::println);*/
			System.out.println("Paged");
			for (int i = 1; i < 3; i++) {
				System.out.println("Page number: " + i);
				customerDAO.findAllPaged(10, i).forEach(System.out::println);
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
