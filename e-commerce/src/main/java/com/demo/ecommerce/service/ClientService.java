package com.demo.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.ecommerce.model.Client;
import com.demo.ecommerce.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> getClients(){
		return clientRepository.findAll();
	}
	
	public Client addClient(Client client) {
		return clientRepository.save(client);
	}
	
	public Client findClient(long id) {
		return clientRepository.findById(id).orElse(null);
	}
	
	public void deleteClient(long id) {
		clientRepository.deleteById(id);
	}
	
	public Client updateClient(Client client) {
		Client existClient = clientRepository.findById(client.getId()).orElse(null);
		existClient.setAdresse(client.getAdresse());
		existClient.setEmail(client.getEmail());
		existClient.setMotdepasse(client.getMotdepasse());
		existClient.setNom(client.getNom());
		existClient.setPrenom(client.getPrenom());
		existClient.setTelephone(client.getTelephone());
		return clientRepository.save(existClient);
	}

}
