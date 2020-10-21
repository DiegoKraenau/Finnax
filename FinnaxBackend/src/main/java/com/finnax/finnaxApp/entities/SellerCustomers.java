package com.finnax.finnaxApp.entities;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="sellerCustomers")
public class SellerCustomers  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Type(type = "uuid-char")
	@Column(name = "sellerCustomerId", updatable = false, nullable = false)
	private UUID sellerCustomerId;
	
	@ManyToOne
	@JoinColumn(name="sellerIdFk")
	private Seller seller;
	
	@ManyToOne
	@JoinColumn(name="customerIdFk")
	private Customer customer;

	public UUID getSellerCustomerId() {
		return sellerCustomerId;
	}

	public void setSellerCustomerId(UUID sellerCustomerId) {
		this.sellerCustomerId = sellerCustomerId;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
