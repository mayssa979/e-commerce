package com.example.ecommerce.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.Client;
import com.example.ecommerce.repository.ClientRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Optional<Client> findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }
    public Client saveUser(Client client) {
        return clientRepository.save(client);
    }
    
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