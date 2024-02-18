package com.demo.ecommerce.controller;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ecommerce.model.Client;
import com.demo.ecommerce.service.ClientService;

@RestController
@RequestMapping("/api")

public class RegisterController {
	@Autowired
    private ClientService clientService;
	@PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Client newClient) {
       
        if (clientService.findByEmail(newClient.getEmail()).isPresent())
        {
            return new ResponseEntity<>("email is already in use", HttpStatus.BAD_REQUEST);
        }

        // Save the new user
        clientService.saveUser(newClient);

        return new ResponseEntity<>("Registration successful", HttpStatus.CREATED);
    }

}
