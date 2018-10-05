package com.internousdev.ecsite.dto;

public class LoginDTO {
	private boolean loginFlg = false;

	private String login_id;

	private String login_pass;

	private String user_name;

	private int is_admin;//adminの情報を入れる変数

	private String address;



	public int getIsAdmin(){//adminのげッター
		return is_admin;
	}

	public void setIsAdmin(int is_admin){//adminのセッター
		this.is_admin = is_admin;
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

	public String getUserName() {
		return user_name;
	}

	public void setUserName(String user_name) {
		this.user_name = user_name;
	}

	public boolean getLoginFlg() {
		return loginFlg;
	}

	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
