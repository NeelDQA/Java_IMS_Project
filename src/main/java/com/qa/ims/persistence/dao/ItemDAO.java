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


import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAO implements Dao<Item> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Item modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long item_id = resultSet.getLong("item_id");
		String itemName = resultSet.getString("item_name");
		String itemType = resultSet.getString("item_type");
		Double itemPrice = resultSet.getDouble("item_price");
		return new Item(item_id, itemName, itemType, itemPrice);

	}

	@Override
	public List<Item> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from items");) {
			List<Item> items = new ArrayList<>();
			while (resultSet.next()) {
				items.add(modelFromResultSet(resultSet));
			}
			return items;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Item readLatest() {

		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from items order by item_id");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());

		}
		return null;
	}

	@Override
	public Item create(Item item) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("insert into items(item_name, item_type, item_price) values(?, ?, ?)");) {
			statement.setString(1, item.getItemName());
			statement.setString(2, item.getItemType());
			statement.setDouble(3, item.getItemPrice());
			statement.executeUpdate();
			return readLatest();

		} catch (Exception e) {

			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}

		return null;
	}

	@Override
//	public Item read(Long id) {
//		try (Connection connection = DBUtils.getInstance().getConnection();
//				PreparedStatement statement = connection.prepareStatement("Select * from items where item_id = ? ");) {
//			statement.setLong(1, id);
//			try (ResultSet resultSet = statement.executeQuery();) {
//				resultSet.next();
//				return modelFromResultSet(resultSet);
//
//			}
//
//		} catch (Exception e) {
//		
//		}
//		return null;
//	}

	public Item read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE item_id = ?");) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
		
		}
		return null;
	}
	@Override
	public Item update(Item item) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"Update items set item_name = ?, item_type = ?, item_price = ? where item_id = ?");) {
			statement.setString(1, item.getItemName());
			statement.setString(2, item.getItemType());
			statement.setDouble(3, item.getItemPrice());
			statement.setLong(4, item.getItemId());
			statement.executeUpdate();
			return read(item.getItemId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}

		return null;
	}

	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("Delete from items where item_id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();

		}

		catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}

		return 0;
	}

}
