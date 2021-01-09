 package com.lzq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class logindao {

	public static int tologin(String id, String password) {

		Connection conn = null;
		PreparedStatement presta = null;
		ResultSet res = null;

		conn = conTool.getconnection();

		String sql = "select * from user where id= ?";
		try {
			presta = conn.prepareStatement(sql);
			presta.setString(1, id);

			res= presta.executeQuery();
			if(res.next()) {
				if(res.getString("password").equals(password)) {
					return 1;
				}else {
					JOptionPane.showMessageDialog(null, "密码错误，请重新输入", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
					return 0;
				}
			}else {
				JOptionPane.showMessageDialog(null, "用户不存在，请检查你的账号", "标题",JOptionPane.WARNING_MESSAGE);
				return -1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		return 0;
	}

}
