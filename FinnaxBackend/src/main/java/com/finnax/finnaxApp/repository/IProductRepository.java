package com.finnax.finnaxApp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.finnax.finnaxApp.entities.Customer;
import com.finnax.finnaxApp.entities.Interest;
import com.finnax.finnaxApp.entities.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, UUID>{

	@Query("select u from Product u where u.productId= ?1")
	Product findByIdOriginal(UUID id)throws Exception;
}
