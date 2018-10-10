package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateCompleteAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
//	private ItemCreateCompleteDAO itemCreateCompleteDAO = new ItemCreateCompleteDAO();
	private ItemInfoDAO itemInfoDAO = new ItemInfoDAO();
//	public String execute() throws SQLException {
//		itemCreateCompleteDAO.createItem(session.get("item_name").toString(), session.get("item_price").toString(),
//				session.get("category_id"),
//				session.get("item_stock"));
//
//		String result = SUCCESS;
//
//		return result;
//
//	}
	public String execute() throws SQLException{
		String result = ERROR;

		if(!session.containsKey("id")){
			return result;//カテゴリーIDのキーが入ってないとだめ
		}
		int error = itemInfoDAO.createItem
				(session.get("item_name").toString(),
				session.get("item_price").hashCode(),
				session.get("item_stock").hashCode(),
				session.get("category_id").hashCode());

		if(error == 0){ //DAOでエクセプションが無ければ０
			result = SUCCESS;
		}
		return result;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
