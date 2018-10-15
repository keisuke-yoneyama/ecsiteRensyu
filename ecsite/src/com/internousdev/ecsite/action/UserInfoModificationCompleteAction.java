package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoModificationCompleteAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private UserInfoDAO userInfoDAO = new UserInfoDAO();

	public String execute() throws SQLException {
		if (!session.containsKey("userId")) {
			return ERROR;
		}
		userInfoDAO.updateUser(session.get("userId").hashCode(),
				session.get("login_id_provisional").toString(),
				session.get("user_name_provisional").toString(),
				session.get("login_pass_provisional").toString(),
				session.get("address_provisional").toString());
		String result = SUCCESS;

		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
