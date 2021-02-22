package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class CustomerController implements CrudController<Customer> {

	public static final Logger LOGGER = LogManager.getLogger();

	private CustomerDAO customerDAO;
	private Utils utils;

	public CustomerController(CustomerDAO customerDAO, Utils utils) {
		super();
		this.customerDAO = customerDAO;
		this.utils = utils;
	}

	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Customer> readAll() {
		List<Customer> customers = customerDAO.readAll();
		for (Customer customer : customers) {
			LOGGER.info(customer);
		}
		return customers;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Customer create() {
		LOGGER.info("Please enter a first name (enter exit to cancel)");
		String first_name = utils.getString();
		if (first_name.equals("exit")) {
			LOGGER.info("Cancelling request");
			return null;
		}
		LOGGER.info("Please enter a surname (enter exit to cancel)");
		String surname = utils.getString();
		if (surname.equals("exit")) {
			LOGGER.info("Cancelling request");
			return null;
		}
		Customer customer = customerDAO.create(new Customer(first_name, surname));
		LOGGER.info("Customer created");
		return customer;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Customer update() {
		LOGGER.info("Please enter the ID of the customer you would like to update (enter 0 to cancel)");
		Long custID = utils.getLong();
		if (custID.equals(0l)) {
			LOGGER.info("Cancelling request");
			return null;
		}
		LOGGER.info("Please enter a first name (enter exit to cancel)");
		String first_name = utils.getString();
		if (first_name.equals("exit")) {
			LOGGER.info("Cancelling request");
			return null;
		}
		LOGGER.info("Please enter a surname (enter exit to cancel)");
		String surname = utils.getString();
		if (surname.equals("exit")) {
			LOGGER.info("Cancelling request");
			return null;
		}
		Customer customer = customerDAO.update(new Customer(custID, first_name, surname));
		LOGGER.info("Customer Updated");
		return customer;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the ID of the customer you would like to delete (enter 0 to cancel)");
		Long id = utils.getLong();
		if (id.equals(0l)) {
			LOGGER.info("Cancelling request");
			return 0;
		}
		LOGGER.info("Customer Deleted");
		return customerDAO.delete(id);
	}

}
