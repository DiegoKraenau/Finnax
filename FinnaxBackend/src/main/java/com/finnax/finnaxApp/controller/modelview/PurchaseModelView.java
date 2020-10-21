package com.finnax.finnaxApp.controller.modelview;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;

public class PurchaseModelView {

	private UUID purchaseId;
	
	private String purchaseName;
	

	private float purchaseAmount;
	

	private float deliveryAmount;

	private String purchaseProductsName;
	
	private float purchaseProductsAmount;
	
	private String operationDate;
	
	private UUID operationId;

	private UUID customerId;
	
	private List<ProductModelView> listaProducts;
	
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

	public String getPurchaseProductsName() {
		return purchaseProductsName;
	}

	public void setPurchaseProductsName(String purchaseProductsName) {
		this.purchaseProductsName = purchaseProductsName;
	}

	public float getPurchaseProductsAmount() {
		return purchaseProductsAmount;
	}

	public void setPurchaseProductsAmount(float purchaseProductsAmount) {
		this.purchaseProductsAmount = purchaseProductsAmount;
	}

	public String getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(String operationDate) {
		this.operationDate = operationDate;
	}

	public UUID getCustomerId() {
		return customerId;
	}

	public void setCustomerId(UUID customerId) {
		this.customerId = customerId;
	}

	public UUID getOperationId() {
		return operationId;
	}

	public void setOperationId(UUID operationId) {
		this.operationId = operationId;
	}

	public UUID getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(UUID purchaseId) {
		this.purchaseId = purchaseId;
	}

	public List<ProductModelView> getListaProducts() {
		return listaProducts;
	}

	public void setListaProducts(List<ProductModelView> listaProducts) {
		this.listaProducts = listaProducts;
	}

	
	
	
}
