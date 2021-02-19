package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Customer;
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
		LOGGER.info("Please enter Customer ID");
		Long custID = utils.getLong();
		LOGGER.info("Please enter Item ID");
		Long Item_ID = utils.getLong();
		LOGGER.info("Please enter quantity");
		Long quantity = utils.getLong();
		Order order = orderDAO.create(new Order(custID, Item_ID, quantity));
		LOGGER.info("Order created");
		return order;
	}

//	@Override
//	public Order update() {
//		LOGGER.info("Please enter the OrderID of the order you would like to update");
//		Long orderID = utils.getLong();
//		LOGGER.info("Please enter a CustomerID");
//		String custID = utils.getString();
//		LOGGER.info("Please enter a surname");
//		String surname = utils.getString();
//		Customer customer = customerDAO.update(new Customer(custID, first_name, surname));
//		LOGGER.info("Customer Updated");
//		return customer;
//	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the OrderID of the order you would like to delete");
		Long orderID = utils.getLong();
		return orderDAO.delete(orderID);
	}

}
