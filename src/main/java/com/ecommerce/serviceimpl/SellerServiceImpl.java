package com.ecommerce.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.dto.ProductCategoryResponseDTO;
import com.ecommerce.dto.ProductSellerAddResponseDTO;
import com.ecommerce.pojo.Product;
import com.ecommerce.repo.ProductRepository;
import com.ecommerce.service.SellerService;

@Service
public class SellerServiceImpl implements SellerService{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public ProductSellerAddResponseDTO addProduct(Product product) {
		Product productResult = productRepository.saveAndFlush(product);		
		return populateProductResponse(productResult);
	}
	
	private ProductSellerAddResponseDTO populateProductResponse(Product product) {
		ProductSellerAddResponseDTO productSellerAddResponseDTO = new ProductSellerAddResponseDTO();
		ProductCategoryResponseDTO productCategoryResponseDTO = new ProductCategoryResponseDTO();
		productCategoryResponseDTO.setId(product.getProductCategory().getId());
		productCategoryResponseDTO.setType(product.getProductCategory().getType());
		productSellerAddResponseDTO.setProductId(product.getProductId());
		productSellerAddResponseDTO.setProductName(product.getProductName());
		productSellerAddResponseDTO.setProductDescription(product.getProductDescription());
		productSellerAddResponseDTO.setProductCount(product.getProductCount());
		productSellerAddResponseDTO.setProductPrice(product.getProductPrice());
		productSellerAddResponseDTO.setProductCategory(productCategoryResponseDTO);
		return productSellerAddResponseDTO;
	}

}
