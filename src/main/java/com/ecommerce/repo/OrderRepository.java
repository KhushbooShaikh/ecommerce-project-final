package com.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.pojo.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
