package com.qa.ims.persistence.domain;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderTest {

	private static Order testOrder;
	
	
	@Test
	public void testConstructor1() {
		testOrder = new Order(1L,"Delivery",30.00, 1L,1L,3L,10.00,1L);
		assertTrue(testOrder instanceof Order);
		
	}
	
	@Test
	public void testConstructor2() {
		testOrder = new Order(1L,"Delivery");
		assertTrue(testOrder instanceof Order);
	}

	@Test
	
	public void testConstructor3() {
		testOrder = new Order(1L,1L,1L);
		assertTrue(testOrder instanceof Order);
	}
	@Test
	public void testConstructor4() {
		testOrder = new Order(1L,1L);
		assertTrue(testOrder instanceof Order);
		
	}
	@Test
	public void TestConstructor5() {
		testOrder = new Order("Delivery",1L);
	}
	
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Order.class).verify();
		
	}
	@Test 
	public void testToString() {
		testOrder = new Order(1L,"Delivery",30.00, 1L,1L,3L,10.00,1L);
		String expResult =  ("Order ID: 1 Order Status: Delivery Order Price: £30.0 Customer ID: 1 Item ID: 1 Order Quatitiy: 3 Unit Price: £10.0 OrderItems ID: 1");
		
		assertEquals(expResult, testOrder.toString());
}
}