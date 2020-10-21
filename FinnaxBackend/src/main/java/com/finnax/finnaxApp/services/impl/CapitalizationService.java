package com.finnax.finnaxApp.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finnax.finnaxApp.entities.Capitalization;
import com.finnax.finnaxApp.repository.ICapitalizationRepository;
import com.finnax.finnaxApp.repository.ICustomerRepository;
import com.finnax.finnaxApp.services.ICapitalizationService;
import com.finnax.finnaxApp.services.IInterestService;

@Service
@Transactional(readOnly = true)
public class CapitalizationService implements ICapitalizationService{

	
	@Autowired
	ICapitalizationRepository iCapitalizationRepository;
	
	@Override
	@Transactional
	public Capitalization save(Capitalization t) throws Exception {
		// TODO Auto-generated method stub
		return iCapitalizationRepository.save(t);
	}

	@Override
	public void deleteById(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Capitalization> findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return iCapitalizationRepository.findById(id);
	}

	@Override
	public List<Capitalization> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
