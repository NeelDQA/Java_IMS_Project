package com.qa.ims.persistence.domain;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;



import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {

	private static Customer testCustomer;




@Test
public void testConstructor1() {
	testCustomer = new Customer(); 
	assertTrue(testCustomer instanceof Customer);
	
}
@Test
public void testConstructor2() {
	testCustomer = new Customer("N","D");
	assertTrue(testCustomer instanceof Customer);
}

@Test
public void testMainConstructor() {
	testCustomer = new Customer(12345L,"N","D");
	assertTrue(testCustomer instanceof Customer);
}
@Test
public void testToString() {
	testCustomer = new Customer(1L,"N","D");
	String expResult = "id:1 first name:N surname:D";
	
	assertEquals(expResult,testCustomer.toString() );
	
}
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Customer.class).verify();
	}
	
	

}
