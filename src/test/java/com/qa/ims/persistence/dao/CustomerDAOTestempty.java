package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.DBUtils;

public class CustomerDAOTestempty {

	private final CustomerDAO DAO = new CustomerDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-Customersschema2.sql", "src/test/resources/sql-Customerdata2.sql");
	}
	
	@Test
	public void testEmpty() {
		List<Customer> expected = new ArrayList<>();
		expected.isEmpty();
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testReadAll() {
		List<Customer> expected = new ArrayList<>();
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testUpdate() {
		final Customer updated = new Customer(8L, "Tim", "Jim");
		assertEquals(null, DAO.update(updated));
	}
	
	@Test
	public void testDelete() {
		assertEquals(0, DAO.delete(8));
	}

}
