package com.lzq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class addnewone {

	

	
	public static int toadd(String name,String stature,String bodyweight,String location,String playernumber,String averagescorepergame,String teamid) {

		
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
			if(!res.next()) {
				String sql2 = "insert into  player values(?,?,?,?,?,?,?)";
				presta = conn.prepareStatement(sql2);
				presta.setString(1, name);
				presta.setString(2, stature);
				presta.setString(3, bodyweight);
				presta.setString(4, location);
				presta.setString(5, playernumber);
				presta.setString(6, averagescorepergame);
				presta.setString(7, teamid);
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
