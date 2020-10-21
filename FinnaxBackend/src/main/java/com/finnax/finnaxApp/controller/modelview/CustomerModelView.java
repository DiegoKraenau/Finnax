package com.finnax.finnaxApp.controller.modelview;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.finnax.finnaxApp.entities.Capitalization;
import com.finnax.finnaxApp.entities.Interest;
import com.finnax.finnaxApp.entities.Rate;

public class CustomerModelView {
	
	private UUID customerId;
	

	private String customerName;
	

	private float customerAmountInterest;
	

	private String customerPhone;
	

	private float customerCreditLine;
	

	private float customerCreditAvailable;
	

	private float customerCreditUsed;
	

	private float customerTotalDebt;
	

	private float customerMaintenanceAmount;
	

	private int customerMaintenanceDays;
	
	
	private float customerMinimunPaymentAmount;
	
	
	private boolean customerStatus;
	

	private int rateId;
	

	private int capitalizationId;
	

	private int interestId;
	
	private UUID sellerId;


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


	public int getRateId() {
		return rateId;
	}


	public void setRateId(int rateId) {
		this.rateId = rateId;
	}


	public int getCapitalizationId() {
		return capitalizationId;
	}


	public void setCapitalizationId(int capitalizationId) {
		this.capitalizationId = capitalizationId;
	}


	public int getInterestId() {
		return interestId;
	}


	public void setInterestId(int interestId) {
		this.interestId = interestId;
	}


	public UUID getSellerId() {
		return sellerId;
	}


	public void setSellerId(UUID sellerId) {
		this.sellerId = sellerId;
	}
	
	
	
	
	
	
}
