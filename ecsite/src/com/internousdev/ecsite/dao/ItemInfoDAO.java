package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.dto.PaginationDTO;
import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class ItemInfoDAO {

	private DateUtil dateUtil = new DateUtil();

	public ArrayList<ItemInfoDTO> getItemInfo() throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		ArrayList<ItemInfoDTO> itemInfoDTO = new ArrayList<ItemInfoDTO>();
		String sql = "select * from item_info_transaction where status != 1";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				resultSet.previous();

				while (resultSet.next()) {
					ItemInfoDTO dto = new ItemInfoDTO();
					dto.setId(resultSet.getInt("id"));
					dto.setItem_name(resultSet.getString("item_name"));
					dto.setItem_price(resultSet.getInt("item_price"));
					dto.setItem_stock(resultSet.getInt("item_stock"));
					dto.setCategory_id(resultSet.getInt("category_id"));
					itemInfoDTO.add(dto);
				}
			} else {
				itemInfoDTO = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return itemInfoDTO;
	}

	public int itemAllDelete() throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "update item_info_transaction set status = 1";
		PreparedStatement preparedStatement;
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return result;
	}

	public ArrayList<ItemInfoDTO> getSingleItemInfo(int itemId) throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		ArrayList<ItemInfoDTO> itemInfoDTO = new ArrayList<ItemInfoDTO>();
		String sql = "select * from item_info_transaction where id = ? and status != 1";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, itemId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				resultSet.previous();

				while (resultSet.next()) {
					ItemInfoDTO dto = new ItemInfoDTO();
					dto.setId(resultSet.getInt("id"));
					dto.setItem_name(resultSet.getString("item_name"));
					dto.setItem_price(resultSet.getInt("item_price"));
					dto.setItem_stock(resultSet.getInt("item_stock"));
					dto.setCategory_id(resultSet.getInt("category_id"));
					itemInfoDTO.add(dto);
				}
			} else {
				itemInfoDTO = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return itemInfoDTO;
	}

	public ItemInfoDTO getItemDatail(int id) throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		ItemInfoDTO itemInfoDTO = new ItemInfoDTO();
		String sql = "select * from item_info_transaction where id = ? and status != 1";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				itemInfoDTO.setId(resultSet.getInt("id"));
				itemInfoDTO.setItem_name(resultSet.getString("item_name"));
				itemInfoDTO.setItem_price(resultSet.getInt("item_price"));
				itemInfoDTO.setItem_stock(resultSet.getInt("item_stock"));
			} else {
				itemInfoDTO = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return itemInfoDTO;
	}

	public int itemDelete(int id) throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "update item_info_transaction set status = 1 where id = ?";
		PreparedStatement preparedStatement;
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return result;
	}

	public ArrayList<ItemInfoDTO> getItemList() throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		ArrayList<ItemInfoDTO> itemInfoDTO = new ArrayList<ItemInfoDTO>();
		String sql = "select * from item_info_transaction where status != 1";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				resultSet.previous();

				while (resultSet.next()) {
					ItemInfoDTO dto = new ItemInfoDTO();
					dto.setId(resultSet.getInt("id"));
					dto.setItem_name(resultSet.getString("item_name"));
					dto.setItem_price(resultSet.getInt("item_price"));
					dto.setItem_stock(resultSet.getInt("item_stock"));
					itemInfoDTO.add(dto);
				}
			} else {
				itemInfoDTO = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return itemInfoDTO;
	}

	public int getItemNum() throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		PaginationDTO dto = new PaginationDTO();
		String sql = "select count(*) from item_info_transaction where status != 1";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			resultSet.next();
			dto.setTotalRecordNum(resultSet.getInt("item_stock(*)"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return dto.getTotalRecordNum();
	}

	public int getItemNumKeyword(int category_id, String[] keywords) throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		PaginationDTO dto = new PaginationDTO();
		String sql = "select count(*) from item_info_transaction where ";
		boolean initializeFlag = true;
		if (category_id != 1) {
			for (String keyword : keywords) {
				if (initializeFlag) {
					sql += "category_id = " + category_id + " and (item_name like '%" + keyword + "%')";
					initializeFlag = false;
				} else {
					sql += " and (item_name like '%" + keyword + "%')";
				}
			}
		} else {
			for (String keyword : keywords) {
				if (initializeFlag) {
					sql += "(item_name like '%" + keyword + "%')";
					initializeFlag = false;
				} else {
					sql += " and (item_name like '%" + keyword + "%')";
				}
			}
		}
		sql += " and status != 1";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			resultSet.next();
			dto.setTotalRecordNum(resultSet.getInt("count(*)"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return dto.getTotalRecordNum();
	}

	public ArrayList<ItemInfoDTO> getItemListPart(int startRecordNo, int pageSize) throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		ArrayList<ItemInfoDTO> itemInfoDTO = new ArrayList<ItemInfoDTO>();
		String sql = "select * from item_info_transaction where status != 1 limit" + " ?, ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, startRecordNo);
			preparedStatement.setInt(2, pageSize);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ItemInfoDTO dto = new ItemInfoDTO();
				dto.setId(resultSet.getInt("id"));
				dto.setItem_name(resultSet.getString("item_name"));
				dto.setItem_price(resultSet.getInt("item_price"));
				dto.setItem_stock(resultSet.getInt("item_stock"));
				itemInfoDTO.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return itemInfoDTO;
	}

	public ArrayList<ItemInfoDTO> getItemListRetrieval(int startRecordNo, int pageSize, int category_id,
			String[] keywords) throws SQLException {// 未だ理解しておらず。
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		ArrayList<ItemInfoDTO> itemInfoDTO = new ArrayList<ItemInfoDTO>();
		String sql = "select * from item_info_transaction";
		boolean initializeFlag = true;
		if (category_id != 1) {
			for (String keyword : keywords) {
				if (initializeFlag) {
					sql += "category_id = " + category_id + "and(item_name like'%" + keyword + "%')";
					initializeFlag = false;
				} else {
					sql += "and(product_name like '%" + keyword + "%')";

				}
			}
			sql += "limit" + startRecordNo + "," + pageSize;
		} else {
			for (String keyword : keywords) {
				if (initializeFlag) {
					sql += "(item_name like '%" + keyword + "%')";
				}
			}
			sql += "and status != limit " + startRecordNo + "," + pageSize;
		}
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ItemInfoDTO dto = new ItemInfoDTO();
				dto.setId(resultSet.getInt("id"));
				dto.setItem_name(resultSet.getString("item_name"));
				dto.setItem_price(resultSet.getInt("item_price"));
				dto.setItem_stock(resultSet.getInt("item_stock"));
				dto.setCategory_id(resultSet.getInt("category_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return itemInfoDTO;
	}

	public int createItem(String item_name, // OK

			int item_price, int item_stock, int category_id) throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "insert into item_info_transaction(item_name," + " item_price, item_stock, "
				+ "status, category_id, update_date,insert_date) " + "values(?,?,?,?,?,?,?)";

		int error = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, item_name);
			preparedStatement.setInt(2, item_price);
			preparedStatement.setInt(3, item_stock);
			preparedStatement.setInt(4, 0);
			preparedStatement.setInt(5, category_id);
			preparedStatement.setString(6, dateUtil.getDate());
			preparedStatement.setString(7, dateUtil.getDate());
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
			error = 1; // エラーが出た時１になる
		} finally {
			connection.close();
		}
		return error;
	}

	public int updateItem(int itemId, String item_name, int category_id, int item_price, int item_stock)
			throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "update item_info_transaction set " + "item_name = ?, " + "category_id = ?, item_price = ?, "
				+ "item_stock = ?, update_date = ? where id = ?";

		int error = 0;// エラー検知用

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, item_name);
			preparedStatement.setInt(2, category_id);
			preparedStatement.setInt(3, item_price);
			preparedStatement.setInt(4, item_stock);
			preparedStatement.setString(5, dateUtil.getDate());
			preparedStatement.setInt(6, itemId);

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			error = 1;
		} finally {
			connection.close();
		}
		return error;
	}

	public int updateItemStock(int id, int item_stock) throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "update item_info set item_stock = ? where id = ?";

		int error = 0;// エラー検知用

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, item_stock);
			preparedStatement.setInt(2, id);

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			error = 1;// 検知用
		} finally {
			connection.close();// 閉じる
		}
		return error;// エラー結果をもどす
	}

}
