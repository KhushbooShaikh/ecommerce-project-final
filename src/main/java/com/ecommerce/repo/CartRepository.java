package com.ecommerce.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ecommerce.pojo.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	@Query(value="select * from cart where CART_NAME=?1",nativeQuery=true)
	List<Cart> findByName(String cartName);
	
	@Query(value="select CART_NAME from cart where CART_ID=?1",nativeQuery=true)
	String findCartNameById(int cartId);

}
