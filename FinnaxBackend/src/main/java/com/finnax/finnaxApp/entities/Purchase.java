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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="purchases")
public class Purchase  implements Serializable{

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
	@Column(name = "purchaseId", updatable = false, nullable = false)
	private UUID purchaseId;
	
	@Column(name="purchaseName", nullable = false)
	private String purchaseName;
	
	@Column(name="purchaseAmount", nullable = false)
	private float purchaseAmount;
	
	@Column(name="deliveryAmount", nullable = false)
	private float deliveryAmount;
	
	@Column(name="purchaseProductsAmount", nullable = false)
	private float purchaseProductsAmount;
	
	@OneToOne
    @JoinColumn(name = "fkOperationId", updatable = false, nullable = false)
    private Operation operation;
	
	@OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Product> listProducts;

	public UUID getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(UUID purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getPurchaseName() {
		return purchaseName;
	}

	public void setPurchaseName(String purchaseName) {
		this.purchaseName = purchaseName;
	}

	public float getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(float purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public float getDeliveryAmount() {
		return deliveryAmount;
	}

	public void setDeliveryAmount(float deliveryAmount) {
		this.deliveryAmount = deliveryAmount;
	}

	public float getPurchaseProductsAmount() {
		return purchaseProductsAmount;
	}

	public void setPurchaseProductsAmount(float purchaseProductsAmount) {
		this.purchaseProductsAmount = purchaseProductsAmount;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public List<Product> getListProducts() {
		return listProducts;
	}

	public void setListProducts(List<Product> listProducts) {
		this.listProducts = listProducts;
	}
	
	
}
