package com.finnax.finnaxApp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finnax.finnaxApp.controller.modelview.PaymentModelView;
import com.finnax.finnaxApp.controller.modelview.ProductModelView;
import com.finnax.finnaxApp.entities.Customer;
import com.finnax.finnaxApp.entities.Operation;
import com.finnax.finnaxApp.entities.Payment;
import com.finnax.finnaxApp.entities.Product;
import com.finnax.finnaxApp.entities.Purchase;
import com.finnax.finnaxApp.services.ICustomerService;
import com.finnax.finnaxApp.services.IOperationService;
import com.finnax.finnaxApp.services.IPaymentService;
import com.finnax.finnaxApp.services.IProductService;
import com.finnax.finnaxApp.services.IPurchaseService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

	@Autowired
	private IProductService productService;
	
	@Autowired
	private IPurchaseService purchaseService;
	
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private IOperationService operationService;
	
	@Autowired
	private IPaymentService paymentService;
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> insertPayment(@Validated @RequestBody PaymentModelView paymenModelView){
		Map<String,Object> response=new HashMap<>();
		try {
			
			Operation operation=new Operation();
			operation.setOperationDate(paymenModelView.getOperationDate());
			operation.setCustomer(customerService.findByIdOriginal(paymenModelView.getCustomerId()));
			/*Si llega a pagar todo*/
			Customer customer=customerService.findByIdOriginal(paymenModelView.getCustomerId());
			if(customer.getCustomerTotalDebt()==paymenModelView.getPaymentAmount()){
				operationService.updateFirtsOperation(paymenModelView.getCustomerId());
				operation.setFirtsOperation(true);
				operationService.updateLastPayment(paymenModelView.getCustomerId());
				operation.setLastPayment(true);
			}else {
				operation.setFirtsOperation(false);
				operationService.updateLastPayment(paymenModelView.getCustomerId());
				operation.setLastPayment(true);
			}
			
			
			operation=operationService.save(operation);
			
			Payment payment=new Payment();
			payment.setPaymentAmount(paymenModelView.getPaymentAmount());
			payment.setPaymentName(paymenModelView.getPaymentName());
			payment.setOperation(operation);
			payment=paymentService.save(payment);
			
			/*Actualizar Customer*/
			if(customer.getCustomerTotalDebt()==paymenModelView.getPaymentAmount()){
				customer.setCustomerCreditUsed(0);
				customer.setCustomerCreditAvailable(customer.getCustomerCreditLine());
				customer.setCustomerMinimunPaymentAmount(0);
				
			}else {
				customer.setCustomerCreditUsed(customer.getCustomerTotalDebt()-paymenModelView.getPaymentAmount());
				customer.setCustomerCreditAvailable(customer.getCustomerCreditLine()-customer.getCustomerCreditUsed());
			}
			

			customer.setCustomerTotalDebt(customer.getCustomerTotalDebt()-paymenModelView.getPaymentAmount());
			customer=customerService.save(customer);
			
			paymenModelView.setPaymentId(payment.getPaymentId());
			
			

			return new ResponseEntity<PaymentModelView>(paymenModelView,HttpStatus.OK);
		}catch(Exception e){
			response.put("mensaje", "Error al realizar la consulta");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	
	
}
