package com.james.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.james.dao.LoginDAO;
import com.james.utils.DBHelper;

import java.sql.Connection;

import com.mysql.jdbc.PreparedStatement;

public class LoginDAOImpl implements LoginDAO{
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public boolean isAuth(String username, String password,String who) {
		try {
			this.conn = DBHelper.getConnection();
			String sql = null;
			if(who.equals("admin")){
				sql = "select * from t_admin where username= ? and password = ?";
			}else if(who.equals("stu")){
				sql = "select * from t_student where username= ? and password = ?";
			}else{
				return false;
			}
			this.pstmt = (PreparedStatement) this.conn.prepareStatement(sql);
			this.pstmt.setString(1, username);
			this.pstmt.setString(2, password);
			ResultSet rs = this.pstmt.executeQuery();
			if (rs.next()) {
				this.pstmt.close();
				return true;
			}
			this.pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
