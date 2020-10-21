package com.finnax.finnaxApp.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="interest")
public class Interest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "interestId", updatable = false, nullable = false)
	private int interestId;
	
	@Column(name = "interestType", updatable = false, nullable = false)
	private String interestType;
	
	@OneToMany(mappedBy = "interest", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Customer> listCustomers;

	public int getInterestId() {
		return interestId;
	}

	public void setInterestId(int interestId) {
		this.interestId = interestId;
	}

	public String getInterestType() {
		return interestType;
	}

	public void setInterestType(String interestType) {
		this.interestType = interestType;
	}

	public List<Customer> getListCustomers() {
		return listCustomers;
	}

	public void setListCustomers(List<Customer> listCustomers) {
		this.listCustomers = listCustomers;
	}


	
	
}

