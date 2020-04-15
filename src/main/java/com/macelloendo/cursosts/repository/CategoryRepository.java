package com.macelloendo.cursosts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macelloendo.cursosts.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	

}
