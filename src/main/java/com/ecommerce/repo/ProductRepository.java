package com.ecommerce.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ecommerce.pojo.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Query(value="select * from product where PRODUCT_NAME=?1",nativeQuery=true)
	List<Product> findbyName(String productName);

	@Query(value="select * from product where PRODUCT_PRICE BETWEEN ?1 AND ?2",nativeQuery=true)
	List<Product> findByPrice(Double maxPrice, Double minPrice);
	
}
