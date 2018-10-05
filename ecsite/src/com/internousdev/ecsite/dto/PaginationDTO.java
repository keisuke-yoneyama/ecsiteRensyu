package com.internousdev.ecsite.dto;

import java.util.ArrayList;
import java.util.List;

public class PaginationDTO {
	private int totalPageNum; // 全ページ数
	private int currentPageNo; // 現在のページ
	private int totalRecordNum; // データ数
	private int startRecordNo; // 開始レコード番号
	private int endRecordNo; // 終了レコード番号
	private int pageSize; // 一ページに表示するデータ数
	// ページャーに表示するページ番号一覧
	private List<Integer> pageNumberList = new ArrayList<Integer>();
	// １ページ分のリストページ情報（商品情報）
	private List<ItemInfoDTO> currentItemInfoPage;
	private boolean hasNextPage; // 次ページが存在するか
	private boolean hasPreviousPage; // 前ページが存在するか
	private int nextPageNo;
	private int previousPageNo;

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getTotalRecordNum() {
		return totalRecordNum;
	}

	public void setTotalRecordNum(int totalRecordNum) {
		this.totalRecordNum = totalRecordNum;
	}

	public int getStartRecordNo() {
		return startRecordNo;
	}

	public void setStartRecordNo(int startRecordNo) {
		this.startRecordNo = startRecordNo;
	}

	public int getEndRecordNo() {
		return endRecordNo;
	}

	public void setEndRecordNo(int endRecordNo) {
		this.endRecordNo = endRecordNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<Integer> getPageNumberList() {
		return pageNumberList;
	}

	public void setPageNumberList(List<Integer> pageNumberList) {
		this.pageNumberList = pageNumberList;
	}

	public List<ItemInfoDTO> getCurrentItemInfoPage() {
		return currentItemInfoPage;
	}

	public void setCurrentItemInfoPage(List<ItemInfoDTO> currentItemInfoPage) {
		this.currentItemInfoPage = currentItemInfoPage;
	}

	public boolean hasNextPage() {
		return hasNextPage;
	}

	public void setNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public boolean hasPreviousPage() {
		return hasPreviousPage;
	}

	public void setPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public int getNextPageNo() {
		return nextPageNo;
	}

	public void setNextPageNo(int nextPageNo) {
		this.nextPageNo = nextPageNo;
	}

	public int getPreviousPageNo() {
		return previousPageNo;
	}

	public void setPreviousPageNo(int previousPageNo) {
		this.previousPageNo = previousPageNo;
	}

}
