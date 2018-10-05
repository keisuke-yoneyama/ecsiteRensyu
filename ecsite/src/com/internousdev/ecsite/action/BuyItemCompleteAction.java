package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemCompleteAction extends ActionSupport implements SessionAware {
	private String item_transaction_id;
	private String total_price;
	private String total_count;
	private String user_master_id;
	private String pay;

	private BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();
	public Map<String, Object> session;

	public String execute() throws SQLException {
		buyItemCompleteDAO.buyItemInfo(session.get("item_transaction_id").toString(),
				session.get("total_price").toString(), session.get("total_count").toString(),
				session.get("user_master_id").toString(), session.get("pay").toString());

		String result = SUCCESS;

		return result;
	}

	public String getItemTransactionId() {
		return item_transaction_id;
	}

	public void setItemTransactionId(String item_transaction_id) {
		this.item_transaction_id = item_transaction_id;
	}

	public String getTotalPrice() {
		return total_price;
	}

	public void setTotalPrice(String total_price) {
		this.total_price = total_price;
	}

	public String getTotalCount() {
		return total_count;
	}

	public void setTotalCount(String total_count) {
		this.total_count = total_count;
	}

	public String getUserMasterId() {
		return user_master_id;
	}

	public void setUserMasterId(String user_master_id) {
		this.user_master_id = user_master_id;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
