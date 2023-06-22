package com.kgcoffee.web.users.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kgcoffee.web.common.DBConn;
import com.kgcoffee.web.users.vo.UsersVO;

public class UsersDAO {
	
	private static Connection con = null;
	
	private static UsersDAO userDAO;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public UsersDAO() throws ClassNotFoundException, SQLException {
		try {
			con = DBConn.getInstance().getCon();
			}catch(Exception e) {
				e.printStackTrace();
			}									
	}
	
	public static UsersDAO getInstance() throws ClassNotFoundException, SQLException {
		
		con = DBConn.getInstance().getCon();
		
		if(userDAO == null) {
			userDAO = new UsersDAO();
		}
		
		return userDAO;
	}
	
	
	// 회원가입 ================================================
	public boolean insert_user
		(String user_id, String user_pw, String user_name, String birthday, String tel) {
		
		String sql = "insert into users values(?,?,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_pw);
			pstmt.setString(3, user_name);
			pstmt.setString(4, birthday);
			pstmt.setString(5, tel);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Insert Exception");
			return false;
		}
		
		return true;
	}
	
	
	//아이디 중복 체크 => false 중복됨
	public boolean idChk(String user_id) {
		boolean result = false;
		
		String sql = "SELECT * FROM users where user_id=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, user_id);
			
			rs = pstmt.executeQuery();
			
			if(!rs.next()) 
				result = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("idChk Exception");
		}
		
		return result;
	}
	
	
	// 로그인 ================================================
	public UsersVO select_login(String user_id, String user_pw) {
		
		UsersVO loginUser = null;
		
		String sql = "SELECT * FROM users where user_id=? And user_pw=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_pw);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				loginUser = new UsersVO();
				loginUser.setUser_id(rs.getString("user_id"));
				loginUser.setUser_pw(rs.getString("user_pw"));
				loginUser.setUser_name(rs.getString("user_name"));
				loginUser.setBirthday(rs.getDate("birthday"));
				loginUser.setTel(rs.getString("tel"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("select_login dao Exception");
		}
		
		return loginUser;
	}
	
	
}
