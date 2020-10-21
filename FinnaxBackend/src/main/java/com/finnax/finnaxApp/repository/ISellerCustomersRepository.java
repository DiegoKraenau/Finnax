package com.finnax.finnaxApp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finnax.finnaxApp.entities.Interest;
import com.finnax.finnaxApp.entities.SellerCustomers;

public interface ISellerCustomersRepository extends JpaRepository<SellerCustomers, UUID>{

}
