package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order_Details;
import com.qa.ims.utils.DBUtils;

public class OrdersdetailsDAOTestempty {

	private final OrderDetailsDAO DAO = new OrderDetailsDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-Ordersschema2.sql", "src/test/resources/sql-Orderdata2.sql");
	}
	
	@Test
	public void testEmpty() {
		List<Order_Details> expected = new ArrayList<>();
		expected.isEmpty();
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testReadAll() {
		List<Order_Details> expected = new ArrayList<>();
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testUpdate() {
		final Order_Details updated = new Order_Details(8L, 2L, 2L);
		assertEquals(null, DAO.update(updated));
	}
	
	@Test
	public void testDelete() {
		assertEquals(0, DAO.delete(8));
	}

}
