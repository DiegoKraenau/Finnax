package com.finnax.finnaxApp.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.finnax.finnaxApp.entities.Customer;
import com.finnax.finnaxApp.entities.Interest;
import com.finnax.finnaxApp.entities.Payment;
import com.finnax.finnaxApp.entities.Purchase;
import com.finnax.finnaxApp.entities.Seller;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, UUID>{

	@Query("select u from Customer u where u.customerId= ?1")
	Customer findByIdOriginal(UUID id)throws Exception;
	
	@Query("select u from Purchase u where u.operation.customer.customerId= ?1")
	List<Purchase> findPurchasesByCustomerId(UUID id)throws Exception;
	
	@Query("select u from Payment u where u.operation.customer.customerId= ?1")
	List<Payment> findPaymentsByCustomerId(UUID id)throws Exception;
}
