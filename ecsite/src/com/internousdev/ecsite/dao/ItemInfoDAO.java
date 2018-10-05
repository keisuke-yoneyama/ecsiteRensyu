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
					dto.setItem_price(resultSet.getInt("price"));
					dto.setItem_stock(resultSet.getInt("stock"));
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
					dto.setItem_name(resultSet.getString("Item_name"));
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
				itemInfoDTO.setItem_price(resultSet.getInt("price"));
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

	// public int getItemNumKeyword(int category_id, String[] keywords) throws
	// SQLException {
	//
	// DBConnector dbConnector = new DBConnector();
	// Connection connection = dbConnector.getConnection();
	//
	// PaginationDTO dto = new PaginationDTO();
	// String sql = "select count(*) from product_info where ";
	// boolean initializeFlag = true;
	// if (category_id != 1) {
	// for(String keyword : keywords) {
	// if(initializeFlag) {
	// sql += "category_id = " + category_id + " and (product_name like '%" +
	// keyword + "%' or product_name_kana like '%" + keyword + "%')";
	// initializeFlag = false;
	// } else {
	// sql += " and (product_name like '%" + keyword + "%' or product_name_kana
	// like '%" + keyword + "%')";
	// }
	// }
	// } else {
	// for(String keyword : keywords) {
	// if(initializeFlag) {
	// sql += "(product_name like '%" + keyword + "%' or product_name_kana like
	// '%" + keyword + "%')";
	// initializeFlag = false;
	// } else {
	// sql += " and (product_name like '%" + keyword + "%' or product_name_kana
	// like '%" + keyword + "%')";
	// }
	// }
	// }
	// sql += " and status != 1";
	// try {
	// PreparedStatement preparedStatement = connection.prepareStatement(sql);
	// ResultSet resultSet = preparedStatement.executeQuery();
	//
	// resultSet.next();
	// dto.setTotalRecordNum(resultSet.getInt("count(*)"));
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// connection.close();
	// }
	// return dto.getTotalRecordNum();
	// }

	// public ArrayList<ItemInfoDTO> getItemListPart(int startRecordNo, int
	// pageSize) throws SQLException {
	//
	// DBConnector dbConnector = new DBConnector();
	// Connection connection = dbConnector.getConnection();
	//
	// ArrayList<ItemInfoDTO> itemInfoDTO = new ArrayList<ItemInfoDTO>();
	// String sql = "select * from product_info where status != 1 limit ?, ?";
	// try {
	// PreparedStatement preparedStatement = connection.prepareStatement(sql);
	// preparedStatement.setInt(1, startRecordNo);
	// preparedStatement.setInt(2, pageSize);
	// ResultSet resultSet = preparedStatement.executeQuery();
	//
	// while (resultSet.next()) {
	// ItemInfoDTO dto = new ItemInfoDTO();
	// dto.setId(resultSet.getInt("id"));
	// dto.setProduct_name(resultSet.getString("product_name"));
	// dto.setProduct_name_kana(resultSet.getString("product_name_kana"));
	// dto.setProduct_description(resultSet.getString("product_description"));
	// dto.setCategory_id(resultSet.getInt("category_id"));
	// dto.setPrice(resultSet.getInt("price"));
	// dto.setImage_file_path(resultSet.getString("image_file_path"));
	// dto.setImage_file_name(resultSet.getString("image_file_name"));
	// dto.setRelease_date(resultSet.getString("release_date"));
	// dto.setRelease_company(resultSet.getString("release_company"));
	// itemInfoDTO.add(dto);
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// connection.close();
	// }
	// return itemInfoDTO;
	// }

	// public ArrayList<ItemInfoDTO> getItemListRetrieval(int startRecordNo, int
	// pageSize, int category_id, String[] keywords) throws SQLException {
	//
	// DBConnector dbConnector = new DBConnector();
	// Connection connection = dbConnector.getConnection();
	//
	// ArrayList<ItemInfoDTO> itemInfoDTO = new ArrayList<ItemInfoDTO>();
	// String sql = "select * from product_info where ";
	// boolean initializeFlag = true;
	// if (category_id != 1) {
	// for(String keyword : keywords) {
	// if(initializeFlag) {
	// sql += "category_id = " + category_id + " and (product_name like '%" +
	// keyword + "%' or product_name_kana like '%" + keyword + "%')";
	// initializeFlag = false;
	// } else {
	// sql += " and (product_name like '%" + keyword + "%' or product_name_kana
	// like '%" + keyword + "%')";
	// }
	// }
	// sql += " limit " + startRecordNo + ", " + pageSize;
	// } else {
	// for(String keyword : keywords) {
	// if(initializeFlag) {
	// sql += "(product_name like '%" + keyword + "%' or product_name_kana like
	// '%" + keyword + "%')";
	// initializeFlag = false;
	// } else {
	// sql += " and (product_name like '%" + keyword + "%' or product_name_kana
	// like '%" + keyword + "%')";
	// }
	// }
	// sql += "and status != 1 limit " + startRecordNo + ", " + pageSize;
	// }
	// try {
	// PreparedStatement preparedStatement = connection.prepareStatement(sql);
	// ResultSet resultSet = preparedStatement.executeQuery();
	//
	// while (resultSet.next()) {
	// ItemInfoDTO dto = new ItemInfoDTO();
	// dto.setId(resultSet.getInt("id"));
	// dto.setProduct_name(resultSet.getString("product_name"));
	// dto.setProduct_name_kana(resultSet.getString("product_name_kana"));
	// dto.setProduct_description(resultSet.getString("product_description"));
	// dto.setCategory_id(resultSet.getInt("category_id"));
	// dto.setPrice(resultSet.getInt("price"));
	// dto.setImage_file_path(resultSet.getString("image_file_path"));
	// dto.setImage_file_name(resultSet.getString("image_file_name"));
	// dto.setRelease_date(resultSet.getString("release_date"));
	// dto.setRelease_company(resultSet.getString("release_company"));
	// itemInfoDTO.add(dto);
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// connection.close();
	// }
	// return itemInfoDTO;
	// }

	public int createItem(String item_name,

			int item_price, int item_stock) throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "insert into item_info_transaction(item_name," + " item_price, item_stock, "
				+ "status, updated_date) " + "values(?,?,?,?,?)";

		int error = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, item_name);
			preparedStatement.setInt(2, item_price);
			preparedStatement.setInt(3, item_stock);
			preparedStatement.setInt(4, 0);
			preparedStatement.setString(5, dateUtil.getDate());

			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
			error = 1;
		} finally {
			connection.close();
		}
		return error;
	}

	// public int updateItem(int id, String product_name, String
	// product_name_kana, String product_description,
	// int category_id, int price, String image_file_path, String
	// image_file_name, String release_date,
	// String release_company, int stock) throws SQLException {
	//
	// DBConnector dbConnector = new DBConnector();
	// Connection connection = dbConnector.getConnection();
	//
	// String sql = "update product_info set " + "product_name = ?,
	// product_name_kana = ?, "
	// + "product_description = ?, category_id = ?, price = ?, "
	// + "image_file_path = ?, image_file_name = ?, release_date = ?, "
	// + "release_company = ?, stock = ?, update_date = ? where id = ?";
	//
	// int error = 0;
	//
	// try {
	// PreparedStatement preparedStatement = connection.prepareStatement(sql);
	// preparedStatement.setString(1, product_name);
	// preparedStatement.setString(2, product_name_kana);
	// preparedStatement.setString(3, product_description);
	// preparedStatement.setInt(4, category_id);
	// preparedStatement.setInt(5, price);
	// preparedStatement.setString(6, image_file_path);
	// preparedStatement.setString(7, image_file_name);
	// preparedStatement.setString(8, release_date);
	// preparedStatement.setString(9, release_company);
	// preparedStatement.setInt(10, stock);
	// preparedStatement.setString(11, dateUtil.getDate());
	// preparedStatement.setInt(12, id);
	//
	// preparedStatement.executeUpdate();
	// } catch (Exception e) {
	// e.printStackTrace();
	// error = 1;
	// } finally {
	// connection.close();
	// }
	// return error;
	// }
	//
	// public int updateItemStock(int id, int stock) throws SQLException {
	//
	// DBConnector dbConnector = new DBConnector();
	// Connection connection = dbConnector.getConnection();
	//
	// String sql = "update product_info set stock = ? where id = ?";
	//
	// int error = 0;
	//
	// try {
	// PreparedStatement preparedStatement = connection.prepareStatement(sql);
	// preparedStatement.setInt(1, stock);
	// preparedStatement.setInt(2, id);
	//
	// preparedStatement.executeUpdate();
	// } catch (Exception e) {
	// e.printStackTrace();
	// error = 1;
	// } finally {
	// connection.close();
	// }
	// return error;
	// }

}
