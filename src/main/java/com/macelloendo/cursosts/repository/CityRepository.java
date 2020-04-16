package com.macelloendo.cursosts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macelloendo.cursosts.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
	
	

}
