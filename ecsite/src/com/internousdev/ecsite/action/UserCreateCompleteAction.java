package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware {
	private String login_id;
	private String login_pass;
	private String user_name;
	private String address;
	public Map<String, Object> session;
	private UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO();

	public String execute() throws SQLException {
		userCreateCompleteDAO.createUser(session.get("login_id").toString(), session.get("login_pass").toString(),
				session.get("user_name").toString(), session.get("address").toString());

		String result = SUCCESS;

		return result;
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

	public void setLoginPassword(String login_pass) {
		this.login_pass = login_pass;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUserName(String user_name) {
		this.user_name = user_name;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
