package com.lzq.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class conTool {

	public static Connection getconnection() {
		Connection conn = null;
		try {
			//��������
			Class.forName("com.mysql.cj.jdbc.Driver");
			//���������ݿ������
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lzq?serverTimezone=GMT", "root", "123456");
			//conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	

}



