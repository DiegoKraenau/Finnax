package com.finnax.finnaxApp.entities;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="operations")
public class Operation implements Serializable{

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
	@Column(name = "operationId", updatable = false, nullable = false)
	private UUID operationId;
	
	@Column(name="operationDate", nullable = false)
	private String operationDate;
	
	@Column(name="firtsOperation", nullable = false)
	private boolean firtsOperation;
	
	
	@Column(name="lastPayment", nullable = false)
	private boolean lastPayment;
	
	@ManyToOne
	@JoinColumn(name="fkCustomerId")
	private Customer customer;
	
	@OneToOne(mappedBy = "operation", cascade = CascadeType.ALL)
    private Purchase purchase;
	
	@OneToOne(mappedBy = "operation", cascade = CascadeType.ALL)
    private Payment payment;

	public UUID getOperationId() {
		return operationId;
	}

	public void setOperationId(UUID operationId) {
		this.operationId = operationId;
	}

	public String getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(String operationDate) {
		this.operationDate = operationDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public boolean isFirtsOperation() {
		return firtsOperation;
	}

	public void setFirtsOperation(boolean firtsOperation) {
		this.firtsOperation = firtsOperation;
	}

	public boolean isLastPayment() {
		return lastPayment;
	}

	public void setLastPayment(boolean lastPayment) {
		this.lastPayment = lastPayment;
	}

	
	

	
}
