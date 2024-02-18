package com.demo.ecommerce.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ecommerce.model.Client;
import com.demo.ecommerce.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	
	@GetMapping("/")
	public List<Client> showClients(){
		return clientService.getClients();
	}
	
	@PostMapping("/addClient")
	public Client addClient(Client client) throws IOException{
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
