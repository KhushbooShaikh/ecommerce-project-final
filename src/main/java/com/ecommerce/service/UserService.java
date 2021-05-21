package com.ecommerce.service;

import java.util.List;
import com.ecommerce.dto.CartResponseDTO;
import com.ecommerce.dto.OrderDTO;
import com.ecommerce.dto.ProductAddCartDTO;
import com.ecommerce.dto.ProductSearchDTO;
import com.ecommerce.dto.ProductSearchResponseDTO;

public interface UserService {

	List<ProductSearchResponseDTO> getProducts(ProductSearchDTO productSearchDTO);

	CartResponseDTO addProductToCart(ProductAddCartDTO product, int userId, String cartName);

	OrderDTO placeOrder(int userId, int cartId);

}
