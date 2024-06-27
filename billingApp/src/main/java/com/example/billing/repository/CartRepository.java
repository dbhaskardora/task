package com.example.billing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.billing.model.CartItem;

public interface CartRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findAll();
}
