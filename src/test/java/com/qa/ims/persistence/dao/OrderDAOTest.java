package com.qa.ims.persistence.dao;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {
	private final OrderDAO DAO = new OrderDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");

	}
	
	
	@Test
	public void testCreate() {
		
		final Order created = new Order("DeL",1.0,2L);
		
	assertEquals (null, DAO.create(created));
		
	}
	
	@Test
	public void testAdd() {
		final Order created = new Order(1L, 1L, 1L);
		final Order join = new Order(1L, "oos", 0.0, 1L, 1L, 1L, 0.0, 1L);
		assertEquals(join, DAO.AddItem(created));
		
		
	}
	
	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1L, "oos", 0.0, 1L, 1L, 1L, 0.0, 1L));
		
		assertEquals(expected, DAO.readAll());
		}

	@Test
	public void testreadLatest() {
		
		assertEquals(new Order(1L, "oos", 0.0, 1L, 1L, 1L, 0.0, 1L), DAO.readLatest());
	}
	
	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Order(ID, "oos", 0.0, 1L, 1L, 1L, 0.0, 1L), DAO.read(ID));
	}
	@Test
	public void testUpdate() {
		final Order updated = new Order(1L, "In stock");
		assertEquals(new Order(1L, "In stock", 0.0, 1L, 1L, 1L, 0.0, 1L), DAO.update(updated));
	}

	@Test
	public void testOrderTotal() {
		final Order total = new Order(1L, 1L);
		assertEquals(new Order (1L, "oos", 1.0, 1L, 1L, 1L, 1.0, 1L), DAO.Ordertotal(total));
	}
	@Test
	public void testDeleteOrder() {
		assertEquals(1, DAO.delete(1));
		
		}
	
	@Test
	public void testDeleteItem() {
		assertEquals(1,DAO.deleteItem(new Order(1L, 1L)));
	}
}
