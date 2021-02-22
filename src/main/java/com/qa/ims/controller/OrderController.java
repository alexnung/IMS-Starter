package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter Customer ID (enter 0 to cancel)");
		Long customer_ID = utils.getLong();
		if (customer_ID.equals(0l)) {
			LOGGER.info("Cancelling request");
			return null;
		}
		LOGGER.info("Please enter Item ID (enter 0 to cancel)");
		Long Item_ID = utils.getLong();
		if (Item_ID.equals(0l)) {
			LOGGER.info("Cancelling request");
			return null;
		}
		LOGGER.info("Please enter quantity (enter 0 to cancel)");
		Long quantity = utils.getLong();
		if (quantity.equals(0l)) {
			LOGGER.info("Cancelling request");
			return null;
		}
		Order order = orderDAO.create(new Order(customer_ID, Item_ID, quantity));
		LOGGER.info("Order created");
		return order;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter the ID of the order you would like to update (enter 0 to cancel)");
		Long Order_ID = utils.getLong();
		if (Order_ID.equals(0l)) {
			LOGGER.info("Cancelling request");
			return null;
		}
		LOGGER.info("Please enter CustomerID (enter 0 to cancel)");
		Long customer_ID = utils.getLong();
		if (customer_ID.equals(0l)) {
			LOGGER.info("Cancelling request");
			return null;
		}
		LOGGER.info("Please enter Item ID (enter 0 to cancel)");
		Long Item_ID = utils.getLong();
		if (Item_ID.equals(0l)) {
			LOGGER.info("Cancelling request");
			return null;
		}
		LOGGER.info("Please enter quantity (enter 0 to cancel)");
		Long quantity = utils.getLong();
		if (quantity.equals(0l)) {
			LOGGER.info("Cancelling request");
			return null;
		}
		Order order = orderDAO.update(new Order(Order_ID, customer_ID, Item_ID, quantity, 0d));
		LOGGER.info("Order Updated");
		return order;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the ID of the order you would like to delete (enter 0 to cancel)");
		Long Order_ID = utils.getLong();
		if (Order_ID.equals(0l)) {
			LOGGER.info("Cancelling request");
			return 0;
		}
		LOGGER.info("Order Deleted");
		return orderDAO.delete(Order_ID);
	}

}
