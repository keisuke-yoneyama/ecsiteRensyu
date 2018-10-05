package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware {
	private String login_id;
	private String login_pass;
	private String user_name;
	public Map<String, Object> session;
	private String errorMassage;
	private String address;

	public String execute() {
		String result = SUCCESS;
		if (!(login_id.equals("")) && !(login_pass.equals("")) && !(user_name.equals(""))
				&& !(address.equals(""))) {
			session.put("login_id", login_id);
			session.put("login_pass", login_pass);
			session.put("user_name", user_name);
			session.put("address", address);
		} else {
			setErrorMassage("未入力の項目があります。");
			result = ERROR;
		}
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

	public String getErrorMassage() {
		return errorMassage;
	}

	public void setErrorMassage(String errorMassage) {
		this.errorMassage = errorMassage;
	}
}
