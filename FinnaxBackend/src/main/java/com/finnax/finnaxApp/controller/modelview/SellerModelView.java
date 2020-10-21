package com.finnax.finnaxApp.controller.modelview;

import java.util.UUID;

public class SellerModelView {

	private UUID sellerId;
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UUID getSellerId() {
		return sellerId;
	}
	public void setSellerId(UUID sellerId) {
		this.sellerId = sellerId;
	}
	
	
	
}
