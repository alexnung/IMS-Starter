package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemsTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Items.class).verify();
	}
	
	@Test
	public void testItem() {
		Items item = new Items("apples",2D);
		assertTrue(item instanceof Items);
	}
}
