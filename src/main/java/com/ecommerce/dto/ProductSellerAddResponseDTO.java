package com.ecommerce.dto;

public class ProductSellerAddResponseDTO {
	
	private int productId;
	
	private String productName;
	
	private String productDescription;
	
	private double productPrice;
	
	private int productCount;
	
	private ProductCategoryResponseDTO productCategory;

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

	public ProductCategoryResponseDTO getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategoryResponseDTO productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return "ProductSellerAddResponseDTO [productId=" + productId + ", productName=" + productName
				+ ", productDescription=" + productDescription + ", productPrice=" + productPrice + ", productCount="
				+ productCount + ", productCategory=" + productCategory + "]";
	}

}
