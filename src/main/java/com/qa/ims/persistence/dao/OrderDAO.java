package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {

		Long orderID = resultSet.getLong("order_id");
		String order_status = resultSet.getString("order_status");
		Double order_price = resultSet.getDouble("order_price");
		Long customer_id = resultSet.getLong("cust_id");
		Long itemID = resultSet.getLong("itemID");
		Long order_quantity = resultSet.getLong("order_quantity");
		Double unitPrice = resultSet.getDouble("unit_price");
		Long order_items_id = resultSet.getLong("order_items_id");

		return new Order(orderID, order_status, order_price, customer_id, itemID, order_quantity, unitPrice,
				order_items_id);

	}

	@Override
	public List<Order> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(
						"Select order_items_id,order_id, cust_id, order_status, itemID, order_quantity, unit_price, order_price from orders join order_items on orders.order_id = order_items.orderID");) {
			List<Order> orders = new ArrayList<>();

			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement(); // select which columns to select from
				ResultSet resultSet = statement.executeQuery(
						"Select order_items_id,order_id, cust_id, order_status, itemID, order_quantity, unit_price, order_price from orders join order_items on orders.order_id = order_items.orderID ORDER BY order_id DESC LIMIT 1");) {
			while (resultSet.next()) {
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Order AddItem(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"Insert into order_items (itemID, order_quantity, orderID) values (?, ?, ?)");) {

			statement.setLong(1, order.getItemID());
			statement.setLong(2, order.getOrderQuatitiy());
			statement.setLong(3, order.getOrderId());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());

		}
		return null;

	}

	@Override
	public Order create(Order order) {

		try (Connection connection = DBUtils.getInstance().getConnection();

				PreparedStatement statement = connection
						.prepareStatement("insert into orders (cust_id, order_status, order_price) values(?, ?, ?)");) {
			statement.setLong(1, order.getCustID());
			statement.setString(2, order.getOrderStatus());
			statement.setDouble(3, order.getOrderPrice());
			statement.executeUpdate();
			System.out.println("HELLO");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Order read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"Select order_items_id,order_id, cust_id, order_status, itemID, order_quantity, unit_price, order_price from orders join order_items on orders.order_id= order_items.orderID where order_id = ?");) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				while (resultSet.next()) {
					return modelFromResultSet(resultSet);
				}
			}

		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Order update(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("Update orders set order_status = ? where order_id = ?");) {
			statement.setString(1, order.getOrderStatus());
			statement.setLong(2, order.getOrderId());
		
			statement.executeUpdate();

			return read(order.getOrderId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Order Ordertotal(Order order) {
		try (Connection conncection = DBUtils.getInstance().getConnection();
				PreparedStatement unitprice = conncection.prepareStatement(
						"Update order_items set unit_price = ((Select item_price from items where item_id= ?)*order_quantity) where itemID= ?");) {
			unitprice.setLong(1, order.getItemID());
			unitprice.setLong(2, order.getItemID());
			unitprice.executeUpdate();
			PreparedStatement totalPrice = conncection.prepareStatement(
					"Update orders set order_price = ((Select sum(unit_price) from order_items where orderID = ?)) where order_id = ?");
			totalPrice.setLong(1, order.getOrderId());
			totalPrice.setLong(2, order.getOrderId());

			totalPrice.executeUpdate();
			return readLatest();
			// ADD IN THE ORDER TOTAL
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE order_id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	public int deleteItem(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("Delete from order_items  where orderID = ? and itemID = ?");) {
			statement.setLong(1, order.getOrderId());
			statement.setLong(2, order.getItemID());

			return statement.executeUpdate();

		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}

		return 0;
	}

}
