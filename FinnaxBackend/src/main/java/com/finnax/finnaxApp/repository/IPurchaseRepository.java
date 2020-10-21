package com.finnax.finnaxApp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.finnax.finnaxApp.entities.Interest;
import com.finnax.finnaxApp.entities.Product;
import com.finnax.finnaxApp.entities.Purchase;

public interface IPurchaseRepository extends JpaRepository<Purchase, UUID>{

	@Query("select u from Purchase u where u.purchaseId= ?1")
	Purchase findByIdOriginal(UUID id)throws Exception;
}
