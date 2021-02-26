package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrdersDAOTest {

	private final OrderDAO DAO = new OrderDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-Ordersschema.sql", "src/test/resources/sql-Ordersdata.sql");
	}

	@Test
	public void testCreate() {
		final Order created = new Order(2L,2L,2L,2L,3D);
		assertEquals(created, DAO.create(created));
	}
	
	@Test
	public void testCreateExceptions() {
		DBUtils.connect("db.url=jdbc:h2:~/ims");
		Order updated = new Order(2L,2L,2L,2L,3D);
		assertEquals(null, DAO.create(updated));
	}

	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1L,1L, 1L, 1L,1.2D));
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testReadAllExceptions() {
		DBUtils.connect("db.url=jdbc:h2:~/ims");
		List<Order> expected = new ArrayList<>();
		List<Order> newl = new ArrayList<>();
		expected.add(new Order(1L,1L,1L,1L,1.2D));
		assertEquals(newl, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Order(1L,1L, 1L, 1L,1.2D), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Order(ID, 1L, 1L,1L,1.2D), DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final Order updated = new Order(1L, 1L, 2L, 3L,4.5D);
		assertEquals(updated, DAO.update(updated));
	}
	
	@Test
	public void testUpdateExceptions() {
		DBUtils.connect("db.url=jdbc:h2:~/ims");
		Order updated = new Order(1L, 1L, 2L, 3L, 4.5D);
		assertEquals(null, DAO.update(updated));
	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
	
	@Test
	public void DeleteExceptions() {
		DBUtils.connect("db.url=jdbc:h2:~/ims");
		Order created = new Order(1L, 1L, 1L,1L,1.2D);
		DAO.create(created);
		assertEquals(0, DAO.delete(1));
	}
}
