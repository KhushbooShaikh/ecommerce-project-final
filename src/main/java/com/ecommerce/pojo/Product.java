package com.ecommerce.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	private int productId;
	
	private String productName;
	
	private String productDescription;
	
	private double productPrice;
	
	private int productCount;
	
	@ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id")
	private Category productCategory;

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public int getProductCount() {
		return productCount;
	}

	public Category getProductCategory() {
		return productCategory;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", productPrice=" + productPrice + ", productCount=" + productCount
				+ ", productCategory=" + productCategory + "]";
	}

}
