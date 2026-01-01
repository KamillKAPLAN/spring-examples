package com.kkaplan.spring_jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kkaplan.spring_jdbc.util.DataAccessObject;

public class OrderDAO extends DataAccessObject<Order> {

	private final static String GET_BY_ID = 
			"SELECT c.first_name, " +
			"       c.last_name, " +
			"       c.email, " +
			"       o.order_id, " +
			"       o.creation_date, " +
			"       o.total_due, " +
			"       o.status, " +
			"       s.first_name, " +
			"       s.last_name, " +
			"       s.email, " +
			"       ol.quantity, " +
			"       p.code, " +
			"       p.name, " +
			"       p.size, " +
			"       p.variety, " + 
			"       p.price " +
			"FROM orders o " + 
			"JOIN customer c on o.customer_id = c.customer_id " +
			"JOIN salesperson s on o.salesperson_id = s.salesperson_id " +
			"JOIN order_item ol on ol.order_id = o.order_id " +
			"JOIN product p on ol.product_id = p.product_id " +
			"WHERE o.order_id = ?";

	public OrderDAO(Connection connection) {
		super(connection);
	}

	@Override
	public Order findById(long id) {
		Order order = null;
		try (PreparedStatement statement = this.connection.prepareStatement(GET_BY_ID);) {
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			long orderId = 0;
			List<OrderLine> orderLines = new ArrayList<>();
			while (resultSet.next()) {
				if(orderId == 0){
					order = Order.builder()
							.customerFirstName(resultSet.getString(1))
							.customerLastLane(resultSet.getString(2))
							.customerEmail(resultSet.getString(3))
							.id(resultSet.getLong(4))
							.creationDate(new Date(resultSet.getDate(5).getTime()))
							.totalDue(resultSet.getBigDecimal(6))
							.status(resultSet.getString(7))
							.salespersonFirstName(resultSet.getString(8))
							.salespersonLastName(resultSet.getString(9))
							.salespersonEmail(resultSet.getString(10))
							.build();
				}
				OrderLine orderLine = OrderLine.builder()
						.quantity(resultSet.getInt(11))
						.productCode(resultSet.getString(12))
						.productName(resultSet.getString(13))
						.productSize(resultSet.getInt(14))
						.productVariety(resultSet.getString(15))
						.productPrice(resultSet.getBigDecimal(16))
						.build();
				orderLines.add(orderLine);
			}
			order.setOrderLines(orderLines);
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return order;
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order update(Order dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order create(Order dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

}
