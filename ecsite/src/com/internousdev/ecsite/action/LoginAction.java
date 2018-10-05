package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private String login_id;
	private String login_pass;
	public Map<String, Object> session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private BuyItemDAO buyItemDAO = new BuyItemDAO();

	public String execute() {
		String result = ERROR;
		loginDTO = loginDAO.getLoginUserInfo(login_id, login_pass);
		session.put("loginUser", loginDTO);

		if (((LoginDTO) session.get("loginUser")).getLoginFlg()) {

			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();

			session.put("login_id", loginDTO.getLogin_id());
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());
			session.put("user_name",loginDTO.getUserName());
			session.put("admin",loginDTO.getAddress());
			session.put("login_pass",loginDTO.getLogin_pass());
			session.put("address",loginDTO.getAddress());
			result = SUCCESS;
			if(loginDTO.getIsAdmin()== 1){
				session.put("is_admin",loginDTO.getIsAdmin());
				result = "admin";
			}
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

	public void setLogin_pass(String login_Pass) {
		this.login_pass = login_Pass;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
