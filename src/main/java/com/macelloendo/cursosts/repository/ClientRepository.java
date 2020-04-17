package com.macelloendo.cursosts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macelloendo.cursosts.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
	
	

}
