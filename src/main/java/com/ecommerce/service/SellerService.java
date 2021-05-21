package com.ecommerce.service;

import com.ecommerce.dto.ProductSellerAddResponseDTO;
import com.ecommerce.pojo.Product;


public interface SellerService {
	
	public ProductSellerAddResponseDTO addProduct(Product product);

}
