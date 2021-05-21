package com.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.pojo.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
