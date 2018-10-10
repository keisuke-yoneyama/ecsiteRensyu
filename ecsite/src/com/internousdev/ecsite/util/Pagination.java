package com.internousdev.ecsite.util;


import com.internousdev.ecsite.dto.PaginationDTO;

public class Pagination {

	public PaginationDTO initialize(int totalRecordNum, int pageSize, int currentPageNo) {
		PaginationDTO paginationDTO = new PaginationDTO();
		// 全ページ数
		paginationDTO.setTotalPageNum((int)(Math.ceil((double)totalRecordNum / pageSize)));
		// 現在のページ番号
		paginationDTO.setCurrentPageNo(currentPageNo);
		//レコードのスタート位置
		paginationDTO.setStartRecordNo((currentPageNo - 1) * pageSize);
		// 終了レコード番号
		paginationDTO.setEndRecordNo(paginationDTO.getStartRecordNo() + (pageSize - 1));

		//前のページが存在するか？
		if((paginationDTO.getStartRecordNo() - 1) <= 0) {
			paginationDTO.setPreviousPage(false);
		}else {
			paginationDTO.setPreviousPage(true);
			paginationDTO.setPreviousPageNo(paginationDTO.getCurrentPageNo() - 1);
		}

		//次のページが存在するか？
		if(paginationDTO.getEndRecordNo() + 1 > totalRecordNum) {
			paginationDTO.setNextPage(false);
		}else {
			paginationDTO.setNextPage(true);
			paginationDTO.setNextPageNo(paginationDTO.getCurrentPageNo() + 1);
		}
		return paginationDTO;
	}

}
