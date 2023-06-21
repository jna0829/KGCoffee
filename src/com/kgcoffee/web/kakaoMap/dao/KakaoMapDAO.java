package com.kgcoffee.web.kakaoMap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kgcoffee.web.common.DBConn;
import com.kgcoffee.web.common.LoggableStatement;
import com.kgcoffee.web.kakaoMap.vo.KakaoMapVO;

public class KakaoMapDAO {

	private Connection con = null;
	private String sql="";
	private PreparedStatement pstmt= null;
	private ResultSet rs = null;
	
	
	private static KakaoMapDAO dao = new KakaoMapDAO();
	
	public static KakaoMapDAO getInstance() {
		return dao;
	}
	
	private KakaoMapDAO() {
		// TODO Auto-generated constructor stub
		try {
		con = DBConn.getInstance().getCon();
		}catch(Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	
	public boolean insertMapList(KakaoMapVO vo) {
		
		boolean result=false;
		sql = "INSERT INTO map_table(address_name, category_group_code"
				+ ", category_group_name, category_name, map_id, place_name, place_url, phone, road_address_name, x, y) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			
			pstmt= new LoggableStatement(con,sql);
			pstmt.setString(1, vo.getAddressName());
			pstmt.setString(2, vo.getCategoryGroupCode());
			pstmt.setString(3, vo.getCategoryGroupName());
			pstmt.setString(4, vo.getCategoryName());
			pstmt.setInt(5, vo.getMapId());
			pstmt.setString(6, vo.getPlaceName());
			pstmt.setString(7, vo.getPlaceUrl());
			pstmt.setString(8, vo.getPhone());
			pstmt.setString(9, vo.getRoadAddressName());
			pstmt.setDouble(10, vo.getX());
			pstmt.setDouble(11, vo.getY());
		
			System.out.println(((LoggableStatement)pstmt).getQueryString());

			if(pstmt.executeUpdate()>=1) {
				
				
				pstmt.close();
				
				return true;
				
			}else {
				pstmt.close();
				return result;
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
			
		
		return result;
	}



	
	
	
	
	
}
