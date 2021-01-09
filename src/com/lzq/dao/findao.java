package com.lzq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lzq.bean.player;

public class findao {

	public static  player tofind(String name) {
		
		player user  = new player();
		user.setAns(0);
		
		
		Connection conn = conTool.getconnection();
		PreparedStatement presta = null;
		ResultSet res = null;
		String sql = "Select * from player where name = ?";
		try {
			presta = conn.prepareStatement(sql);
			presta.setString(1,name);
			res = presta.executeQuery();
			if(res.next()) {
				user.setName(name);
				user.setStature(res.getString("stature"));
				user.setBodyweight(res.getString("bodyweight"));
				user.setLocation(res.getString("location"));
				user.setPlayernumber(res.getString("playernumber"));
				user.setAveragescorepergame(res.getString("averagescorepergame"));
				user.setAns(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}
