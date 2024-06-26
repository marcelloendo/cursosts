package com.macelloendo.cursosts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macelloendo.cursosts.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	

}
