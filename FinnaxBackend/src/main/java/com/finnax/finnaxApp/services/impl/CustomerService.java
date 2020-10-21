package com.finnax.finnaxApp.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finnax.finnaxApp.entities.Customer;
import com.finnax.finnaxApp.entities.Payment;
import com.finnax.finnaxApp.entities.Purchase;
import com.finnax.finnaxApp.repository.ICustomerRepository;
import com.finnax.finnaxApp.repository.IInterestRepository;
import com.finnax.finnaxApp.services.ICustomerService;
import com.finnax.finnaxApp.services.IInterestService;

@Service
@Transactional(readOnly = true)
public class CustomerService implements ICustomerService {
	
	@Autowired
	ICustomerRepository iCustomerRepository;

	@Override
	@Transactional
	public Customer save(Customer t) throws Exception {
		// TODO Auto-generated method stub
		return iCustomerRepository.save(t);
	}

	@Override
	public void deleteById(int id) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public Optional<Customer> findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findAll() throws Exception {
		// TODO Auto-generated method stub
		return iCustomerRepository.findAll();
	}

	@Override
	public Customer findByIdOriginal(UUID id) throws Exception {
		// TODO Auto-generated method stub
		return iCustomerRepository.findByIdOriginal(id);
	}

	@Override
	public List<Purchase> findPurchasesByCustomerId(UUID id) throws Exception {
		// TODO Auto-generated method stub
		return iCustomerRepository.findPurchasesByCustomerId(id);
	}

	@Override
	public List<Payment> findPaymentsByCustomerId(UUID id) throws Exception {
		// TODO Auto-generated method stub
		return iCustomerRepository.findPaymentsByCustomerId(id);
	}

}
