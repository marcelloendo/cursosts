package com.macelloendo.cursosts;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.macelloendo.cursosts.domain.Address;
import com.macelloendo.cursosts.domain.BankslipPayment;
import com.macelloendo.cursosts.domain.CardPayment;
import com.macelloendo.cursosts.domain.Category;
import com.macelloendo.cursosts.domain.City;
import com.macelloendo.cursosts.domain.Client;
import com.macelloendo.cursosts.domain.Payment;
import com.macelloendo.cursosts.domain.Product;
import com.macelloendo.cursosts.domain.Request;
import com.macelloendo.cursosts.domain.State;
import com.macelloendo.cursosts.domain.enums.ClientType;
import com.macelloendo.cursosts.domain.enums.PaymentStatus;
import com.macelloendo.cursosts.repository.AddressRepository;
import com.macelloendo.cursosts.repository.CategoryRepository;
import com.macelloendo.cursosts.repository.CityRepository;
import com.macelloendo.cursosts.repository.ClientRepository;
import com.macelloendo.cursosts.repository.PaymentRepository;
import com.macelloendo.cursosts.repository.ProductRepository;
import com.macelloendo.cursosts.repository.RequestRepository;
import com.macelloendo.cursosts.repository.StateRepository;

@SpringBootApplication
public class CursostsApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private RequestRepository requestRepository;
	@Autowired
	private PaymentRepository paymentRepository;

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

		State st1 = new State(null, "Paraná");
		State st2 = new State(null, "São Paulo");

		City c1 = new City(null, "Marialva", st1);
		City c2 = new City(null, "São Paulo", st2);
		City c3 = new City(null, "Osasco", st2);

		st1.getCities().addAll(Arrays.asList(c1));
		st2.getCities().addAll(Arrays.asList(c2, c3));

		stateRepository.saveAll(Arrays.asList(st1, st2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));

		Client cli1 = new Client(null, "Maria Endo", "maria@endo.jp", "01234567890", ClientType.PESSOA_FISICA);

		cli1.getPhonenumbers().addAll(Arrays.asList("4432320000", "44999999999"));

		Address a1 = new Address(null, "Avenida Eurico", "123", "Casa Azul", "Centro", "86990000", cli1, c1);
		Address a2 = new Address(null, "Avenida Paulista", "456", "Casa Verde", "Jardim Paulista", "70050250", cli1,
				c2);

		cli1.getAddress().addAll(Arrays.asList(a1, a2));

		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(a1, a2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Request req1 = new Request(null, sdf.parse("30/05/2020 10:30"), cli1, a1);
		Request req2 = new Request(null, sdf.parse("01/06/2020 00:00"), cli1, a2);

		Payment payment1 = new CardPayment(null, PaymentStatus.PAID, req1, 6);
		req1.setPayment(payment1);
		Payment payment2 = new BankslipPayment(null, PaymentStatus.PENDING, req2, sdf.parse("07/06/2020 00:00"), null);
		req2.setPayment(payment2);

		cli1.getRequests().addAll(Arrays.asList(req1, req2));
		
		requestRepository.saveAll(Arrays.asList(req1, req2));
		paymentRepository.saveAll(Arrays.asList(payment1, payment2));
		
		

	}

}
