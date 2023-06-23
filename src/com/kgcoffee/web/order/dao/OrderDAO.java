package com.kgcoffee.web.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kgcoffee.web.common.DBConn;
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
		
		
		
		return result;
		
		
	}
	

	public OrderVO findOrder() {
		
		OrderVO order = null;
		
		
		
		return order
		
	}
	
	
	
}
