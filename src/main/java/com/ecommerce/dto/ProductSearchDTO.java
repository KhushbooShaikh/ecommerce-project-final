package com.ecommerce.dto;

public class ProductSearchDTO {

	private String title = "";

	private double minPrice = 0d;

	private double maxPrice= Double.MAX_VALUE;	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}

	public Double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}
	
}
