package com.finnax.finnaxApp.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finnax.finnaxApp.entities.Interest;
import com.finnax.finnaxApp.repository.IInterestRepository;
import com.finnax.finnaxApp.repository.ISellerRepository;
import com.finnax.finnaxApp.services.IInterestService;
import com.finnax.finnaxApp.services.ISellerService;

@Service
@Transactional(readOnly = true)
public class InterestService implements IInterestService{

	@Autowired
	IInterestRepository iInterestRepository;
	
	@Override
	@Transactional
	public Interest save(Interest t) throws Exception {
		// TODO Auto-generated method stub
		return iInterestRepository.save(t);
	}

	@Override
	public void deleteById(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Interest> findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return iInterestRepository.findById(id);
	}

	@Override
	public List<Interest> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
