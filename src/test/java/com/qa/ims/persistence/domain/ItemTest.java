package com.qa.ims.persistence.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemTest {

	private static Item testItem;
	
	@Test
	
	public void testEquals() {
		EqualsVerifier.simple().forClass(Item.class).verify();
	}
	@Test
	public void testConstructor1() {
		testItem = new Item("A", "B", 1.0);
		assertTrue(testItem instanceof Item);
	}
	
	@Test
	public void testConstructor2() {
		testItem = new Item(1L,"A", "B", 1.0);
		assertTrue(testItem instanceof Item);
	}
	
	@Test
	
	public void testToString() {
		testItem = new Item(1L,"A", "B", 1.0);
		
	String expResult = ("item_id: 1 itemName: A itemType: B itemPrice: 1.0");
	
	assertEquals(expResult, testItem.toString());
	}
}
