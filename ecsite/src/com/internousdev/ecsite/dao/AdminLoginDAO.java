package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.AdminLoginDTO;
import com.internousdev.ecsite.util.DBConnector;

public class AdminLoginDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private AdminLoginDTO adminLoginDTO = new AdminLoginDTO();

	public AdminLoginDTO getAdminLoginUserInfo(String adminUserId, String adminPassword) {
		String sql = "SELECT * FROM admin_user_transaction where login_id = ? AND login_pass = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, adminUserId);
			preparedStatement.setString(2, adminPassword);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				adminLoginDTO.setAdminLoginId(resultSet.getString("admin_id"));
				adminLoginDTO.setAdminLoginPassword(resultSet.getString("admin_pass"));
				adminLoginDTO.setAdminUserName(resultSet.getString("admin_name"));

				if (!(resultSet.getString("admin_id").equals(null))) {
					adminLoginDTO.setLoginFlg(true);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adminLoginDTO;
	}

	public AdminLoginDTO getAdminLoginDTO() {
		return adminLoginDTO;
	}
}
