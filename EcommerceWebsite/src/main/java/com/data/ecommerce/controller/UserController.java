package com.data.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.ecommerce.entity.User;
import com.data.ecommerce.repository.UserRepository;

@RestController
	@RequestMapping("/users")
	public class UserController {
	    @Autowired
	    private UserRepository userRepository;

	    @PostMapping("/register")
	    public ResponseEntity<String> register(@RequestBody User user) {
	        if (userRepository.findByUserEmail(user.getUserEmail()) != null) {
	            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
	        }
	        userRepository.save(user);
	        return ResponseEntity.status(HttpStatus.CREATED).body("User registered");
	    }

	    @PostMapping("/login")
	    public ResponseEntity<String> login(@RequestBody User user) {
	        User existingUser = userRepository.findByUserEmail(user.getUserEmail());
	        if (existingUser != null && existingUser.getUserPassword().equals(user.getUserPassword())) {
	            return ResponseEntity.ok("Login successfully");
	        }
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	    }
}