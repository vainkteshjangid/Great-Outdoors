package com.capgemini.greatoutdoors.dto;

public class CartDTO {
	String username,productID,quantity;

	public CartDTO() {
		this.username=null;
		this.productID=null;
		this.quantity=null;
	}
	public CartDTO(String username, String productID, String quantity) {
		super();
		this.username = username;
		this.productID = productID;
		this.quantity = quantity;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
}
