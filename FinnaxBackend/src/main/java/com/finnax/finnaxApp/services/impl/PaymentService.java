package com.finnax.finnaxApp.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finnax.finnaxApp.entities.Payment;
import com.finnax.finnaxApp.repository.IOperationRepository;
import com.finnax.finnaxApp.repository.IPaymentRepository;
import com.finnax.finnaxApp.services.IOperationService;
import com.finnax.finnaxApp.services.IPaymentService;

@Service
@Transactional(readOnly = true)
public class PaymentService implements IPaymentService{
	
	
	@Autowired
	IPaymentRepository paymentRepository;

	@Override
	@Transactional
	public Payment save(Payment t) throws Exception {
		// TODO Auto-generated method stub
		return paymentRepository.save(t);
	}

	@Override
	public void deleteById(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Payment> findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> findAll() throws Exception {
		// TODO Auto-generated method stub
		return paymentRepository.findAll();
	}

}
