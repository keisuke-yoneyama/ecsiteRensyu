package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserInfoDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoChangeAction extends ActionSupport implements SessionAware {

	private int id;
	public Map<String, Object> session;
	private UserInfoDAO userInfoDAO = new UserInfoDAO();
	private ArrayList<UserInfoDTO> userInfoList = new ArrayList<UserInfoDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException {
		if (!(id == 0)) {
			session.put("login_id", id);
		}
		if (!session.containsKey("id")) {
			return ERROR;
		}
		if (deleteFlg == null) {
			userInfoList = userInfoDAO.getSingleUserInfo(id);
		} else if (deleteFlg.equals("1")) {
			delete();
		}

		String result = SUCCESS;
		return result;
	}

	public void delete() throws SQLException {
		int res = userInfoDAO.userDelete(session.get("login_id").hashCode());

		if (res > 0) {
			userInfoList = null;
			setMessage("商品情報正しく削除しました。");
		} else if (res == 0) {
			setMessage("商品情報の削除に失敗しました.");
		}
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public void setLogin_id(int id) {
		this.id = id;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<UserInfoDTO> getUserInfoList() {
		return this.userInfoList;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
