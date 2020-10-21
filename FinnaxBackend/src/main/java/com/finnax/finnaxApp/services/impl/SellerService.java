package com.finnax.finnaxApp.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finnax.finnaxApp.entities.Customer;
import com.finnax.finnaxApp.entities.Seller;
import com.finnax.finnaxApp.repository.ISellerRepository;
import com.finnax.finnaxApp.services.ISellerService;

@Service
@Transactional(readOnly = true)
public class SellerService implements ISellerService{
	
	@Autowired
	ISellerRepository usuarioRepository;

	@Override
	@Transactional
	public Seller save(Seller t) throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.save(t);
	}

	@Override
	@Transactional
	public void deleteById(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Seller> findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seller> findAll() throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}
	
	@Override
	public Seller login(String email, String password) throws Exception {
		// TODO Auto-generated method stub
		List<Seller> listaUsuarios=usuarioRepository.findAll();
		Seller usuarioEncontrado=new Seller();
		int encontrado=0;
		for (Seller usuario : listaUsuarios) {
			if(usuario.getSellerEmail().equals(email)==true && usuario.getSellerPasword().equals(password)==true) {
				
				usuarioEncontrado=usuario;
				encontrado=1;
			}
		}
		
		
		if(encontrado==1) {
			
			return usuarioEncontrado;
			
		}else {
			
			return null;
		}
		
	}


	
	@Override
	public Seller findByIdOriginal(UUID uuid) throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.findByIdOriginal(uuid);
	}

	@Override
	public List<Customer> customersBySellerId(UUID id) throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.customersBySellerId(id);
	}

	
	

}
