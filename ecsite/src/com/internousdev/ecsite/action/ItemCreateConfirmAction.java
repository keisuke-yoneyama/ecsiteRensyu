package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateConfirmAction extends ActionSupport implements SessionAware {
    private int id;
	private String item_name;
	private int item_price;
	private int item_stock;
	public Map<String, Object> session;
	public String errorMassage;
	private int category_id;

	public String execute(){
		String result = SUCCESS;
		if(!(item_name.equals(""))&&
				!(item_price == 0)&&
				!(item_stock == 0)&&
				!(category_id == 0))
		{session.put("item_name", item_name);
		session.put("item_price", item_price);
		session.put("item_stock", item_stock);
		session.put("category_id", category_id);
		}else{
			setErrorMassage("未入力の情報があります。");
			result=ERROR;
		}
		return result;
	}
	public String getItem_name(){
		return item_name;
	}
	public void setItem_name(String item_name){
		this.item_name=item_name;
	}
	public int getItem_price(){
		return item_price;
	}
	public void setItem_price(int item_price){
		this.item_price=item_price;
	}
	public int getItem_stock(){
		return item_stock;
	}
	public void setItem_stock(int item_stock){
		this.item_stock = item_stock;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session = session;
	}

	public String getErrorMassage(){
		return errorMassage;
	}
	public void setErrorMassage(String errorMassage){
		this.errorMassage = errorMassage;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
