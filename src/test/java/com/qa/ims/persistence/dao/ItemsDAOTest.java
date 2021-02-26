package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;

public class ItemsDAOTest {

	private final ItemsDAO DAO = new ItemsDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-Itemsschema.sql", "src/test/resources/sql-Itemsdata.sql");
	}

	@Test
	public void testCreate() {
		final Items created = new Items(2L, "plate", 3D);
		assertEquals(created, DAO.create(created));
	}
	
	@Test
	public void testCreateExceptions() {
		DBUtils.connect("db.url=jdbc:h2:~/ims");
		Items updated = new Items(2L, "plate", 3D);
		assertEquals(null, DAO.create(updated));
	}

	@Test
	public void testReadAll() {
		List<Items> expected = new ArrayList<>();
		expected.add(new Items(1L, "apples", 2D));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadAllExceptions() {
		DBUtils.connect("db.url=jdbc:h2:~/ims");
		List<Items> expected = new ArrayList<>();
		List<Items> newl = new ArrayList<>();
		expected.add(new Items(1L, "apples", 2D));
		assertEquals(newl, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Items(1L, "apples", 2D), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Items(ID, "apples", 2D), DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final Items updated = new Items(1L, "plate", 3D);
		assertEquals(updated, DAO.update(updated));
	}

	@Test
	public void testUpdateExceptions() {
		DBUtils.connect("db.url=jdbc:h2:~/ims");
		Items updated = new Items(1L, "plate", 3D);
		assertEquals(null, DAO.update(updated));
	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}

	@Test
	public void DeleteExceptions() {
		DBUtils.connect("db.url=jdbc:h2:~/ims");
		Items created = new Items(1L, "Apples", 1.2D);
		DAO.create(created);
		assertEquals(0, DAO.delete(1));
	}

}
