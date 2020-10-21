package com.finnax.finnaxApp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.finnax.finnaxApp.entities.Operation;
import com.finnax.finnaxApp.entities.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, UUID>{

	
}
