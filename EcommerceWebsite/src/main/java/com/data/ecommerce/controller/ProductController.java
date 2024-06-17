package com.data.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.ecommerce.entity.Product;
import com.data.ecommerce.repository.ProductRepository;
//import com.telecom.data.entity.Customer;

@RestController
@CrossOrigin
	@RequestMapping("/products")
	public class ProductController {
	    @Autowired
	    private ProductRepository productRepository;

	    @GetMapping
	    public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }
//	    @PostMapping("/addProducts")
//		public Product postDetails(@RequestBody Product product)
//		{
//			return productRepository.saveDetails(product);
//		}
	    @GetMapping("/{id}")
	    public ResponseEntity<Product> getProductById(@PathVariable int id) {
	        return productRepository.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	    }
	}
