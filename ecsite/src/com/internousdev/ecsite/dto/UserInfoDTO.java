package com.internousdev.ecsite.dto;


public class UserInfoDTO {
	private String login_id;
	private String login_pass;
	private String user_name;
	private String is_admin;
	private String address;

	public String getLogin_id(){
		return login_id;
	}
	public void setLogin_id(String login_id){
		this.login_id = login_id;
	}
	public String getLogin_pass(){
		return login_pass;
	}

	public void setLogin_pass(String login_pass){
		this.login_pass = login_pass;
	}

	public String getUserName(){
		return user_name;
	}
	public void setUser_name(String user_name){
		this.user_name = user_name;
	}
	public String getIs_admin(){
		return is_admin;
	}
	public void setIs_admin(String is_admin){
		this.is_admin = is_admin;
	}
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address;
	}
}
