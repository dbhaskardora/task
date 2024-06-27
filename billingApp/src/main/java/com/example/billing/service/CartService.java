package com.example.billing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.billing.model.CartItem;
import com.example.billing.model.Product;
import com.example.billing.repository.CartRepository;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductService productService;

    public void addToCart(Long productId, Integer quantity) {
        CartItem cartItem = new CartItem();
        cartItem.setProductId(productId);
        cartItem.setQuantity(quantity);
        cartRepository.save(cartItem);
    }

    public List<CartItem> getCartItems() {
        return cartRepository.findAll();
    }

    public Double getTotalAmount() {
        List<CartItem> cartItems = cartRepository.findAll();
        double total = 0;
        for (CartItem item : cartItems) {
            Optional<Product> product = productService.getProductById(item.getProductId());
            if (product.isPresent()) {
                total += product.get().getPrice() * item.getQuantity();
            }
        }
        return total;
    }

    public void clearCart() {
        cartRepository.deleteAll();
    }
}