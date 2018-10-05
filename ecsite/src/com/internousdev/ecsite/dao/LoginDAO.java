
package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;

public class LoginDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private LoginDTO loginDTO = new LoginDTO();

	public LoginDTO getLoginUserInfo(String login_id ,String login_pass) {
		String sql = "SELECT * FROM login_user_transaction where login_id = ? AND login_pass = ? ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, login_id);
			preparedStatement.setString(2, login_pass);


			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {//loginDTOの各カプセルに情報を入れていく
				loginDTO.setLogin_id(resultSet.getString("login_id"));
				loginDTO.setLogin_pass(resultSet.getString("login_pass"));
				loginDTO.setUserName(resultSet.getString("user_name"));
				loginDTO.setIsAdmin(resultSet.getInt("is_admin"));
				loginDTO.setAddress(resultSet.getString("address"));

				if (!(resultSet.getString("login_id").equals(null))) {
					loginDTO.setLoginFlg(true);// ログインしている状態（フラグをトゥルーにする）にする。
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginDTO;
	}

	public LoginDTO getLoginDTO() {
		return loginDTO;
	}
}
