package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.DBUtils;

public class CustomerDAOTest {

	private final CustomerDAO DAO = new CustomerDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-Customersschema.sql", "src/test/resources/sql-Customerdata.sql");
	}

	@Test
	public void testCreate() {
		final Customer created = new Customer(2L, "Tim", "Jim");
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Customer> expected = new ArrayList<>();
		expected.add(new Customer(1L, "pete", "jones"));
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testReadAllExceptions() {
		DBUtils.connect("db.url=jdbc:h2:~/ims");
		List<Customer> expected = new ArrayList<>();
		List<Customer> newl = new ArrayList<>();
		expected.add(new Customer(1L, "pete","jones"));
		assertEquals(newl, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Customer(1L, "pete", "jones"), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Customer(ID, "pete", "jones"), DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final Customer updated = new Customer(1L, "Tim", "Jim");
		assertEquals(updated, DAO.update(updated));
	}
	
	@Test
	public void testUpdateExceptions() {
		DBUtils.connect("db.url=jdbc:h2:~/ims");
		Customer updated = new Customer(1L, "Tim", "Jim");
		assertEquals(null, DAO.update(updated));
	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
	
	@Test
	public void DeleteExceptions() {
		DBUtils.connect("db.url=jdbc:h2:~/ims");
		Customer created = new Customer(1L,"Tim","Jim");
		DAO.create(created);
		assertEquals(0,DAO.delete(1));
	}
}
