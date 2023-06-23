package com.kgcoffee.web.order.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kgcoffee.web.order.domain.OrderDetail;
import com.kgcoffee.web.order.domain.OrderVO;

public class OrderListDTO {
	
	OrderVO order;
	
	List<OrderDetail> orderDetailList;

	public OrderListDTO() {
		// TODO Auto-generated constructor stub
	}
	public OrderVO getOrder() {
		return order;
	}

	public void setOrder(OrderVO order) {
		this.order = order;
	}

	public List<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}
	
	


	
	

}
