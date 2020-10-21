package com.finnax.finnaxApp.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finnax.finnaxApp.entities.Operation;
import com.finnax.finnaxApp.repository.IOperationRepository;
import com.finnax.finnaxApp.repository.IPurchaseRepository;
import com.finnax.finnaxApp.services.IInterestService;
import com.finnax.finnaxApp.services.IOperationService;

@Service
@Transactional(readOnly = true)
public class OperationService implements IOperationService{
	
	@Autowired
	IOperationRepository operationRepository;

	@Override
	@Transactional
	public Operation save(Operation t) throws Exception {
		// TODO Auto-generated method stub
		return operationRepository.save(t);
	}

	@Override
	public void deleteById(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Operation> findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Operation> findAll() throws Exception {
		// TODO Auto-generated method stub
		return operationRepository.findAll();
	}

	@Override
	public Operation findByIdOriginal(UUID id) throws Exception {
		// TODO Auto-generated method stub
		return operationRepository.findByIdOriginal(id);
	}

	@Override
	@Transactional
	public void updateFirtsOperation(UUID id) throws Exception {
		operationRepository.updateFirtsOperation(id);
		
	}

	@Override
	@Transactional
	public void updateLastPayment(UUID id) throws Exception {
		// TODO Auto-generated method stub
		operationRepository.updateLastPayment(id);
	}

}
