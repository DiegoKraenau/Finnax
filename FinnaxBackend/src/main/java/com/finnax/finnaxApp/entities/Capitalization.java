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
@Table(name = "capitalization")
public class Capitalization implements  Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "capitalizationId", updatable = false, nullable = false)
	private int capitalizationId;
	
	@Column(name = "capitalizationType", updatable = false, nullable = false)
	private String capitalizationType;
	
	@Column(name = "daysAmount", updatable = false, nullable = false)
	private int daysAmount;
	
	@OneToMany(mappedBy = "capitalization", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Customer> listCustomers;

	public int getCapitalizationId() {
		return capitalizationId;
	}

	public void setCapitalizationId(int capitalizationId) {
		this.capitalizationId = capitalizationId;
	}

	public String getCapitalizationType() {
		return capitalizationType;
	}

	public void setCapitalizationType(String capitalizationType) {
		this.capitalizationType = capitalizationType;
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
