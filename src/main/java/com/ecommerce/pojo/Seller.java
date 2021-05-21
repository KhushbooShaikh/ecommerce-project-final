package com.ecommerce.pojo;

public class Seller {
	
	private Integer sellerId;
	private String  sellerName;
	
	public Seller() {
	
	}

	public Seller(Integer sellerId, String sellerName) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", sellerName=" + sellerName + "]";
	}
}
