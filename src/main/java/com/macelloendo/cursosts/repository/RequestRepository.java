package com.macelloendo.cursosts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macelloendo.cursosts.domain.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {
	
	

}
