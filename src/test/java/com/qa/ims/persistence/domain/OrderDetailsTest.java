package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderDetailsTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Order_Details.class).verify();
	}

	@Test
	public void testOrder() {
		Order_Details orderd = new Order_Details(1L, 1L);
		assertTrue(orderd instanceof Order_Details);
	}
	
	@Test
	public void testOrder2() {
		Order_Details orderd = new Order_Details(1L, 1L, 1L, 1L);
		assertTrue(orderd instanceof Order_Details);
	}

}