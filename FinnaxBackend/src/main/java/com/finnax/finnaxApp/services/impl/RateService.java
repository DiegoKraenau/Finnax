package com.finnax.finnaxApp.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finnax.finnaxApp.entities.Rate;
import com.finnax.finnaxApp.repository.IInterestRepository;
import com.finnax.finnaxApp.repository.IRateRepository;
import com.finnax.finnaxApp.services.IInterestService;
import com.finnax.finnaxApp.services.IRateService;

@Service
@Transactional(readOnly = true)
public class RateService implements IRateService {

	@Autowired
	IRateRepository iRateRepository;
	
	
	@Override
	@Transactional
	public Rate save(Rate t) throws Exception {
		// TODO Auto-generated method stub
		return iRateRepository.save(t);
	}

	@Override
	public void deleteById(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Rate> findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return iRateRepository.findById(id);
	}

	@Override
	public List<Rate> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
