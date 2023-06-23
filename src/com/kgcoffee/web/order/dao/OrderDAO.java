package com.kgcoffee.web.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kgcoffee.web.common.DBConn;
import com.kgcoffee.web.common.Paging;
import com.kgcoffee.web.order.domain.OrderVO;

public class OrderDAO {

	
	
	
	private Connection con;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	String sql="";

	public OrderDAO() {
		// TODO Auto-generated constructor stub
	
		this.con= DBConn.getInstance().getCon();
	
	}
	
	
	
	public boolean insertOrder(OrderVO order) {
		
		boolean result= false;
		
		sql= "insert into order values(order_seq.nextval,?,?,?,?)";
		try {
		
		long ms = order.getOrderDate().getTime();
		java.sql.Date sqlDate = new java.sql.Date(ms);
		
		
		pst=con.prepareStatement(sql);
		
		pst.setString(1, order.getUserId());
		pst.setInt(2, order.getMapId());
		pst.setInt(3, order.getTotalPrice());
		
		pst.setDate(4,sqlDate);
		
		
		if(pst.executeUpdate()>=1) {
			result=true;
		}
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
		
		
	}
	

	public List<OrderVO> findOrder(Map<String,String> keyMap, Paging paging) {
		
		List<OrderVO> orderList = new ArrayList<OrderVO>();
		
		
		String type = keyMap.get("type");
		String value = "%"+keyMap.get("value")+"%";
		
		String type2="";
		
		if(value=="") {
			type2=type+" ASC";
		}else {
			type2="order_id DESC";
		}

		String sql = "select * from (select A. *, ROW_NUMBER() over(order by "+type2+") as num"
				+ "    from (select * from order_table where "+type+" = ?) A)"
				+ "    where num between ? and ?";
		
		int page = paging.getPage();
		int amount = paging.getDisplayRow();
		
		
		try {
			
			pst=con.prepareStatement(sql);
			
			pst.setString(1,value);
			
			pst.setInt(2, (page*amount)-amount+1);
			pst.setInt(3, page*amount);
			
			rs=pst.executeQuery();
			
			if(rs.next()) {
				
				OrderVO order = new OrderVO();
				
				order.setOrderId(rs.getInt("order_id"));
				order.setUserId(rs.getString("user_id"));
				order.setMapId(rs.getInt("map_id"));
				order.setTotalPrice(rs.getInt("total_price"));
				order.setOrderDate(rs.getDate("order_date"));
				
				orderList.add(order);
				
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

		
		return orderList;
		
		
	}
	
	public int findTotalCnt(Map<String,String> keyMap) {
		
		int result = 0;
		
		String type = keyMap.get("type");
		String value = "%"+keyMap.get("value")+"%";
		
		
		sql="select count(*) cnt from order_table where "+type+" = ?";
		
		try {
			
			pst= con.prepareStatement(sql);
			
			pst.setString(1, value);
			
			rs=pst.executeQuery();
			
			if(rs.next()) {
				
				result= rs.getInt("cnt");
				
				
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
		
		
	}
	
	
	
	
}
