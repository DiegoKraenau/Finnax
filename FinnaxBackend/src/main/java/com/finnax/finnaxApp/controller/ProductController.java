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

import com.finnax.finnaxApp.controller.modelview.ProductModelView;
import com.finnax.finnaxApp.controller.modelview.PurchaseModelView;
import com.finnax.finnaxApp.entities.Customer;
import com.finnax.finnaxApp.entities.Operation;
import com.finnax.finnaxApp.entities.Product;
import com.finnax.finnaxApp.entities.Purchase;
import com.finnax.finnaxApp.services.ICustomerService;
import com.finnax.finnaxApp.services.IProductService;
import com.finnax.finnaxApp.services.IPurchaseService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	

	@Autowired
	private IProductService productService;
	
	@Autowired
	private IPurchaseService purchaseService;
	
	@Autowired
	private ICustomerService customerService;
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> insertPurchase(@Validated @RequestBody ProductModelView productModelView){
		Map<String,Object> response=new HashMap<>();
		try {
			Product product=new Product();
			product.setProductAmount(productModelView.getProductAmount());
			product.setProductDescription(productModelView.getProductDescription());
			product.setPurchase(purchaseService.findByIdOriginal(productModelView.getPurchaseId()));
			
			product=productService.save(product);
			
			productModelView.setProductId(product.getProductId());
			/*Actualizamos Purchase*/
			Purchase purchase=purchaseService.findByIdOriginal(productModelView.getPurchaseId());
			purchase.setPurchaseProductsAmount(purchase.getPurchaseProductsAmount()+product.getProductAmount());
			purchase.setPurchaseAmount(purchase.getDeliveryAmount()+purchase.getPurchaseProductsAmount());
			purchase=purchaseService.save(purchase);
			
			/*Actualizamos Customer*/
			Customer customer=customerService.findByIdOriginal(purchase.getOperation().getCustomer().getCustomerId());
			customer.setCustomerCreditUsed(customer.getCustomerCreditUsed()+product.getProductAmount());
			customer.setCustomerCreditAvailable(customer.getCustomerCreditLine()-customer.getCustomerCreditUsed());
			customer.setCustomerTotalDebt(customer.getCustomerTotalDebt()+productModelView.getProductAmount());
			customer=customerService.save(customer);
			
		
			

			return new ResponseEntity<ProductModelView>(productModelView,HttpStatus.OK);
		}catch(Exception e){
			response.put("mensaje", "Error al realizar la consulta");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	

}
