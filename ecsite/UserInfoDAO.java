package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserInfoDTO;
import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class UserInfoDAO {
	private DateUtil dateUtil = new DateUtil();

	public ArrayList<UserInfoDTO> getUserInfo() throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		ArrayList<UserInfoDTO> userInfoDTO = new ArrayList<UserInfoDTO>();
		String sql = "select * from login_user_transaction";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				UserInfoDTO dto = new UserInfoDTO();
				dto.setId(resultSet.getInt("id"));
				dto.setLogin_id(resultSet.getString("login_id"));
				dto.setLogin_pass(resultSet.getString("login_pass"));
				dto.setUser_name(resultSet.getString("user_name"));
				dto.setIs_admin(resultSet.getString("is_admin"));
				dto.setAddress(resultSet.getString("address"));
				userInfoDTO.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return userInfoDTO;
	}

	public int userAllDelete() throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "delete from login_user_transaction where id != 2";
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

	public ArrayList<UserInfoDTO> getSingleUserInfo(int userId) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		ArrayList<UserInfoDTO> userInfoDTO = new ArrayList<UserInfoDTO>();
		String sql = "select * from login_user_transaction where id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				resultSet.previous();

				while (resultSet.next()) {
					UserInfoDTO dto = new UserInfoDTO();
					dto.setLogin_id(resultSet.getString("login_id"));
					dto.setLogin_pass(resultSet.getString("login_pass"));
					dto.setUser_name(resultSet.getString("user_name"));
					dto.setIs_admin(resultSet.getString("is_admin"));
					dto.setAddress(resultSet.getString("address"));
					userInfoDTO.add(dto);
				}
			} else {
				userInfoDTO = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return userInfoDTO;
	}

	public int userDelete(int userId) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "delete from login_user_transaction where id = ? and id != 2";
		PreparedStatement preparedStatement;
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return result;
	}

	public void createUser(String login_id_provisional, String login_pass_provisional, String user_name_provisional,
			String address_provisional) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "insert into login_user_transaction" + " (login_id, login_pass, user_name,"
				+ " insert_date, updated_date) values(?,?,?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, login_id_provisional);
			preparedStatement.setString(2, login_pass_provisional);
			preparedStatement.setString(3, user_name_provisional);
			preparedStatement.setString(4, dateUtil.getDate());
			preparedStatement.setString(5, dateUtil.getDate());

			preparedStatement.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

	}

	public void updateUser(int id, String login_id_provisional, String login_pass_provisional,
			String user_name_provisional, String address_provisional) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "update login_user_transaction set login_id = ?, login_pass = ?,"
				+ " user_name =?, String address=?, updated_date= ?, where id= ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, login_id_provisional);
			preparedStatement.setString(2, login_pass_provisional);
			preparedStatement.setString(3, user_name_provisional);
			preparedStatement.setString(4, address_provisional);
			preparedStatement.setString(5, dateUtil.getDate());
			preparedStatement.setInt(6, id);

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	public void resetPassword(String login_id_reset, String new_login_pass_reset) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "update login_user_transaction set" + " login_pass=?, updated_date=?, where login_id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, new_login_pass_reset);
			preparedStatement.setString(2, dateUtil.getDate());
			preparedStatement.setString(3, login_id_reset);

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	public boolean userIdCheck(String login_id) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		boolean hasUserId = true;

		String sql = "select * from login_user_transaction where login_id =?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, login_id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				hasUserId = true;
			} else {
				hasUserId = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return hasUserId;
	}
}
