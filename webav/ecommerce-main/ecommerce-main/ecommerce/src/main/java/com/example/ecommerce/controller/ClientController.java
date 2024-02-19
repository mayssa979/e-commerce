package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.ecommerce.model.Client;
import com.example.ecommerce.repository.ClientRepository;

import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/clients")

public class ClientController {
	@Autowired
    private ClientRepository clientRepository;

    /*@GetMapping
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }*/

   /* @PostMapping
    public Client createUtilisateur(@RequestBody Client client) {
        return clientRepository.save(client);
    }*/
    
    @GetMapping("/")
	public List<Client> showClients(){
		return clientService.getClients();
	}
	
	@PostMapping("/addClient")
	public Client addClient(@RequestBody Client client) throws IOException{
		return clientService.addClient(client);
	}
	@GetMapping("/getClient/{id}")
	public Client findClient(@PathVariable long id) {
		return clientService.findClient(id);
	}
	
	@PutMapping("/updateClient")
	public Client updateClient(Client client) {
		return clientService.updateClient(client);
	}
	
	@DeleteMapping("/deleteClient/{id}")
	public void deleteClient(@PathVariable long id) {
		clientService.deleteClient(id);
	}

}