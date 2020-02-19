package com.capgemini.greatoutdoors.dto;

public class UserDTO {

	String username,password,role,email,phoneNumber;
	AddressDTO address;
	
	public UserDTO() {
		this.username=null;
		this.password=null;
		this.role=null;
		this.email=null;
		this.phoneNumber=null;
		this.address=new AddressDTO();
	}
	public UserDTO(String username, String password, String role, String email, String phoneNumber,
			AddressDTO address) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	
}
