package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrdersDAOTestempty {

	private final OrderDAO DAO = new OrderDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-Ordersschema2.sql", "src/test/resources/sql-Orderdata2.sql");
	}
	
	@Test
	public void testEmpty() {
		List<Order> expected = new ArrayList<>();
		expected.isEmpty();
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testUpdate() {
		final Order updated = new Order(8L, 2L, 2L);
		assertEquals(null, DAO.update(updated));
	}
	
	@Test
	public void testDelete() {
		assertEquals(0, DAO.delete(8));
	}

}
