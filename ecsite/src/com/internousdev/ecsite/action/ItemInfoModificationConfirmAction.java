package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemInfoDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemInfoModificationConfirmAction extends ActionSupport implements SessionAware {

	private ItemInfoDAO itemInfoDAO = new ItemInfoDAO();
	private ArrayList<ItemInfoDTO> itemInfoList = new ArrayList<ItemInfoDTO>();

	private int id;
	private String item_name;
	private int item_price;
	private int status;
	private String errorMessage;
	private Map<String, Object> session;
	private int item_stock;
	private int category_id;
	private String update_date;

	public String execute() throws SQLException {
		String result = SUCCESS;

		if (!(item_name.equals("")) && !(category_id == 0) && !(item_price == 0) && !(item_stock == 0)) {
			session.put("item_name", item_name);
			session.put("category_id", category_id);
			session.put("item_stock", item_stock);
			session.put("item_price", item_price);
		} else {
			setErrorMessage("未入力の項目があります。");
			int itemId = session.get("itemId").hashCode();
			itemInfoList = itemInfoDAO.getSingleItemInfo(itemId);
			result = ERROR;
		}
		return result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getItem_price() {
		return item_price;
	}

	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<ItemInfoDTO> getItemInfoList() {
		return this.itemInfoList;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getItem_stock() {
		return item_stock;
	}

	public void setItem_stock(int item_stock) {
		this.item_stock = item_stock;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

}
