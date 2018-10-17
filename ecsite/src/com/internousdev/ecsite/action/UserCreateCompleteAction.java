package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware {
	private String login_id;
	private String login_pass;
	private String user_name;
	private String address;
	public Map<String, Object> session;

	private UserInfoDAO userInfoDAO = new UserInfoDAO();

	public String execute() throws SQLException {
		System.out.println("login_id;" + login_id);
		System.out.println("login_pass;" + login_pass);
		System.out.println("user_name;" + user_name);
		System.out.println("address;" + address);
		userInfoDAO.createUser(login_id, login_pass, user_name, address);

		session.put("id", login_id);
		session.put("login_id", login_id);

		return SUCCESS;
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

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}// ユーザー情報一覧の修正からスタート
