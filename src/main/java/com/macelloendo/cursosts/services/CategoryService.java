package com.macelloendo.cursosts.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macelloendo.cursosts.domain.Category;
import com.macelloendo.cursosts.repository.CategoryRepository;
import com.macelloendo.cursosts.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;

	public Category search(Integer id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado ID: " + id + " Tipo: " + Category.class.getName()));
	}

}
