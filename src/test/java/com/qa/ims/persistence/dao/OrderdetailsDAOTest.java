package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order_Details;
import com.qa.ims.utils.DBUtils;

public class OrderdetailsDAOTest {

	private final OrderDetailsDAO DAO = new OrderDetailsDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-Orderdetailsschema.sql", "src/test/resources/sql-Orderdetailsdata.sql");
	}

	@Test
	public void testCreate() {
		final Order_Details created = new Order_Details(2L,2L,2L, 2L, 1.3D);
		assertEquals(created, DAO.create(created));
	}
	
	@Test
	public void testCreate2() {
		final Order_Details created = new Order_Details(2L,2L,2L, 2L);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Order_Details> expected = new ArrayList<>();
		expected.add(new Order_Details(1L,1L, 1L, 1L,1.2D));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Order_Details(1L,1L, 1L, 1L,1.2D), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Order_Details(ID, 1L, 1L,1L,1.2D), DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final Order_Details updated = new Order_Details(1L, 1L, 2L, 2L,3D);
		assertEquals(updated, DAO.update(updated));
	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}
