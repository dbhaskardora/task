package com.example.billing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.billing.service.CartService;
import com.example.billing.service.ProductService;

@Controller
public class ShoppingController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @GetMapping("/")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @PostMapping("/addToCart")
    public String addToCart(@RequestParam Long productId, @RequestParam Integer quantity) {
        cartService.addToCart(productId, quantity);
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("totalAmount", cartService.getTotalAmount());
        return "cart";
    }

    @GetMapping("/chekout")
    public String checkout(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("totalAmount", cartService.getTotalAmount());
        model.addAttribute("deliveryAddress", "Customer Delivery Address");
        model.addAttribute("sellerAddress", "Seller Address");
        return "chekout";
    }

    @PostMapping("/purchase")
    public String purchase(Model model) {
        model.addAttribute("message", "Purchase successful!");
        model.addAttribute("totalAmount", cartService.getTotalAmount());
        cartService.clearCart();
        return "confirmation";
    }
}