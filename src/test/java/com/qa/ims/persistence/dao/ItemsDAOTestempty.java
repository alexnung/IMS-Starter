package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;

public class ItemsDAOTestempty {

	private final ItemsDAO DAO = new ItemsDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-Itemsschema2.sql", "src/test/resources/sql-Itemsdata2.sql");
	}
	
	@Test
	public void testEmpty() {
		List<Items> expected = new ArrayList<>();
		expected.isEmpty();
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testReadAll() {
		List<Items> expected = new ArrayList<>();
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testUpdate() {
		final Items updated = new Items(8L, "Tim", 8D);
		assertEquals(null, DAO.update(updated));
	}
	
	@Test
	public void testDelete() {
		assertEquals(0, DAO.delete(8));
	}

}
