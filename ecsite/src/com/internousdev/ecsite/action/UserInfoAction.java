package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserInfoDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoAction extends ActionSupport implements SessionAware{
	public Map<String,Object>session;
	private UserInfoDAO userInfoDAO = new UserInfoDAO();
	private ArrayList<UserInfoDTO> userInfoList = new ArrayList<UserInfoDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException {
		if(!session.containsKey("login_id")){
			return ERROR;
		}
		if(deleteFlg == null){

		}else if(deleteFlg.equals("1")){
			delete();
		}
		userInfoList = userInfoDAO.getUserInfo();

		String result = SUCCESS;
		return result;
	}

	public void delete() throws SQLException{
		userInfoList.clear();
		int res = userInfoDAO.userAllDelete();

		if(res > 0){
			setMessage("ユーザー情報を正しく削除しました。");
		}else if(res == 0){
			setMessage("ユーザー情報の削除に失敗しました。");
		}
	}
	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg = deleteFlg;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session = session;
	}
	public ArrayList<UserInfoDTO>getUserInfoList(){
		return this.userInfoList;
	}
	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message = message;
	}
}
