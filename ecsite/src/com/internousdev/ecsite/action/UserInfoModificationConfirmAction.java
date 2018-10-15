package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserInfoDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoModificationConfirmAction extends ActionSupport implements SessionAware {
	private UserInfoDAO userInfoDAO = new UserInfoDAO();

	private ArrayList<UserInfoDTO> userInfoList = new ArrayList<UserInfoDTO>();


	private String user_name;
	private String login_id;
	private String login_pass;
	private Map<String,Object>session;
	private String errorMessage;
	private String address;

	public String execute() throws SQLException {
		String result = SUCCESS;

		if(!(user_name.equals(""))
			&& !(address.equals(""))
			&& !(login_id.equals(""))
			&& !(login_pass.equals(""))) {
			session.put("user_name_provisional", user_name);
			session.put("login_id_provisional", login_id);
			session.put("address_provisional", address);
			session.put("login_pass_provisional", login_pass);
		} else {
			setErrorMessage("未入力の項目があります。");
			int userId = session.get("userId").hashCode();
			userInfoList = userInfoDAO.getSingleUserInfo(userId);
			result = ERROR;
		}
		return result;
	}



	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getLogin_pass() {
		return login_pass;
	}
	public void setLogin_pass(String login_pass) {
		this.login_pass = login_pass;
	}
	public String getErrorMessage() {
		return errorMessage;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setErrorMessage(String errorMessage) {
		// TODO 自動生成されたメソッド・スタブ
		this.errorMessage = errorMessage;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<UserInfoDTO> getUserInfoList() {
		return this.userInfoList;
	}


}
