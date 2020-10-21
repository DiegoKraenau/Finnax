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
import com.finnax.finnaxApp.controller.modelview.ProductModelView;
import com.finnax.finnaxApp.controller.modelview.PurchaseModelView;
import com.finnax.finnaxApp.entities.Customer;
import com.finnax.finnaxApp.entities.Operation;
import com.finnax.finnaxApp.entities.Product;
import com.finnax.finnaxApp.entities.Purchase;
import com.finnax.finnaxApp.entities.Seller;
import com.finnax.finnaxApp.services.ICustomerService;
import com.finnax.finnaxApp.services.IOperationService;
import com.finnax.finnaxApp.services.IProductService;
import com.finnax.finnaxApp.services.IPurchaseService;
import com.finnax.finnaxApp.services.ISellerService;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {
	
	@Autowired
	private IPurchaseService purchaseService;
	
	@Autowired
	private IOperationService operationService;
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private ICustomerService customerService;

	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> insertPurchase(@Validated @RequestBody PurchaseModelView purchaseModelView){
		Map<String,Object> response=new HashMap<>();
		try {
			Operation operation=new Operation();
			Purchase purchase=new Purchase();
			Product product=new Product();
			
			/*Operation*/
			operation.setOperationDate(purchaseModelView.getOperationDate());
			operation.setCustomer(customerService.findByIdOriginal(purchaseModelView.getCustomerId()));
			operation.setFirtsOperation(false);
			
			
			
			operation=operationService.save(operation);
			
			/*Purchase*/
			purchase.setDeliveryAmount(0);
			purchase.setPurchaseAmount(0);
			purchase.setPurchaseProductsAmount(0);
			purchase.setPurchaseName(purchaseModelView.getPurchaseName());
			purchase.setOperation(operationService.findByIdOriginal(operation.getOperationId()));
			purchase=purchaseService.save(purchase);
			
			/*Product*/
			product.setProductDescription(purchaseModelView.getPurchaseProductsName());
			product.setProductAmount(purchaseModelView.getPurchaseProductsAmount());
			product.setPurchase(purchase);
			product=productService.save(product);
			
			
			/*Actualizamos purchase y CreditLineUsed*/
			purchase.setPurchaseProductsAmount(purchase.getPurchaseProductsAmount()+product.getProductAmount());
			purchase.setPurchaseAmount(purchase.getDeliveryAmount()+purchase.getPurchaseProductsAmount());
			purchase=purchaseService.save(purchase);
			
			Customer customer=new Customer();
			customer=customerService.findByIdOriginal(purchase.getOperation().getCustomer().getCustomerId());
			
			if(customer.getCustomerTotalDebt()==0) {
				operationService.updateFirtsOperation(customer.getCustomerId());
				operation.setFirtsOperation(true);
				operationService.updateLastPayment(customer.getCustomerId());
				operation.setLastPayment(true);
				operation=operationService.save(operation);
			}
			
			customer.setCustomerCreditUsed(customer.getCustomerCreditUsed()+purchase.getPurchaseAmount());
			customer.setCustomerCreditAvailable(customer.getCustomerCreditLine()-customer.getCustomerCreditUsed());
			customer.setCustomerTotalDebt(customer.getCustomerTotalDebt()+product.getProductAmount());
			customer=customerService.save(customer);
			
			
			
			purchaseModelView.setOperationId(operation.getOperationId());
			purchaseModelView.setPurchaseId(purchase.getPurchaseId());
			

			return new ResponseEntity<PurchaseModelView>(purchaseModelView,HttpStatus.OK);
		}catch(Exception e){
			response.put("mensaje", "Error al realizar la consulta");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	
	@PostMapping(value="/delivery",consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> insertDelivery(@Validated @RequestBody PurchaseModelView purchaseModelView){
		Map<String,Object> response=new HashMap<>();
		try {
			Purchase purchase=new Purchase();
			purchase=purchaseService.findByIdOriginal(purchaseModelView.getPurchaseId());			
			purchase.setDeliveryAmount(purchaseModelView.getDeliveryAmount());
			purchase.setPurchaseAmount(purchase.getDeliveryAmount()+purchase.getPurchaseProductsAmount());
			purchase=purchaseService.save(purchase);
			
			/*Actualizamos customer*/
			Customer customer=new Customer();
			customer=purchase.getOperation().getCustomer();
			
			customer.setCustomerCreditUsed(customer.getCustomerCreditUsed()+purchase.getDeliveryAmount());
			customer.setCustomerCreditAvailable(customer.getCustomerCreditLine()-customer.getCustomerCreditUsed());
			customer.setCustomerTotalDebt(customer.getCustomerTotalDebt()+purchase.getDeliveryAmount());
			customer=customerService.save(customer);
			
			
			purchaseModelView.setDeliveryAmount(purchase.getDeliveryAmount());
			

			return new ResponseEntity<PurchaseModelView>(purchaseModelView,HttpStatus.OK);
		}catch(Exception e){
			response.put("mensaje", "Error al realizar la consulta");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@GetMapping(value="/{id}/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findProductsByPurchaseId(@PathVariable("id") UUID id){
		
		Map<String,Object> response=new HashMap<>(); 
		
		try {
			Purchase purchase=purchaseService.findByIdOriginal(id);
			PurchaseModelView pmw=new PurchaseModelView();
			pmw.setPurchaseId(purchase.getPurchaseId());
			pmw.setDeliveryAmount(purchase.getDeliveryAmount());
			pmw.setPurchaseName(purchase.getPurchaseName());
			pmw.setPurchaseProductsAmount(purchase.getPurchaseProductsAmount());
			
			
			List<Product> listProducts=purchase.getListProducts();
			List<ProductModelView> listNewProducts=new ArrayList<ProductModelView>();
			
			for (Product product : listProducts) {
				ProductModelView p1=new ProductModelView();
				p1.setProductId(product.getProductId());
				p1.setProductDescription(product.getProductDescription());
				p1.setProductAmount(product.getProductAmount());
				
				listNewProducts.add(p1);
			}
			
			pmw.setListaProducts(listNewProducts);
			
			
	
			
			return new ResponseEntity<PurchaseModelView>(pmw, HttpStatus.OK);
		}catch(Exception e){
			response.put("mensaje", "Error al realizar la consulta");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	

}
