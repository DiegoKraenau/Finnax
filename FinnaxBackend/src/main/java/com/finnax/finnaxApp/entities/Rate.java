package com.finnax.finnaxApp.entities;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="rate")
public class Rate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rateId", updatable = false, nullable = false)
	private int rateId;
	
	@Column(name = "rateType", updatable = false, nullable = false)
	private String rateType;
	
	@Column(name = "daysAmount", updatable = false, nullable = false)
	private int daysAmount;
	
	@OneToMany(mappedBy = "rate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Customer> listCustomers;

	public int getRateId() {
		return rateId;
	}

	public void setRateId(int rateId) {
		this.rateId = rateId;
	}

	public String getRateType() {
		return rateType;
	}

	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	public int getDaysAmount() {
		return daysAmount;
	}

	public void setDaysAmount(int daysAmount) {
		this.daysAmount = daysAmount;
	}

	public List<Customer> getListCustomers() {
		return listCustomers;
	}

	public void setListCustomers(List<Customer> listCustomers) {
		this.listCustomers = listCustomers;
	}

   
	
	
}
