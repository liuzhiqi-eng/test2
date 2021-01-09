package com.lzq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class exchange {

public static int toadd(String name,String teamid) {

		
		Connection conn = null;
		PreparedStatement presta = null;
		ResultSet res = null;
		conn = conTool.getconnection();
		String sql = "select * from player where name = ?";
		try {
			presta = conn.prepareStatement(sql);
			presta.setString(1, name);
			res= presta.executeQuery();
			System.out.println(name);
			if(res.next()) {
				String sql2 = "update player set teamid = ? where name =? ";
				presta = conn.prepareStatement(sql2);
				
				presta.setString(1, teamid);
				presta.setString(2, name);
				presta.executeUpdate();
				return 1;
			}else {
				
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
}
