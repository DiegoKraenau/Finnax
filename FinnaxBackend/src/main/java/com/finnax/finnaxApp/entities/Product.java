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
@Table(name="products")
public class Product implements Serializable{

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
	@Column(name = "productId", updatable = false, nullable = false)
	private UUID productId;
	
	@Column(name="productDescription", nullable = false)
	private String productDescription;
	
	@Column(name="productAmount", nullable = false)
	private float productAmount;
	
	@ManyToOne
	@JoinColumn(name="fkPurchaseId")
	private Purchase purchase;

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public float getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(float productAmount) {
		this.productAmount = productAmount;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
	
	
}
