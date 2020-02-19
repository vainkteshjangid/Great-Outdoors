package com.capgemini.greatoutdoors.ui;

import java.util.Scanner;

import com.capgemini.greatoutdoors.util.CurrentSessionInfo;
import com.capgemini.greatoutdoors.util.UserRepository;
import com.capgemini.greatoutdoors.dto.AddressDTO;
import com.capgemini.greatoutdoors.dto.CartDTO;
import com.capgemini.greatoutdoors.dto.UserDTO;
import com.capgemini.greatoutdoors.exceptions.InvalidEmailException;
import com.capgemini.greatoutdoors.exceptions.InvalidPasswordException;
import com.capgemini.greatoutdoors.exceptions.InvalidPhoneNumberException;
import com.capgemini.greatoutdoors.exceptions.InvalidUsernameException;
import com.capgemini.greatoutdoors.service.CartServiceImpl;
import com.capgemini.greatoutdoors.service.UserServiceImpl;
import com.capgemini.greatoutdoors.service.ValidationService;

public class UserInterface {

	static UserServiceImpl userService=new UserServiceImpl();
	static CartServiceImpl cartService=new CartServiceImpl();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UserRepository();
		
		homePage();
	}
	
	private static void homePage() {
		Scanner s=new Scanner(System.in);
		System.out.println("1. Register a new user.");
		System.out.println("2. Login");
		System.out.println("3. Log out");
		System.out.println("4. Go to cart.");
		char ch=s.next().charAt(0);
		
		switch(ch) {
		case '1':
			UserRegistration();
			break;
		case '2':
			UserLogin();
			break;
		case '3':
			UserLogout();
			break;
		case '4':
			GoToCart();
			break;
		}
	}
	
	private static void GoToCart() {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		CartDTO cartDTOObj=new CartDTO();
		if(!CurrentSessionInfo.isLoggedIn) {
			System.out.println("You are not logged in. Please login!");
		}
		else {
			cartDTOObj.setUsername(CurrentSessionInfo.currentUser);
			String productID,quantity;
			System.out.println("1.Add items to the cart.");
			System.out.println("2.Remove item from cart.");
			char ch=s.next().charAt(0);
			s.nextLine();
			switch(ch) {
			case '1':
				System.out.print("Enter Product ID:");
				productID=s.nextLine();
				cartDTOObj.setProductID(productID);
				System.out.print("Number of units:");
				quantity=s.nextLine();
				cartDTOObj.setQuantity(quantity);
				boolean isAdded=cartService.addItemToCart(cartDTOObj);
				if(isAdded) {
					System.out.println("Item added in the cart.");
				}
				else {
					System.out.println("Could not add item in the list!");
				}
				break;
				
			case '2':
				System.out.print("Enter Product ID:");
				productID=s.nextLine();
				cartDTOObj.setProductID(productID);
				boolean isRemoved=cartService.removeItemFromCart(cartDTOObj);
				if(isRemoved) {
					System.out.println("Item removed from cart successfully!");
				}
				else {
					System.out.println("Could not remove item from cart!");
				}
				break;
			}
		}
		homePage();
	}

	private static void UserLogout() {
		boolean isLoggedOut=userService.userLogout();
		if(isLoggedOut) {
			System.out.println("Logged out successfully!");
		}
		else {
			System.out.println("You are already logged out!");
		}
		homePage();
	}

	private static void UserLogin() {
		
		if(CurrentSessionInfo.isLoggedIn) {
			System.out.println("You are already logged in.");
		}
		else {
			Scanner s=new Scanner(System.in);
			String username,password;
			
			System.out.print("username:");
			username=s.nextLine();
			System.out.print("Password:");
			password=s.nextLine();
			
			boolean loggedIn=userService.userLogin(username,password);
			if(loggedIn) {
				System.out.println("You are logged in successfully!");
				CurrentSessionInfo.isLoggedIn=true;
				CurrentSessionInfo.currentUser=username;
			}else {
				System.out.println("Login failed!");
			}
		}
		homePage();
	}

	private static void UserRegistration() {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		UserDTO newUser=new UserDTO();
		boolean isValid;
		
		//*********************************************************************
		String username;
		do {
			System.out.print("Enter username:");
			username=s.nextLine();
			
			try {
				isValid=ValidationService.isUsernameValid(username);
			}catch(InvalidUsernameException e) {
				System.out.println(e);
				isValid=false;
			}
		}while(!isValid);
		newUser.setUsername(username);
		
		
		//******************************************************************************
		String pwd,confirmPWD;
		do {
			do {
				System.out.print("Enter a password:");
				pwd=s.nextLine();
				try {
					isValid=ValidationService.isPasswordValid(pwd);
				}catch(InvalidPasswordException e) {
					System.out.println(e);
					isValid=false;
				}
			}while(!isValid);
			
			System.out.print("Confirm password:");
			confirmPWD=s.nextLine();
			if(!pwd.equals(confirmPWD)) {
				System.out.println("Password MisMatch! Both the password should be same. Try again.");
			}
		}while(!pwd.equals(confirmPWD));
		newUser.setPassword(pwd);
		
		//**********************************************************************************
		newUser.setRole("Retailer");
		
		//**********************************************************************************
		String email;
		do {
			System.out.print("Enter email:");
			email=s.nextLine();
			try {
				isValid=ValidationService.isEmailValid(email);
			}catch(InvalidEmailException e) {
				System.out.println(e);
				isValid=false;
			}
		}while(!isValid);
		newUser.setEmail(email);
		
		
		//************************************************************************************
		String phone;
		do {
			System.out.print("Enter Phone no:");
			phone=s.nextLine();
			try {
				isValid=ValidationService.isPhoneNumberValid(phone);
			}catch(InvalidPhoneNumberException e) {
				System.out.println(e);
				isValid=false;
			}
		}while(!isValid);
		newUser.setPhoneNumber(phone);
		
		//***************************************************************************************
		AddressDTO address=new AddressDTO();
		address.setAddressId("AID"+Math.random()*1000000);
		address.setRetailerId("RID"+Math.random()*1000000);
		System.out.println("Enter your address:-");
		System.out.print("Building No:");
		address.setBuildingNumber(s.nextLine());
		System.out.print("City:");
		address.setCity(s.nextLine());
		System.out.print("State:");
		address.setRetailerId(s.nextLine());
		System.out.print("Field:");
		address.setField(s.nextLine());
		System.out.print("Zip code:");
		address.setZip(s.nextLine());
		
		newUser.setAddress(address);
		
		//*************************************************************************************
		boolean registered=userService.userRegistration(newUser);
		if(registered) {
			System.out.println("Registration successful!");
		}
		else {
			System.out.println("Could no complete registration process. Please try later.");
		}
		homePage();
	}

}
