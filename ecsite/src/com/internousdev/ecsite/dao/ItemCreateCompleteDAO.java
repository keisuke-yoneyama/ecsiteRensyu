package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class ItemCreateCompleteDAO {
	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private DateUtil dateUtil = new DateUtil();

	private String sql ="INSERT INTO item_info_transaction(item_name,item_price,item_stock,category_id,insert_date)VALUES(?,?,?,?,?)";

	public void createItem(String item_name,String item_price,String item_stock,int category_id)throws SQLException{
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, item_name);
			preparedStatement.setString(2, item_price);
			preparedStatement.setString(3, item_stock);
			preparedStatement.setInt(4, category_id);
			preparedStatement.setString(5, dateUtil.getDate());
			preparedStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}
}
