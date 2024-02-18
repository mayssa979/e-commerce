package com.demo.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.ecommerce.model.Client;
import com.demo.ecommerce.repository.ClientRepository;

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
}