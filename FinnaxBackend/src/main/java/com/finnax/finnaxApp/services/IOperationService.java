package com.finnax.finnaxApp.services;

import java.util.UUID;

import org.springframework.data.jpa.repository.Query;

import com.finnax.finnaxApp.entities.Interest;
import com.finnax.finnaxApp.entities.Operation;

public interface IOperationService extends CrudService<Operation>{

	@Query("select u from Operation u where u.operationId= ?1")
	Operation findByIdOriginal(UUID id)throws Exception;
	
	void updateFirtsOperation(UUID id)throws Exception;
	
	void updateLastPayment(UUID id)throws Exception;
}
