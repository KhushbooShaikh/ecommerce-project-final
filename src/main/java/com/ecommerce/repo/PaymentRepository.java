package com.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.pojo.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
