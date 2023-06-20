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
		sql = "INSERT IN TO map_table(address_name, categoryGroupCode"
				+ ", categoryGroupName, categoryName, mapId, placeName, placeUrl, phone, roadAddressName, x, y) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getAddressName());
			pstmt.setString(1, vo.getCategoryGroupCode());
			pstmt.setString(1, vo.getCategoryGroupName());
			pstmt.setString(1, vo.getCategoryName());
			pstmt.setInt(1, vo.getMapId());
			pstmt.setString(1, vo.getPlaceName());
			pstmt.setString(1, vo.getPlaceUrl());
			pstmt.setString(1, vo.getPhone());
			pstmt.setString(1, vo.getRoadAddressName());
			pstmt.setDouble(1, vo.getX());
			pstmt.setDouble(1, vo.getY());
		
			

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
