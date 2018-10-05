package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class GoAdminMyPageAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;

	public String execute() {
		if (session.containsKey("is_admin")) {
			return SUCCESS;
		}
		return ERROR;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
