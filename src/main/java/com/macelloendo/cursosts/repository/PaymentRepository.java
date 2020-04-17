package com.macelloendo.cursosts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macelloendo.cursosts.domain.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	
	

}
