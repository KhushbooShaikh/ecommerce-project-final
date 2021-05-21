package com.ecommerce.serviceimpl;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.dto.CartResponseDTO;
import com.ecommerce.dto.OrderDTO;
import com.ecommerce.dto.ProductAddCartDTO;
import com.ecommerce.dto.ProductSearchDTO;
import com.ecommerce.dto.ProductSearchResponseDTO;
import com.ecommerce.exception.PaymentFailedException;
import com.ecommerce.pojo.Cart;
import com.ecommerce.pojo.Order;
import com.ecommerce.pojo.Payment;
import com.ecommerce.pojo.Product;
import com.ecommerce.repo.CartRepository;
import com.ecommerce.repo.OrderRepository;
import com.ecommerce.repo.PaymentRepository;
import com.ecommerce.repo.ProductRepository;
import com.ecommerce.repo.UserRepository;
import com.ecommerce.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CartRepository cartRepository;

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	UserRepository userRepository;

	private final String PAYMENT_SUCCESS = "payment_success";
	private final String PAYMENT_FAILURE = "payment_failure";

	@Override
	public List<ProductSearchResponseDTO> getProducts(ProductSearchDTO productSearchDTO) {

		List<Product> searchedProductListOne = new LinkedList<>();
		List<Product> searchedProductListSecond = new LinkedList<>();

		if (productSearchDTO.getTitle() != null) {
			searchedProductListOne = productRepository.findbyName(productSearchDTO.getTitle());

			if (productSearchDTO.getMaxPrice() < Double.MAX_VALUE || productSearchDTO.getMinPrice() > 0)
				searchedProductListSecond = productRepository.findByPrice(productSearchDTO.getMaxPrice(),
						productSearchDTO.getMinPrice());

		}

		List<ProductSearchResponseDTO> searchedProductListOneRes = populateSearchedProductListOneRes(
				searchedProductListOne);
		List<ProductSearchResponseDTO> searchedProductListSecondRes = populateSearchedProductListSecondRes(
				searchedProductListSecond);

		return populateResultList(searchedProductListOneRes, searchedProductListSecondRes);
	}

	@Override
	public CartResponseDTO addProductToCart(ProductAddCartDTO product, int userId, String cartName) {

		Product captureProduct = null;
		Product updatedProduct = new Product();

		List<Product> list = productRepository.findbyName(product.getProductName());
		if (list != null) {
			captureProduct = list.get(0);
		}
		if (captureProduct != null) {
			updatedProduct.setProductId(captureProduct.getProductId());
			updatedProduct.setProductName(captureProduct.getProductName());
			updatedProduct.setProductDescription(captureProduct.getProductDescription());
			updatedProduct.setProductPrice(captureProduct.getProductPrice());
			updatedProduct.setProductCategory(captureProduct.getProductCategory());
			updatedProduct.setProductCount(captureProduct.getProductCount() - 1);
			productRepository.saveAndFlush(updatedProduct);
		}
		return populateCartResponseDTO(product, userId, cartName);
	}

	@Override
	public OrderDTO placeOrder(int userId, int cartId) {
		Payment payment;
		Order order = new Order();
		OrderDTO orderDTO = null;
		var val = paymentRepository.findById(cartId);
		if (val.isPresent()) {
			payment = val.get();
			orderDTO = checkPaymentStatus(payment, order, userId, cartId);
		}
		return orderDTO;
	}

	private OrderDTO checkPaymentStatus(Payment payment, Order order, int userId, int cartId) {
		Order resultOrder = null;
		String cartName = null;
		if (payment.getPaymentStatus().equals(PAYMENT_SUCCESS)) {
			order.setUserId(userId);
			order.setCartId(cartId);
			resultOrder = orderRepository.saveAndFlush(order);
			cartName = cartRepository.findCartNameById(cartId);
		} else if (payment.getPaymentStatus().equals(PAYMENT_FAILURE)) {
			throw new PaymentFailedException();
		}
		return populateOrdetDTO(resultOrder, cartName);
	}

	private OrderDTO populateOrdetDTO(Order order, String cartName) {
		OrderDTO orderDTO = new OrderDTO();
		List<ProductAddCartDTO> productList = new LinkedList<>();
		double totalPrice = 0;
		var val = userRepository.findById(order.getUserId());
		orderDTO.setOrderId(order.getOrderId());
		if (val.isPresent()) {
			orderDTO.setUserName(val.get().getUserName());
		}
		List<Cart> cartList = cartRepository.findByName(cartName);
		for (Cart cart : cartList) {
			ProductAddCartDTO productDTO = new ProductAddCartDTO();
			productDTO.setProductName(cart.getProdName());
			productDTO.setProductDescription(cart.getProdDescription());
			productDTO.setProductPrice(cart.getProdPrice());
			productDTO.setProductQuantity(cart.getProdQty());
			productList.add(productDTO);
			totalPrice += cart.getProdPrice() * cart.getProdQty();
		}
		orderDTO.setCartName(cartName);
		orderDTO.setProductList(productList);
		orderDTO.setTotalPrice(totalPrice);
		return orderDTO;
	}

	private CartResponseDTO populateCartResponseDTO(ProductAddCartDTO product, int userId, String cartName) {
		CartResponseDTO cartResponseDTO = new CartResponseDTO();
		Cart cart = new Cart();
		Cart cartResult = new Cart();
		cart.setProdName(product.getProductName());
		cart.setUserId(userId);
		cart.setCartName(cartName);
		cart.setProdDescription(product.getProductDescription());
		cart.setProdQty(product.getProductQuantity());
		cart.setProdPrice(product.getProductPrice());

		cartResult = cartRepository.saveAndFlush(cart);
		cartResponseDTO.setCartId(cartResult.getCartId());
		cartResponseDTO.setCartName(cartResult.getCartName());
		cartResponseDTO.setProdDescription(cartResult.getProdDescription());
		cartResponseDTO.setProdName(cartResult.getProdName());
		cartResponseDTO.setProdPrice(cartResult.getProdPrice());
		cartResponseDTO.setProdQty(cartResult.getProdQty());
		cartResponseDTO.setUserId(cartResult.getUserId());

		return cartResponseDTO;
	}

	private List<ProductSearchResponseDTO> populateResultList(List<ProductSearchResponseDTO> searchedProductListOneRes,
			List<ProductSearchResponseDTO> searchedProductListSecondRes) {
		List<ProductSearchResponseDTO> resultProductListRes = new LinkedList<>();
		for (ProductSearchResponseDTO productOne : searchedProductListOneRes) {
			for (ProductSearchResponseDTO productSecond : searchedProductListSecondRes) {
				if (productOne.getProductId() == productSecond.getProductId())
					resultProductListRes.add(productOne);
			}
		}

		return resultProductListRes;
	}

	private List<ProductSearchResponseDTO> populateSearchedProductListSecondRes(
			List<Product> searchedProductListSecond) {
		List<ProductSearchResponseDTO> searchedProductListSecondRes = new LinkedList<>();
		for (int i = 0; i < searchedProductListSecond.size(); i++) {
			ProductSearchResponseDTO product = new ProductSearchResponseDTO();
			product.setProductId(searchedProductListSecond.get(i).getProductId());
			product.setProductName(searchedProductListSecond.get(i).getProductName());
			product.setProductDescription(searchedProductListSecond.get(i).getProductDescription());
			product.setProductCount(searchedProductListSecond.get(i).getProductCount());
			product.setProductPrice(searchedProductListSecond.get(i).getProductPrice());
			searchedProductListSecondRes.add(product);

		}

		return searchedProductListSecondRes;
	}

	private List<ProductSearchResponseDTO> populateSearchedProductListOneRes(List<Product> searchedProductListOne) {
		List<ProductSearchResponseDTO> searchedProductListOneRes = new LinkedList<>();
		for (int i = 0; i < searchedProductListOne.size(); i++) {
			ProductSearchResponseDTO product = new ProductSearchResponseDTO();
			product.setProductId(searchedProductListOne.get(i).getProductId());
			product.setProductName(searchedProductListOne.get(i).getProductName());
			product.setProductDescription(searchedProductListOne.get(i).getProductDescription());
			product.setProductCount(searchedProductListOne.get(i).getProductCount());
			product.setProductPrice(searchedProductListOne.get(i).getProductPrice());
			searchedProductListOneRes.add(product);

		}

		return searchedProductListOneRes;
	}

}
