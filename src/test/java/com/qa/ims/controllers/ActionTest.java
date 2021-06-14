package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.qa.ims.controller.Action;
import com.qa.ims.utils.DBUtils;


public class ActionTest {

	

	@BeforeAll
	public static void init() {
	DBUtils.connect();
	DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void test1() {
	
		assertEquals("CREATE: To save a new entity into the database", Action.CREATE.getDescription());
		
		
	}
}
	
