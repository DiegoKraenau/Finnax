package com.finnax.finnaxApp.controller.modelview;

import java.util.UUID;

import javax.persistence.Column;

public class ProductModelView {
	
	private UUID productId;
	
	
	private String productDescription;
	

	private float productAmount;
	


	private UUID purchaseId;
	
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


	public UUID getPurchaseId() {
		return purchaseId;
	}


	public void setPurchaseId(UUID purchaseId) {
		this.purchaseId = purchaseId;
	}
	
	
}
