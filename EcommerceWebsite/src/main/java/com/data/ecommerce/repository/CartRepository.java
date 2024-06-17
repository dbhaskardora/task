package com.data.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.ecommerce.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	 List<Cart> findByUserId(int userId);
}
