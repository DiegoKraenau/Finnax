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

import com.finnax.finnaxApp.entities.Interest;
import com.finnax.finnaxApp.entities.Seller;
import com.finnax.finnaxApp.services.IInterestService;
import com.finnax.finnaxApp.services.ISellerService;

@RestController
@RequestMapping("/api/interest")
public class InterestController {
	
	@Autowired
	private IInterestService interestService;

	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> insertUsuario(@Validated @RequestBody Interest interest){
		Map<String,Object> response=new HashMap<>();
		try {
			Interest interestNew = interestService.save(interest);
			return new ResponseEntity<Interest>(interestNew,HttpStatus.OK);
		}catch(Exception e){
			response.put("mensaje", "Error al realizar la consulta");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
}
