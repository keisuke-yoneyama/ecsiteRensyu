package com.internousdev.ecsite.dto;

public class AdminLoginDTO {
	private boolean loginFlg = false;

	private String admin_id;

	private String admin_pass;

	private String admin_name;

	public String getAdminLoginId() {
		return admin_id;
	}

	public void setAdminLoginId(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdminLoginPassword() {
		return admin_pass;
	}

	public void setAdminLoginPassword(String admin_pass) {
		this.admin_pass = admin_pass;
	}

	public String getAdminUserName() {
		return admin_name;
	}

	public void setAdminUserName(String admin_name) {
		this.admin_name = admin_name;
	}

	public boolean getLoginFlg() {
		return loginFlg;
	}

	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
	}
}
