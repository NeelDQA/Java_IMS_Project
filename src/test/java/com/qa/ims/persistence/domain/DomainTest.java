package com.qa.ims.persistence.domain;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.qa.ims.utils.DBUtils;

public class DomainTest {

	
	@BeforeAll
	public static void init() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
		
	}
@Test
	public void test1() {
	assertEquals("CUSTOMER: Information about customers", Domain.CUSTOMER.getDescription());
}

}
