package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.dto.CartResponseDTO;
import com.ecommerce.dto.OrderDTO;
import com.ecommerce.dto.ProductAddCartDTO;
import com.ecommerce.dto.ProductSearchDTO;
import com.ecommerce.dto.ProductSearchResponseDTO;
import com.ecommerce.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping("/searchProducts")
	public ResponseEntity<List<ProductSearchResponseDTO> >searchProducts(@RequestBody ProductSearchDTO productSearchDTO) {
		return ResponseEntity.ok(userService.getProducts(productSearchDTO));
	}
	
	@PostMapping("/addProductToCart/{userId}/{cartName}")
	public ResponseEntity<CartResponseDTO> addProductToCart(@RequestBody ProductAddCartDTO product, @PathVariable int userId, @PathVariable String cartName) {
		return ResponseEntity.ok(userService.addProductToCart(product, userId, cartName));
	}
	
	@PostMapping("/placeOrder/{userId}/{cartId}")
	public ResponseEntity<OrderDTO> placeOrder(@PathVariable int userId, @PathVariable int cartId) {
		return ResponseEntity.ok(userService.placeOrder(userId, cartId));
	}
	
}
