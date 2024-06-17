package com.data.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.ecommerce.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserEmail(String userEmail);
}
