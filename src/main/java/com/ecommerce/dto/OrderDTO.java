package com.ecommerce.dto;

import java.util.List;

public class OrderDTO {
	
	private int orderId;
	
	private String cartName;
	
	private String userName;
	
	private List<ProductAddCartDTO> productList;
	
	private double totalPrice;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public String getCartName() {
		return cartName;
	}

	public void setCartName(String cartName) {
		this.cartName = cartName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<ProductAddCartDTO> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductAddCartDTO> productList) {
		this.productList = productList;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "OrderDTO [orderId=" + orderId + ", cartName=" + cartName + ", userName=" + userName + ", productList="
				+ productList + ", totalPrice=" + totalPrice + "]";
	}
	
}
