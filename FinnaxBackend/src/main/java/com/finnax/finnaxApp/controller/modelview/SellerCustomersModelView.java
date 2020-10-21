package com.finnax.finnaxApp.controller.modelview;

import java.util.UUID;

public class SellerCustomersModelView {

	private UUID sellerIdFk;
	private UUID customerIdFk;
	private UUID sellerCustomersId;
	
	public UUID getSellerIdFk() {
		return sellerIdFk;
	}
	public void setSellerIdFk(UUID sellerIdFk) {
		this.sellerIdFk = sellerIdFk;
	}
	public UUID getCustomerIdFk() {
		return customerIdFk;
	}
	public void setCustomerIdFk(UUID customerIdFk) {
		this.customerIdFk = customerIdFk;
	}
	public UUID getSellerCustomersId() {
		return sellerCustomersId;
	}
	public void setSellerCustomersId(UUID sellerCustomersId) {
		this.sellerCustomersId = sellerCustomersId;
	}
	
	
	
}
