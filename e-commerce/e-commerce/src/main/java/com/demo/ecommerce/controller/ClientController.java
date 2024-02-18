package com.demo.ecommerce.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.demo.ecommerce.model.Client;
import com.demo.ecommerce.repository.ClientRepository;

import java.util.List;
@RestController
@RequestMapping("/clients")

public class ClientController {
	@Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @PostMapping
    public Client createUtilisateur(@RequestBody Client client) {
        return clientRepository.save(client);
    }

}
