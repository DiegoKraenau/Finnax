package com.finnax.finnaxApp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finnax.finnaxApp.controller.modelview.CustomerModelView;
import com.finnax.finnaxApp.controller.modelview.SellerModelView;
import com.finnax.finnaxApp.entities.Customer;
import com.finnax.finnaxApp.entities.Seller;
import com.finnax.finnaxApp.services.ISellerService;

@RestController
@RequestMapping("/api/sellers")
public class SellerController {
	
	@Autowired
	private ISellerService usuarioService;

	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> insertUsuario(@Validated @RequestBody Seller usuario){
		Map<String,Object> response=new HashMap<>();
		try {
			Seller usuarioNuevo = usuarioService.save(usuario);
			return new ResponseEntity<Seller>(usuarioNuevo,HttpStatus.OK);
		}catch(Exception e){
			response.put("mensaje", "Error al realizar la consulta");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@PostMapping(value="/login",consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> login(@Validated @RequestBody SellerModelView usuario){
		
		Map<String,Object> response=new HashMap<>(); 
		
		try {
			
			Seller usuarioNuevo = usuarioService.login(usuario.getEmail(), usuario.getPassword());
			if(usuarioNuevo==null) {
				response.put("mensaje", "Credenciales incorrectas o usuario inexistente");
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
			}else {
				usuario.setSellerId(usuarioNuevo.getSellerId());
				return new ResponseEntity<SellerModelView>(usuario,HttpStatus.OK);
			}
			
		}catch(Exception e){
			//System.out.println(email);
			response.put("mensaje", "Error al realizar la consulta");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Seller>> findAll(){
		try {
			List<Seller> listaUsuarios = usuarioService.findAll();
			return new ResponseEntity<List<Seller>>(listaUsuarios,HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<List<Seller>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@GetMapping(value="/{id}/customers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> customersBySellerId(@PathVariable("id") UUID id){
		
		Map<String,Object> response=new HashMap<>(); 
		
		try {
			List<Customer> listCustomers =usuarioService.customersBySellerId(id);
			
			List<CustomerModelView> newList=new ArrayList<CustomerModelView>();
			
			for (Customer customer : listCustomers) {
				CustomerModelView cmw=new CustomerModelView();
				cmw.setCustomerId(customer.getCustomerId());
				cmw.setCustomerName(customer.getCustomerName());
				cmw.setCustomerAmountInterest(customer.getCustomerAmountInterest());
				cmw.setCustomerPhone(customer.getCustomerPhone());
				cmw.setCustomerCreditLine(customer.getCustomerCreditLine());
				cmw.setCustomerCreditAvailable(customer.getCustomerCreditAvailable());
				cmw.setCustomerCreditUsed(customer.getCustomerCreditUsed());
				cmw.setCustomerTotalDebt(customer.getCustomerTotalDebt());
				cmw.setCustomerMaintenanceAmount(customer.getCustomerMaintenanceAmount());
				cmw.setCustomerMaintenanceDays(customer.getCustomerMaintenanceDays());
				cmw.setCustomerMinimunPaymentAmount(customer.getCustomerMinimunPaymentAmount());
				cmw.setCustomerStatus(customer.isCustomerStatus());	
				/*
				cmw.setRateId(customer.getRate().getRateId());
				cmw.setCapitalizationId(customer.getCapitalization().getCapitalizationId());
				cmw.setInterestId(customer.getInterest().getInterestId());
				*/
				newList.add(cmw);
				
			}
			
			
			return new ResponseEntity<List<CustomerModelView>>(newList, HttpStatus.OK);
		}catch(Exception e){
			response.put("mensaje", "Error al realizar la consulta");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
