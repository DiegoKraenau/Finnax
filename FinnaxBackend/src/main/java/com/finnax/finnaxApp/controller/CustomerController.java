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
import com.finnax.finnaxApp.controller.modelview.PaymentModelView;
import com.finnax.finnaxApp.controller.modelview.ProductModelView;
import com.finnax.finnaxApp.controller.modelview.PurchaseModelView;
import com.finnax.finnaxApp.controller.modelview.SellerCustomersModelView;
import com.finnax.finnaxApp.entities.Customer;
import com.finnax.finnaxApp.entities.Interest;
import com.finnax.finnaxApp.entities.Payment;
import com.finnax.finnaxApp.entities.Product;
import com.finnax.finnaxApp.entities.Purchase;
import com.finnax.finnaxApp.entities.Seller;
import com.finnax.finnaxApp.entities.SellerCustomers;
import com.finnax.finnaxApp.services.ICapitalizationService;
import com.finnax.finnaxApp.services.ICustomerService;
import com.finnax.finnaxApp.services.IInterestService;
import com.finnax.finnaxApp.services.IPaymentService;
import com.finnax.finnaxApp.services.IPurchaseService;
import com.finnax.finnaxApp.services.IRateService;
import com.finnax.finnaxApp.services.ISellerCustomersService;
import com.finnax.finnaxApp.services.ISellerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private ISellerService sellerService;
	
	@Autowired
	private ISellerCustomersService sellerCustomersService;
	
	@Autowired
	private IRateService rateService;
	
	@Autowired
	private ICapitalizationService capitalizationService;
	
	@Autowired
	private IInterestService interestService;
	
	
	@Autowired
	private IPurchaseService purchService;
	
	@Autowired
	private IPaymentService paymentService;
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> findAll(){
		try {
			List<Customer> customersList = customerService.findAll();
			return new ResponseEntity<List<Customer>>(customersList,HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<List<Customer>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> insertCustomer(@Validated @RequestBody CustomerModelView customer){
		Map<String,Object> response=new HashMap<>();
		try {
			Customer cmw = new Customer();
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
			
			if(customer.getRateId()==0) {
				cmw.setRate(null);
			}else {
				cmw.setRate(rateService.findById(customer.getRateId()).get());
			}
			
			if(customer.getCapitalizationId()==0) {
				cmw.setCapitalization(null);
			}else {
				cmw.setCapitalization(capitalizationService.findById(customer.getCapitalizationId()).get());
			}
			
			cmw.setInterest(interestService.findById(customer.getInterestId()).get());
			//cmw.setRate(rateService.findById(customer.getRateId()).get());
			
			cmw=customerService.save(cmw);
			/*
			customer.setCustomerId(cmw.getCustomerId());
			customer.setCapitalizationId(cmw.getCapitalization().getCapitalizationId());
			customer.setInterestId(cmw.getInterest().getInterestId());
			customer.setRateId(cmw.getRate().getRateId());
			*/
			
			Seller seller=sellerService.findByIdOriginal(customer.getSellerId());
			
			SellerCustomers link=new SellerCustomers();
			
			link.setCustomer(cmw);
			link.setSeller(seller);
			
			
			link=sellerCustomersService.save(link);
			
			SellerCustomersModelView newLink=new SellerCustomersModelView();
			newLink.setSellerCustomersId(link.getSellerCustomerId());
			newLink.setCustomerIdFk(link.getCustomer().getCustomerId());
			newLink.setSellerIdFk(link.getSeller().getSellerId());
			
			
			
			return new ResponseEntity<SellerCustomersModelView>(newLink,HttpStatus.OK);
		}catch(Exception e){
			response.put("mensaje", "Error al realizar la consulta");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	

	@GetMapping(value="/{id}/purchases", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findPurchasesByCustomerId(@PathVariable("id") UUID id){
		Map<String,Object> response=new HashMap<>();
		try {
			List<Purchase> purchaseList = customerService.findPurchasesByCustomerId(id);
			List<PurchaseModelView> newPurchaseList=new ArrayList<PurchaseModelView>();
			
			
			for (Purchase purchase : purchaseList) {
				PurchaseModelView pmw=new PurchaseModelView();
				List<ProductModelView> productList=new ArrayList<ProductModelView>();
				pmw.setPurchaseId(purchase.getPurchaseId());
				pmw.setPurchaseName(purchase.getPurchaseName());
				pmw.setPurchaseAmount(purchase.getPurchaseAmount());
				pmw.setDeliveryAmount(purchase.getDeliveryAmount());
				pmw.setPurchaseAmount(purchase.getPurchaseAmount());
				pmw.setOperationDate(purchase.getOperation().getOperationDate());
				pmw.setCustomerId(customerService.findByIdOriginal(id).getCustomerId());
				pmw.setOperationId(purchase.getOperation().getOperationId());
				
				for (Product product : purchase.getListProducts()) {
					ProductModelView p1=new ProductModelView();
					p1.setProductId(product.getProductId());
					p1.setProductDescription(product.getProductDescription());
					p1.setProductAmount(product.getProductAmount());
					productList.add(p1);
				}
				pmw.setListaProducts(productList);
				
				newPurchaseList.add(pmw);
			}
			
			return new ResponseEntity<List<PurchaseModelView>>(newPurchaseList,HttpStatus.OK);
		}catch(Exception e){
			response.put("mensaje", "Error al realizar la consulta");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping(value="/{id}/payments",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PaymentModelView>> findPayments(@PathVariable("id") UUID id){
		try {
			List<Payment> paymentList = customerService.findPaymentsByCustomerId(id);
			List<PaymentModelView> newPaymentList=new ArrayList<PaymentModelView>();
			
			for (Payment payment : paymentList) {
				PaymentModelView p1=new PaymentModelView();
				p1.setPaymentId(payment.getPaymentId());
				p1.setPaymentAmount(payment.getPaymentAmount());
				p1.setPaymentName(payment.getPaymentName());
				p1.setCustomerId(payment.getOperation().getCustomer().getCustomerId());
				p1.setOperationId(payment.getOperation().getOperationId());
				p1.setOperationDate(payment.getOperation().getOperationDate());
				
				newPaymentList.add(p1);
			}
			
			
			
			return new ResponseEntity<List<PaymentModelView>>(newPaymentList,HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<List<PaymentModelView>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findById(@PathVariable("id") UUID id){
		try {
			Customer customer=customerService.findByIdOriginal(id);
			CustomerModelView customermv= new CustomerModelView();
			customermv.setCustomerId(customer.getCustomerId());
			customermv.setCustomerCreditAvailable(customer.getCustomerCreditAvailable());
			customermv.setCustomerCreditUsed(customer.getCustomerCreditUsed());
			customermv.setCustomerCreditLine(customer.getCustomerCreditLine());
			customermv.setCustomerTotalDebt(customer.getCustomerTotalDebt());
		

			return new ResponseEntity<CustomerModelView>(customermv,HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<List<PaymentModelView>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
