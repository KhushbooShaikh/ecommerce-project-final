package com.ecommerce.dto;

public class ProductSearchResponseDTO {
	
    private int productId;
	
	private String productName;
	
	private String productDescription;
	
	private double productPrice;
	
	private int productCount;
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	@Override
	public String toString() {
		return "ProductSearchResponseDTO [productId=" + productId + ", productName=" + productName
				+ ", productDescription=" + productDescription + ", productPrice=" + productPrice + ", productCount="
				+ productCount + "]";
	}
	
}
