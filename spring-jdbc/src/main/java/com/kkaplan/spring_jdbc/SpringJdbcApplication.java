package com.kkaplan.spring_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
		
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost:5433", "hplussport", "postgres", "postgres");
		try {
			Connection connection = dcm.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM CUSTOMER");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
