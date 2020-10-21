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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "customers")
public class Customer implements Serializable{

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
	@Column(name = "customerId", updatable = false, nullable = false)
	private UUID customerId;
	
	@Column(name="customerName", nullable = false)
	private String customerName;
	
	@Column(name="customerAmountInterest", nullable = false)
	private float customerAmountInterest;
	
	@Column(name="customerPhone", nullable = false)
	private String customerPhone;
	
	@Column(name="customerCreditLine", nullable = false)
	private float customerCreditLine;
	
	@Column(name="customerCreditAvailable", nullable = false)
	private float customerCreditAvailable;
	
	@Column(name="customerCreditUsed", nullable = false)
	private float customerCreditUsed;
	
	@Column(name="customerTotalDebt", nullable = false)
	private float customerTotalDebt;
	
	@Column(name="customerMaintenanceAmount", nullable = false)
	private float customerMaintenanceAmount;
	
	@Column(name="customerMaintenanceDays", nullable = false)
	private int customerMaintenanceDays;
	
	@Column(name="customerMinimunPaymentAmount", nullable = false)
	private float customerMinimunPaymentAmount;
	
	@Column(name="customerStatus", nullable = false)
	private boolean customerStatus;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<SellerCustomers> listUsers;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Operation> listOperations;
	
	@ManyToOne
	@JoinColumn(name="fkRateId")
	private Rate rate;
	
	@ManyToOne
	@JoinColumn(name="fkCapitalizationId", nullable = true)
	private Capitalization capitalization;
	
	@ManyToOne
	@JoinColumn(name="fkInterestId")
	private Interest interest;

	public UUID getCustomerId() {
		return customerId;
	}

	public void setCustomerId(UUID customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public float getCustomerAmountInterest() {
		return customerAmountInterest;
	}

	public void setCustomerAmountInterest(float customerAmountInterest) {
		this.customerAmountInterest = customerAmountInterest;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public float getCustomerCreditLine() {
		return customerCreditLine;
	}

	public void setCustomerCreditLine(float customerCreditLine) {
		this.customerCreditLine = customerCreditLine;
	}

	public float getCustomerCreditAvailable() {
		return customerCreditAvailable;
	}

	public void setCustomerCreditAvailable(float customerCreditAvailable) {
		this.customerCreditAvailable = customerCreditAvailable;
	}

	public float getCustomerCreditUsed() {
		return customerCreditUsed;
	}

	public void setCustomerCreditUsed(float customerCreditUsed) {
		this.customerCreditUsed = customerCreditUsed;
	}

	public float getCustomerTotalDebt() {
		return customerTotalDebt;
	}

	public void setCustomerTotalDebt(float customerTotalDebt) {
		this.customerTotalDebt = customerTotalDebt;
	}

	public float getCustomerMaintenanceAmount() {
		return customerMaintenanceAmount;
	}

	public void setCustomerMaintenanceAmount(float customerMaintenanceAmount) {
		this.customerMaintenanceAmount = customerMaintenanceAmount;
	}

	public int getCustomerMaintenanceDays() {
		return customerMaintenanceDays;
	}

	public void setCustomerMaintenanceDays(int customerMaintenanceDays) {
		this.customerMaintenanceDays = customerMaintenanceDays;
	}

	public float getCustomerMinimunPaymentAmount() {
		return customerMinimunPaymentAmount;
	}

	public void setCustomerMinimunPaymentAmount(float customerMinimunPaymentAmount) {
		this.customerMinimunPaymentAmount = customerMinimunPaymentAmount;
	}

	public boolean isCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(boolean customerStatus) {
		this.customerStatus = customerStatus;
	}

	public List<SellerCustomers> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<SellerCustomers> listUsers) {
		this.listUsers = listUsers;
	}

	public List<Operation> getListOperations() {
		return listOperations;
	}

	public void setListOperations(List<Operation> listOperations) {
		this.listOperations = listOperations;
	}

	public Rate getRate() {
		return rate;
	}

	public void setRate(Rate rate) {
		this.rate = rate;
	}

	public Capitalization getCapitalization() {
		return capitalization;
	}

	public void setCapitalization(Capitalization capitalization) {
		this.capitalization = capitalization;
	}

	public Interest getInterest() {
		return interest;
	}

	public void setInterest(Interest interest) {
		this.interest = interest;
	}

	
	
}
