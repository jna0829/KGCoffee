package com.kgcoffee.web.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.kgcoffee.web.common.DBConn;
import com.kgcoffee.web.users.vo.UsersVO;

public class MemberDAO {

	private Connection con;

	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public MemberDAO() {

		try {
			con = DBConn.getInstance().getCon();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public ArrayList<UsersVO> getAllMember(){
		
		ArrayList<UsersVO> list = new ArrayList<UsersVO>();
		
		String sql = "select * from users";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {

				String user_id = rs.getString(1);
				String user_pw = rs.getString(2);
				String user_name = rs.getString(3);
				Date birthday = rs.getDate(4);
				String tel = rs.getString(5);
				
				UsersVO users = new UsersVO(user_id, user_pw, user_name, birthday, tel);
				
				list.add(users);
				
				for (UsersVO user : list) {
				    System.out.println(user);
				}

				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			return list;
	}
}

