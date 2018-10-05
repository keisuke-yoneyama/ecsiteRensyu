package com.internousdev.ecsite.action;

import java.util.Map;

//import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {// sessionAwareを実装あとで
	public Map<String, Object> session;

	public String execute() {
		String result = "login";
		// 後で以前に管理者としてログインした結果があったらサクセスを返すif文を作る。
		return result;
	}
}
