package com.macelloendo.cursosts;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.macelloendo.cursosts.domain.Category;
import com.macelloendo.cursosts.domain.Product;
import com.macelloendo.cursosts.repository.CategoryRepository;
import com.macelloendo.cursosts.repository.ProductRepository;

@SpringBootApplication
public class CursostsApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursostsApplication.class, args);
		System.out.println("*****************STARTED*****************");
	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");

		Product p1 = new Product(null, "Desktop", 3500.00);
		Product p2 = new Product(null, "Teclado", 450.00);
		Product p3 = new Product(null, "Monitor", 1290.00);

		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));

		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat2));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));

	}

}
