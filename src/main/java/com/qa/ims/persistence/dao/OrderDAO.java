package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderID = resultSet.getLong("Order_ID");
		Long custID = resultSet.getLong("customer_ID");
		Long item_ID = resultSet.getLong("item_ID");
		Long quantity = resultSet.getLong("quantity");
		Double cost = quantity * getCost(item_ID);
		return new Order(orderID, custID, item_ID, quantity, cost);

	}

	public Double getCost(Long item_ID) {
		ItemsDAO Items = new ItemsDAO();
		Double cost = Items.read(item_ID).getPrice();
		return cost;
	}

	@Override
	public List<Order> readAll() {
		long count = 0;
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
			List<Order> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
				count++;
			}
			if (count < 1) {
				LOGGER.info("Empty result set");
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY Order_ID DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Order create(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders(customer_ID, Item_ID, quantity) VALUES (?, ?,?)");) {
			statement.setLong(1, order.getCustID());
			statement.setLong(2, order.getItem_ID());
			statement.setLong(3, order.getQuantity());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Order read(Long Order_ID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE Order_ID = ?");) {
			statement.setLong(1, Order_ID);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Order update(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE orders SET customer_ID = ?, Item_ID = ?,quantity= ? WHERE Order_ID = ?");) {
			statement.setLong(1, order.getCustID());
			statement.setLong(2, order.getItem_ID());
			statement.setLong(3, order.getQuantity());
			statement.setLong(4, order.getOrderID());
			statement.executeUpdate();
			return read(order.getOrderID());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delete(long Order_ID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE Order_ID = ?");) {
			statement.setLong(1, Order_ID);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

}
