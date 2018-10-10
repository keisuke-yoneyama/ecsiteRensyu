package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemInfoDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.dto.PaginationDTO;
import com.internousdev.ecsite.util.Pagination;
import com.opensymphony.xwork2.ActionSupport;

public class ItemLIstAction extends ActionSupport implements SessionAware {
	private int retrievalFlg = 0;
	private String keywords;
	private int category_id = 1;
	private int pageNo = 1;
	public Map<String, Object> session;
	 private ItemInfoDAO itemInfoDAO = new ItemInfoDAO();
	 private Pagination pagination = new Pagination();
	private ArrayList<ItemInfoDTO> itemInfoList = new ArrayList<ItemInfoDTO>();
	private String message;

	public String execute() throws SQLException {

		 int pageSize = 15;
	if(retrievalFlg == 1){
		if (pageNo == 1 && keywords != null) {
			session.put("keywords", keywords);
			session.put("category_id", category_id);
		}
		if (keywords == null || keywords == "") {
			keywords = " ";

		}
		int totalRecordNum = itemInfoDAO.getItemNumKeyword(category_id, keywords.replaceAll("　", " ").split(" "));

		PaginationDTO paginationDTO = pagination.initialize(totalRecordNum, pageSize, pageNo);

		itemInfoList = itemInfoDAO.getItemListRetrieval(paginationDTO.getStartRecordNo(), category_id,pageSize, keywords.replaceAll("　", " ").split(" "));

		session.put("itemInfoList", itemInfoList);

		session.put("totalPageNum", paginationDTO.getTotalPageNum());
		session.put("currentPageNo", paginationDTO.getCurrentPageNo());
		session.put("totalRecordNum", paginationDTO.getTotalRecordNum());
		session.put("startRecordNo", paginationDTO.getStartRecordNo());
		session.put("endRecordNo", paginationDTO.getEndRecordNo());
		session.put("hasNextPage", paginationDTO.hasNextPage());
		session.put("hasPreviousPage", paginationDTO.hasPreviousPage());
		session.put("nextPageNo", paginationDTO.getNextPageNo());
		session.put("previousPageNo", paginationDTO.getPreviousPageNo());

		 }else{
		 int totalRecordNum = itemInfoDAO.getItemNum();
		 PaginationDTO paginationDTO = pagination.initialize(totalRecordNum,
		 pageSize, pageNo);
		 itemInfoList =
		 itemInfoDAO.getItemListPart(paginationDTO.getStartRecordNo(),
		 pageSize);
		 session.put("itemInfoList", itemInfoList);

		 session.put("totalPageNum", paginationDTO.getTotalPageNum());
		 session.put("currentPageNo", paginationDTO.getCurrentPageNo());
		 session.put("totalRecordNum", paginationDTO.getTotalRecordNum());
		 session.put("startRecordNo", paginationDTO.getStartRecordNo());
		 session.put("endRecordNo", paginationDTO.getEndRecordNo());
		 session.put("hasNextPage", paginationDTO.hasNextPage());
		 session.put("hasPreviousPage", paginationDTO.hasPreviousPage());
		 session.put("nextPageNo", paginationDTO.getNextPageNo());
		 session.put("previousPageNo", paginationDTO.getPreviousPageNo());
		 }
		String result = SUCCESS;
		return result;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<ItemInfoDTO> getItemInfoList() {
		return this.itemInfoList;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setRetrievalFlg(int retrievalFlg) {
		this.retrievalFlg = retrievalFlg;
	}

	public int getRetrievalFlg() {
		return retrievalFlg;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getCategory_id() {
		return category_id;
	}
}
