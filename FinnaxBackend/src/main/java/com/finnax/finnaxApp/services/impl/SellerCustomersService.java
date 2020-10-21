package com.finnax.finnaxApp.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finnax.finnaxApp.entities.SellerCustomers;
import com.finnax.finnaxApp.repository.IInterestRepository;
import com.finnax.finnaxApp.repository.ISellerCustomersRepository;
import com.finnax.finnaxApp.services.IInterestService;
import com.finnax.finnaxApp.services.ISellerCustomersService;

@Service
@Transactional(readOnly = true)
public class SellerCustomersService implements ISellerCustomersService{

	@Autowired
	ISellerCustomersRepository iSellerCustomersRepository;
	
	@Override
	@Transactional
	public SellerCustomers save(SellerCustomers t) throws Exception {
		// TODO Auto-generated method stub
		return iSellerCustomersRepository.save(t);
	}

	@Override
	public void deleteById(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<SellerCustomers> findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SellerCustomers> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
