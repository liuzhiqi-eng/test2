package com.lzq.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.lzq.dao.conTool;

public class registerTool {
	
	public static int tores(String id,String password) {
		int ans = 1;
		
		Connection conn = null;
		PreparedStatement presta = null;
		ResultSet res = null;
		conn = conTool.getconnection();
		String sql = "select * from user where id = ?";
		try {
			presta = conn.prepareStatement(sql);
			presta.setString(1, id);
			res= presta.executeQuery();
			if(!res.next()) {
				String sql2 = "insert into  user(password,id)values(?,?)";
				presta = conn.prepareStatement(sql2);
				
				presta.setString(1, password);
				presta.setString(2, id);
				presta.executeUpdate();
				return 1;
			}else {
				JOptionPane.showMessageDialog(null, "用户名已存在", "ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ans;
	}


}

