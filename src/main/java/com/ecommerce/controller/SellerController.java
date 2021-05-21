package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.dto.ProductSellerAddResponseDTO;
import com.ecommerce.pojo.Product;
import com.ecommerce.service.SellerService;

@RestController
@RequestMapping("/seller")
public class SellerController {

	@Autowired
	private SellerService sellerService;

	@PostMapping("/addProduct")
	public ResponseEntity<ProductSellerAddResponseDTO> addProduct(@RequestBody Product product) {
		return ResponseEntity.ok(sellerService.addProduct(product));
	}

}
