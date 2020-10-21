package com.finnax.finnaxApp.services;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.finnax.finnaxApp.entities.Customer;
import com.finnax.finnaxApp.entities.Seller;

public interface ISellerService extends CrudService<Seller>{

	Seller login(String email,String password) throws Exception;
	
	
	Seller findByIdOriginal(UUID uuid)throws Exception;
	
	List<Customer> customersBySellerId(UUID id)throws Exception;
}
