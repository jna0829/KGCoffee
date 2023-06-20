package com.kgcoffee.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kgcoffee.web.common.DBConn;
import com.kgcoffee.web.kakaoMap.vo.KakaoMapVO;

public class KakaoMapDAO {

	Connection con = null;
	String sql="";
	PreparedStatement pstmt= null;
	ResultSet rs = null;
	
	public KakaoMapDAO() {
		// TODO Auto-generated constructor stub
		try {
		con = DBConn.getInstance().getCon();
		}catch(Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	
	public boolean insertMapList(KakaoMapVO vo) {
		
		boolean result=false;
		sql = "INSERT IN TO map_table values(?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getAddressName());
			
			

			if(pstmt.executeUpdate()>=1) {
				
				return true;
				
			}else {
				return result;
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		

		
		
		
		
		
		return result;
	}
	
	
	
	
	
	
}
