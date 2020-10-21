package com.finnax.finnaxApp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finnax.finnaxApp.entities.Capitalization;
import com.finnax.finnaxApp.entities.Customer;

public interface ICapitalizationRepository extends JpaRepository<Capitalization, Integer> {

}
