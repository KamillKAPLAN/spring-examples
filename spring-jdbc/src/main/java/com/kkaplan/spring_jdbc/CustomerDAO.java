package com.kkaplan.spring_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kkaplan.spring_jdbc.util.DataAccessObject;

public class CustomerDAO extends DataAccessObject<Customer> {

	private static final String INSERT = "INSERT INTO customer (first_name, last_name, email, phone, address, city, state, zipcode) " + 
										 "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	
	private static final String GET_ONE = "SELECT customer_id, first_name, last_name, email, phone, address, city, state, zipcode " + 
										  "FROM customer WHERE customer_id = ?";
	
	private static final String UPDATE = "UPDATE customer SET first_name = ?, last_name=?, email = ?, phone = ?, address = ?, city = ?, state = ?, zipcode = ? " + 
										 "WHERE customer_id = ?";
	
	private static final String DELETE = "DELETE FROM customer WHERE customer_id = ?";
	
	private static final String GET_ALL_LMT = "SELECT customer_id, first_name, last_name, email, phone, address, city, state, zipcode " +
            								  "FROM customer ORDER BY last_name, first_name LIMIT ?";

	private static final String GET_ALL_PAGED = "SELECT customer_id, first_name, last_name, email, phone, address, city, state, zipcode " +
			  "FROM customer ORDER BY last_name, first_name LIMIT ? OFFSET ?";
	
	public CustomerDAO(Connection connection) {
		super(connection);
	}

	@Override
	public Customer findById(long id) {
		Customer customer = null;
		try (PreparedStatement statement = this.connection.prepareStatement(GET_ONE);) {
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				customer = Customer.builder()
								.id(rs.getLong("customer_id"))
								.firstName(rs.getString("first_name"))
								.lastName(rs.getString("last_name"))
								.email(rs.getString("email"))
								.phone(rs.getString("phone"))
								.address(rs.getString("address"))
								.city(rs.getString("city"))
								.state(rs.getString("state"))
								.zipCode(rs.getString("zipcode"))
								.build();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return customer;
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer update(Customer dto) {
		Customer customer = null;
		try{
            this.connection.setAutoCommit(false);
        }catch(SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

		try (PreparedStatement statement = this.connection.prepareStatement(UPDATE);) {
			statement.setString(1, dto.getFirstName());
			statement.setString(2, dto.getLastName());
			statement.setString(3, dto.getEmail());
			statement.setString(4, dto.getPhone());
			statement.setString(5, dto.getAddress());
			statement.setString(6, dto.getCity());
			statement.setString(7, dto.getState());
			statement.setString(8, dto.getZipCode());
			statement.setLong(9, dto.getId());
			statement.execute();
			customer = findById(dto.getId());
		} catch (SQLException ex) {
			try{
                this.connection.rollback();
            }catch (SQLException sqle){
                ex.printStackTrace();
                throw new RuntimeException(sqle);
            }

			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return customer;
	}

	@Override
	public Customer create(Customer dto) {
		try (PreparedStatement statement = this.connection.prepareStatement(INSERT);) {
			statement.setString(1, dto.getFirstName());
			statement.setString(2, dto.getLastName());
			statement.setString(3, dto.getEmail());
			statement.setString(4, dto.getPhone());
			statement.setString(5, dto.getAddress());
			statement.setString(6, dto.getCity());
			statement.setString(7, dto.getState());
			statement.setString(8, dto.getZipCode());
			statement.execute();
			return findById(getLastVal(CUSTOMER_SEQUENCE));
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
	
	public List<Customer> findAllSorted(int limit) {
		List<Customer> customers = new ArrayList<>();
		try (PreparedStatement statement = this.connection.prepareStatement(GET_ALL_LMT);) {
			statement.setInt(1, limit);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Customer customer = Customer.builder()
						.id(rs.getLong("customer_id"))
						.firstName(rs.getString("first_name"))
						.lastName(rs.getString("last_name"))
						.email(rs.getString("email"))
						.phone(rs.getString("phone"))
						.address(rs.getString("address"))
						.city(rs.getString("city"))
						.state(rs.getString("state"))
						.zipCode(rs.getString("zipcode"))
						.build();
				customers.add(customer);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return customers;
	}
	
	public List<Customer> findAllPaged(int limit, int pageNumber) {
		List<Customer> customers = new ArrayList<>();
		int offset = ((pageNumber - 1) * limit);
		try (PreparedStatement statement = this.connection.prepareStatement(GET_ALL_PAGED);) {
			if (limit < 1) {
				limit = 10;
			}
			statement.setInt(1, limit);
			statement.setInt(2, offset);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Customer customer = Customer.builder()
						.id(rs.getLong("customer_id"))
						.firstName(rs.getString("first_name"))
						.lastName(rs.getString("last_name"))
						.email(rs.getString("email"))
						.phone(rs.getString("phone"))
						.address(rs.getString("address"))
						.city(rs.getString("city"))
						.state(rs.getString("state"))
						.zipCode(rs.getString("zipcode"))
						.build();
				customers.add(customer);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return customers;
	}


	@Override
	public void delete(long id) {
		try (PreparedStatement statement = this.connection.prepareStatement(DELETE);) {
			statement.setLong(1, id);
			statement.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

}
