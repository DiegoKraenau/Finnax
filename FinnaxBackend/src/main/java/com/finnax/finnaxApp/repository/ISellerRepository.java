package com.finnax.finnaxApp.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.finnax.finnaxApp.entities.Customer;
import com.finnax.finnaxApp.entities.Seller;

@Repository
public interface ISellerRepository extends JpaRepository<Seller, UUID>{

	@Query("select u from Seller u where u.sellerId= ?1")
	Seller findByIdOriginal(UUID id)throws Exception;
	
	@Query("SELECT u.customer from SellerCustomers u where u.seller.sellerId=?1 and u.customer.customerStatus=true")
	List<Customer> customersBySellerId(UUID id)throws Exception;
}
