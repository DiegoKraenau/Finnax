package com.finnax.finnaxApp.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finnax.finnaxApp.entities.Operation;
import com.finnax.finnaxApp.entities.Product;
import com.finnax.finnaxApp.repository.IOperationRepository;
import com.finnax.finnaxApp.repository.IProductRepository;
import com.finnax.finnaxApp.services.IOperationService;
import com.finnax.finnaxApp.services.IProductService;

@Service
@Transactional(readOnly = true)
public class ProductService implements IProductService{

	
	@Autowired
	IProductRepository productRepository;

	@Override
	@Transactional
	public Product save(Product t) throws Exception {
		// TODO Auto-generated method stub
		return productRepository.save(t);
	}

	@Override
	public void deleteById(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Product> findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAll() throws Exception {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product findByIdOriginal(UUID id) throws Exception {
		// TODO Auto-generated method stub
		return productRepository.findByIdOriginal(id);
	}
	
	

}
