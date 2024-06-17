package com.data.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.ecommerce.entity.Cart;
import com.data.ecommerce.repository.CartRepository;

@RestController
	@RequestMapping("/cart")
	public class CartController {
	    @Autowired
	    private CartRepository cartRepository;

	    @PostMapping("/add")
	    public ResponseEntity<String> addToCart(@RequestBody Cart cart) {
	        cartRepository.save(cart);
	        return ResponseEntity.ok("Product added to cart");
	    }

	    @GetMapping("/{userId}")
	    public List<Cart> getCartItems(@PathVariable int userId) {
	        return cartRepository.findByUserId(userId);
	    }

	    @DeleteMapping("/{cartId}")
	    public ResponseEntity<String> removeFromCart(@PathVariable int cartId) {
	        cartRepository.deleteById(cartId);
	        return ResponseEntity.ok("Product removed from cart");
	    }

	    @PostMapping("/checkout")
	    public ResponseEntity<String> checkout(@RequestBody int userId) {
	        cartRepository.deleteAll(cartRepository.findByUserId(userId));
	        return ResponseEntity.ok("Checkout successful");
	    }
}