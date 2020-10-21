package com.finnax.finnaxApp.services;

import java.util.List;
import java.util.UUID;

import com.finnax.finnaxApp.entities.Customer;
import com.finnax.finnaxApp.entities.Interest;
import com.finnax.finnaxApp.entities.Payment;
import com.finnax.finnaxApp.entities.Purchase;

public interface ICustomerService extends CrudService<Customer>{
	
	Customer findByIdOriginal(UUID id)throws Exception;
	
	List<Purchase> findPurchasesByCustomerId(UUID id)throws Exception;
	
	List<Payment> findPaymentsByCustomerId(UUID id)throws Exception;
}
