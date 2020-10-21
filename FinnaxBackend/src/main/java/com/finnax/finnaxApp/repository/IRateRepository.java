package com.finnax.finnaxApp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finnax.finnaxApp.entities.Rate;
import com.finnax.finnaxApp.entities.SellerCustomers;

public interface IRateRepository extends JpaRepository<Rate, Integer>{

}
