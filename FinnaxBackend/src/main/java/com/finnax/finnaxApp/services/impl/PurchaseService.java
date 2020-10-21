package com.finnax.finnaxApp.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finnax.finnaxApp.entities.Product;
import com.finnax.finnaxApp.entities.Purchase;
import com.finnax.finnaxApp.repository.IInterestRepository;
import com.finnax.finnaxApp.repository.IPurchaseRepository;
import com.finnax.finnaxApp.services.IInterestService;
import com.finnax.finnaxApp.services.IPurchaseService;


@Service
@Transactional(readOnly = true)
public class PurchaseService implements IPurchaseService {
	
	@Autowired
	IPurchaseRepository purchaseRepository;

	@Override
	@Transactional
	public Purchase save(Purchase t) throws Exception {
		// TODO Auto-generated method stub
		return purchaseRepository.save(t);
	}

	@Override
	public void deleteById(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Purchase> findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Purchase> findAll() throws Exception {
		// TODO Auto-generated method stub
		return purchaseRepository.findAll();
	}

	@Override
	public Purchase findByIdOriginal(UUID id) throws Exception {
		// TODO Auto-generated method stub
		return purchaseRepository.findByIdOriginal(id);
	}

}
