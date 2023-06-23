package com.kgcoffee.web.menu.menuDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kgcoffee.web.common.DBConn;
import com.kgcoffee.web.common.LoggableStatement;
import com.kgcoffee.web.menu.menuVO.MenuVO;

public class MenuDAO {
	
	private Connection con;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public MenuDAO() {
	
		try {
		con = DBConn.getInstance().getCon();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public boolean insertMenu(String fileName, String caffeineType, String menuName, int menuPrice,
			String menuExplain, String menuType) {
		
		String sql = "insert into Menu VALUES(menu_sequencel.nextval,?,?,"
				+ "?, ?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, fileName);
			pstmt.setString(2, caffeineType);
			pstmt.setString(3, menuName);
			pstmt.setInt(4, menuPrice);
			pstmt.setString(5, menuExplain);
			pstmt.setString(6, menuType);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
	
	public ArrayList<MenuVO> getMenuList() {
		
		ArrayList<MenuVO> array = new ArrayList<MenuVO>();
		
		String sql = "SELECT * FROM Menu ORDER BY menuId";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				int menuId = rs.getInt("menuId");
				String fileName = rs.getString("imgurl");
				
				String caffeineType = rs.getString("caffeineType");
				String menuName = rs.getString("menuName");
				int menuPrice = rs.getInt("menuPrice");
				String menuExplain = rs.getString("menuExplain");
				String menuType = rs.getString("menuType");
				
				MenuVO mvo = new MenuVO(menuId, fileName, caffeineType, menuName, menuPrice, 
						menuExplain, menuType);
				
				array.add(mvo);
				
				
			}

			return array;
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	
	public int totalCnt(){
		String sql = "SELECT COUNT(*) cnt FROM Menu";
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rs.next();
			int result =rs.getInt("cnt");
			
			
			System.out.println(result);
			
			return result;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	public ArrayList<MenuVO> getMenuListByPage(int page, int amount){
		
		String sql = "select * from (select A. *, ROW_NUMBER() over(order by menuId) as num"
				+ "    from Menu A)"
				+ "    where num between ? and ? order by menuId desc";
		ArrayList<MenuVO> array = new ArrayList<MenuVO>();

		
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, (page*amount)-amount+1);
			pstmt.setInt(2, page*amount);
			rs=pstmt.executeQuery();
			
			
			

			while(rs.next()){
				int menuId = rs.getInt("menuId");
				String fileName = rs.getString("imgurl");
				
				String caffeineType = rs.getString("caffeineType");
				String menuName = rs.getString("menuName");
				int menuPrice = rs.getInt("menuPrice");
				String menuExplain = rs.getString("menuExplain");
				String menuType = rs.getString("menuType");
				
				MenuVO mvo = new MenuVO(menuId, fileName, caffeineType, menuName, menuPrice, 
						menuExplain, menuType);
				
			
				array.add(mvo);
				
			}
			
		
			
			return array;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
		
	}
	
	
	public boolean deleteMenu(String menuName) {
		
		String sql = "DELETE FROM Menu WHERE menuName=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, menuName);
			pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
		
	}
	
	public boolean updateMenu(String menuName, int menuPrice, 
			String menuExplain, String menuType ) {
		
		String sql = "UPDATE Menu SET menuName=?, menuPrice=?, menuExplain,"
				+ "menuType=? WHERE menuName=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(4, menuName);
			pstmt.setInt(1, menuPrice);
			pstmt.setString(2, menuExplain);
			pstmt.setString(3, menuType);
			pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
		
	}
	
	
	
	
	
	public ArrayList<MenuVO> getInfoMenu(String caffeineType, String menuType, int page, int amount ) {
		
		ArrayList<MenuVO> arr = new ArrayList<MenuVO>();
		String sql = "select * from (select A.*, ROW_NUMBER() over(order by menuId) as num"
				+ "    from Menu A WHERE caffeineType like ? and menuType like ?) "
				+ "    where num between ? and ? order by menuId desc";
		try {
			pstmt = new LoggableStatement(con, sql);
			
			pstmt.setString(1, "%"+caffeineType+"%");
			pstmt.setString(2,"%"+ menuType+"%");
			pstmt.setInt(3, page);
			pstmt.setInt(4, amount);
			
			System.out.println("Executing query: "+
			         ((LoggableStatement)pstmt).getQueryString());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MenuVO mvo= null;
				int menuId = rs.getInt("menuId");
				String imgurl = rs.getString("imgurl");
				String CaffeineType = rs.getString("caffeineType");
				String menuName = rs.getString("menuName");
				int menuPrice = rs.getInt("menuPrice");
				String menuExplain = rs.getString("menuExplain");
				String MenuType = rs.getString("menuType");
				mvo = new MenuVO(menuId, imgurl, CaffeineType, menuName, 
						menuPrice, menuExplain, MenuType);
				arr.add(mvo);
			}
			
			return arr;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
	

}