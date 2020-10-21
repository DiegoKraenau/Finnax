package com.finnax.finnaxApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finnax.finnaxApp.entities.Interest;

public interface IInterestRepository extends JpaRepository<Interest, Integer>{

}
