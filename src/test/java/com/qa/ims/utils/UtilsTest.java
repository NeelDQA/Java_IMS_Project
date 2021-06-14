package com.qa.ims.utils;




import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Scanner;

import org.junit.Before;

import org.junit.jupiter.api.Test;


public class UtilsTest {
	

private final Scanner scanner = null;
	

	private static Utils utils;
	

	
	@Before

	public static void init() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testScanner() {
		utils = new Utils();
			assertTrue(utils instanceof Utils);
	
	}
	
	@Test
	public void testConstructor2() {
		utils =  new Utils(scanner);
		assertTrue(utils instanceof Utils);
	}
	
		
	}


