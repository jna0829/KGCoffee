package com.kgcoffee.web.order.domain;

public class OrderDetail extends CartVO{

	private int OrderDetailId;
	
	private int OrderId;
	
		
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}


	public int getOrderDetailId() {
		return OrderDetailId;
	}


	public void setOrderDetailId(int orderDetailId) {
		OrderDetailId = orderDetailId;
	}


	public int getOrderId() {
		return OrderId;
	}


	public void setOrderId(int orderId) {
		OrderId = orderId;
	}


	public OrderDetail(int orderDetailId, int orderId) {
		super();
		OrderDetailId = orderDetailId;
		OrderId = orderId;
	}


	@Override
	public String toString() {
		return "OrderDetail [OrderDetailId=" + OrderDetailId + ", OrderId=" + OrderId + ", getCartId()=" + getCartId()
				+ ", getUserId()=" + getUserId() + ", getMenuAmount()=" + getMenuAmount() + ", getMenuId()="
				+ getMenuId() + ", getFileName()=" + getFileName() + ", getCaffeineType()=" + getCaffeineType()
				+ ", getMenuName()=" + getMenuName() + ", getMenuPrice()=" + getMenuPrice() + ", getMenuExplain()="
				+ getMenuExplain() + ", getMenuType()=" + getMenuType() + "]";
	}
	
	

}
