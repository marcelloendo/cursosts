package com.macelloendo.cursosts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macelloendo.cursosts.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
	
	

}
