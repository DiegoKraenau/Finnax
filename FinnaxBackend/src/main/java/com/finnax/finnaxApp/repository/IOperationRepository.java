package com.finnax.finnaxApp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.finnax.finnaxApp.entities.Customer;
import com.finnax.finnaxApp.entities.Interest;
import com.finnax.finnaxApp.entities.Operation;

@Repository
public interface IOperationRepository extends JpaRepository<Operation, UUID> {

	@Query("select u from Operation u where u.operationId= ?1")
	Operation findByIdOriginal(UUID id)throws Exception;
	
	@Modifying
	@Query("update Operation u set u.firtsOperation = false where u.firtsOperation=true and u.customer.customerId= ?1")
	void updateFirtsOperation(UUID id)throws Exception;
	
	@Modifying
	@Query("update Operation u set u.lastPayment = false where u.lastPayment=true and u.customer.customerId= ?1")
	void updateLastPayment(UUID id)throws Exception;
}
