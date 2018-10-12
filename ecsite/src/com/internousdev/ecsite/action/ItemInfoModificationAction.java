package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemInfoDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemInfoModificationAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;
	private ItemInfoDAO itemInfoDAO = new ItemInfoDAO();
	private ArrayList<ItemInfoDTO> itemInfoList = new ArrayList<ItemInfoDTO>();

	public String execute() throws SQLException {
		if (!session.containsKey("itemId") && !session.containsKey("itemId")) {
			return ERROR;
		}
		int itemId = session.get("itemId").hashCode();
		itemInfoList = itemInfoDAO.getSingleItemInfo(itemId);
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<ItemInfoDTO> getItemInfoList() {
		return this.itemInfoList;
	}
}
