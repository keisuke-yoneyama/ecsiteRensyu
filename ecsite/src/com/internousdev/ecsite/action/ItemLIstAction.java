package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemInfoDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.dto.PaginationDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemLIstAction extends ActionSupport implements SessionAware{
	private int retrievalFlg = 0;
	private String keywords;
	private int pageNo = 1;
	public Map<String,Object>session;
	private ItemInfoDAO itemInfoDAO  = new ItemInfoDAO();
	private Pagination
}
