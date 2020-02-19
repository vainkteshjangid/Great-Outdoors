package com.capgemini.greatoutdoors.dto;

public class AddressDTO {
	String addressId;
	String retailerId;
	String buildingNumber;
	String city;
	String state;
	String field;
	String zip;
	
	
	public AddressDTO() {
		this.addressId=null;
		this.retailerId=null;
		this.buildingNumber=null;
		this.city=null;
		this.state=null;
		this.field=null;
		this.zip=null;
	}
	public AddressDTO(String addressId, String retailerId, String buildingNumber, String city, String state,
			String field, String zip) {
		super();
		this.addressId = addressId;
		this.retailerId = retailerId;
		this.buildingNumber = buildingNumber;
		this.city = city;
		this.state = state;
		this.field = field;
		this.zip = zip;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getRetailerId() {
		return retailerId;
	}
	public void setRetailerId(String retailerId) {
		this.retailerId = retailerId;
	}
	public String getBuildingNumber() {
		return buildingNumber;
	}
	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	
}
