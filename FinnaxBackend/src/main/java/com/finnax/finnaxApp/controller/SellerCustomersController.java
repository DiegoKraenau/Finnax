package com.finnax.finnaxApp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finnax.finnaxApp.controller.modelview.SellerCustomersModelView;
import com.finnax.finnaxApp.entities.Customer;
import com.finnax.finnaxApp.entities.Seller;
import com.finnax.finnaxApp.entities.SellerCustomers;
import com.finnax.finnaxApp.services.ICustomerService;
import com.finnax.finnaxApp.services.ISellerCustomersService;
import com.finnax.finnaxApp.services.ISellerService;

@RestController
@RequestMapping("/api/sellercustomers")
public class SellerCustomersController {

	@Autowired
	private ISellerCustomersService sellerCustomersService;
	
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private ISellerService sellerService;

	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> insertLink(@Validated @RequestBody SellerCustomersModelView sellerCustomerModelView){
		Map<String,Object> response=new HashMap<>();
		try {
			Seller seller=sellerService.findByIdOriginal(sellerCustomerModelView.getSellerIdFk());
			Customer customer=customerService.findByIdOriginal(sellerCustomerModelView.getCustomerIdFk());
			
			SellerCustomers newLink = new SellerCustomers();
			
			newLink.setSeller(seller);
			newLink.setCustomer(customer);
			
			newLink=sellerCustomersService.save(newLink);
			
			sellerCustomerModelView.setSellerCustomersId(newLink.getSellerCustomerId());

			return new ResponseEntity<SellerCustomersModelView>(sellerCustomerModelView,HttpStatus.OK);
		}catch(Exception e){
			response.put("mensaje", "Error al realizar la consulta");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
}
