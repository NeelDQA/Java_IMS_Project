package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderDAO orderDAO;
	private Utils utils;
	
	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll() ;
		for (Order order : orders) {
			LOGGER.info(order);
	}
		return orders;
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter the customer ID for which you would like to create an order for");
		Long cust_id = utils.getLong();
		
		LOGGER.info("Please enter the status of the order");
		String order_status = utils.getString();
		Double order_price  = 0.0;
		
		
		Order order = orderDAO.create(new Order( order_status, order_price,cust_id));
		LOGGER.info("Order Created: You can add items to the order by selecting UPDATE");
		return order;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long order_id = utils.getLong();
		LOGGER.info("Please enter the id of the item you would like to add to the order");
		Long item_id = utils.getLong();
		
		LOGGER.info("How much of this item would you like to add");
		Long order_quantity = utils.getLong();	
		
		LOGGER.info("Please update the status of the order");
		String order_status = utils.getString();
		Order order = orderDAO.update(new Order(order_id,order_status));
		Order orderItems  = orderDAO.AddItem(new Order(item_id, order_quantity, order_id));
		Order order_price = orderDAO.Ordertotal(new Order(order_id,item_id));
		LOGGER.info("Order Updated");
		return null;
		
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete from");
		Long id = utils.getLong();
		LOGGER.info("Would you like to delete an ITEM or the whole ORDER");
		String response = utils.getString();
		if(response.equalsIgnoreCase("item")) {
			LOGGER.info("Please enter the id of the item you would like to delete");
			Long item_id = utils.getLong();
			LOGGER.info("Item deleted");
			return orderDAO.deleteItem(new Order(id, item_id));}
		else if(response.equalsIgnoreCase("order")) {
			LOGGER.info("Order deleted");

			return orderDAO.delete(id);
		
		}
		return 0;
				
	}

}
