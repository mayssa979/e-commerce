package com.demo.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.ecommerce.model.Client;

public interface ClientRepository extends JpaRepository<Client,Long>{
	

}
