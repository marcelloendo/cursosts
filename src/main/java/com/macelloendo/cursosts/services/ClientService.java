package com.macelloendo.cursosts.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macelloendo.cursosts.domain.Client;
import com.macelloendo.cursosts.repository.ClientRepository;
import com.macelloendo.cursosts.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repo;

	public Client search(Integer id) {
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado ID: " + id + " Tipo: " + Client.class.getName()));
	}

}
