package com.data.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.ecommerce.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

//	Product saveDetails(Product product);

}
