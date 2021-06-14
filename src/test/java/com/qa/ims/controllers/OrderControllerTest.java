package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;
@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	
	@Mock
	private Utils utils;
	
	@Mock
	private OrderDAO dao;
	
	@InjectMocks
	private OrderController controller;
	
	@Test
	public void testCreate() {
		final Long CUST_ID = 1L;
		final String ORDER_STATUS = "OOS";
		final Double ORDER_PRICE = 0.0;
		final Order created  = new Order(ORDER_STATUS, ORDER_PRICE,CUST_ID);
		Mockito.when(utils.getLong()).thenReturn(CUST_ID);
		Mockito.when(utils.getString()).thenReturn(ORDER_STATUS);
		Mockito.when(dao.create(created)).thenReturn(created);
		
		
		assertEquals(created,controller.create());
		
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);
		
	}
	
	@Test
	public void testReadAll() {
		List<Order>orders = new ArrayList<>();
		orders.add(new Order(1L, "oos", 0.0, 1L, 1L, 1L, 0.0, 1L)); 
		
		Mockito.when(dao.readAll()).thenReturn(orders);
		
		assertEquals(orders,controller.readAll());
		
		Mockito.verify(dao, Mockito.times(1)).readAll();
		}
	
	@Test
	public void testUpdate() {
		Order updated = new Order(1L, "IN STOCK", 3.0, 1L, 1L, 3L, 1.0, 1L);
		
		Mockito.when(this.utils.getLong()).thenReturn(1L, updated.getItemID(),updated.getOrderQuatitiy());
		Mockito.when(this.utils.getString()).thenReturn(updated.getOrderStatus());
		
		assertEquals(null, this.controller.update());
		
		Mockito.verify(this.utils, Mockito.times(3)).getLong();
		Mockito.verify(this.utils, Mockito.times(1)).getString();
		
		
		
		}
	@Test
	public void testDelete1() {
		final long orderID = 1L;
		final long itemID = 1L;
		
		Mockito.when(utils.getLong()).thenReturn(orderID, itemID);
		Mockito.when(utils.getString()).thenReturn("Item");
		Mockito.when(dao.deleteItem(new Order(orderID, itemID))).thenReturn(1);
		
		assertEquals(1L, this.controller.delete());
		
		Mockito.verify(utils, Mockito.times(2)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(dao, Mockito.times(1)).deleteItem(new Order(orderID, itemID));
		
	}
	
	@Test
	public void testDelete2() {
		final long orderID = 1L;
		Mockito.when(utils.getLong()).thenReturn(orderID);
		Mockito.when(utils.getString()).thenReturn("Order");
		Mockito.when(dao.delete(orderID)).thenReturn(1);
		
		assertEquals(1L,this.controller.delete());	
		

		Mockito.verify(utils, Mockito.times(1)).getLong();

		Mockito.verify(utils, Mockito.times(1)).getString();
		

		Mockito.verify(dao, Mockito.times(1)).delete(orderID);
		
	}
	
	
	}

	
	
	
	
	
	
	


