package com.finnax.finnaxApp.entities;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "sellers")
public class Seller implements Serializable{

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
	@Column(name = "sellerId", updatable = false, nullable = false)
	private UUID sellerId;
	
	@Column(name="sellerEmail", nullable = false)
	private String sellerEmail;

	@Column(name="sellerPasword", nullable = false)
	private String sellerPasword;
	
	@Column(name="sellerName", nullable = false)
	private String sellerName;

	@OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<SellerCustomers> listCustomers;

	public UUID getSellerId() {
		return sellerId;
	}

	public void setSellerId(UUID sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public String getSellerPasword() {
		return sellerPasword;
	}

	public void setSellerPasword(String sellerPasword) {
		this.sellerPasword = sellerPasword;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public List<SellerCustomers> getListCustomers() {
		return listCustomers;
	}

	public void setListCustomers(List<SellerCustomers> listCustomers) {
		this.listCustomers = listCustomers;
	}

	

	
	
}
