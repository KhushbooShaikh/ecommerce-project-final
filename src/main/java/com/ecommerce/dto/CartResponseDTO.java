package com.ecommerce.dto;

public class CartResponseDTO {
	
	private int cartId;
	
	private String cartName;

	private int userId;
	
	private String prodName;
	
	private String prodDescription;
	
	private double prodPrice;
	
	private int prodQty;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getCartName() {
		return cartName;
	}

	public void setCartName(String cartName) {
		this.cartName = cartName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdDescription() {
		return prodDescription;
	}

	public void setProdDescription(String prodDescription) {
		this.prodDescription = prodDescription;
	}

	public double getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}

	public int getProdQty() {
		return prodQty;
	}

	public void setProdQty(int prodQty) {
		this.prodQty = prodQty;
	}

	@Override
	public String toString() {
		return "CartResponseDTO [cartId=" + cartId + ", cartName=" + cartName + ", userId=" + userId + ", prodName="
				+ prodName + ", prodDescription=" + prodDescription + ", prodPrice=" + prodPrice + ", prodQty="
				+ prodQty + "]";
	}
	
}
