package com.capgemini.greatoutdoors.ui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.greatoutdoors.util.CartRepository;
import com.capgemini.greatoutdoors.util.CurrentSessionInfo;
import com.capgemini.greatoutdoors.util.UserRepository;
import com.capgemini.greatoutdoors.dto.AddressDTO;
import com.capgemini.greatoutdoors.dto.CartDTO;
import com.capgemini.greatoutdoors.dto.UserDTO;
import com.capgemini.greatoutdoors.exceptions.InvalidEmailException;
import com.capgemini.greatoutdoors.exceptions.InvalidPasswordException;
import com.capgemini.greatoutdoors.exceptions.InvalidPhoneNumberException;
import com.capgemini.greatoutdoors.exceptions.InvalidUsernameException;
import com.capgemini.greatoutdoors.exceptions.ItemNotFoundInCartException;
import com.capgemini.greatoutdoors.exceptions.UserNotFoundException;
import com.capgemini.greatoutdoors.exceptions.WrongPasswordException;
import com.capgemini.greatoutdoors.service.CartServiceImpl;
import com.capgemini.greatoutdoors.service.UserServiceImpl;
import com.capgemini.greatoutdoors.service.ValidationService;

public class UserInterface {

	static UserServiceImpl userService=new UserServiceImpl();
	static CartServiceImpl cartService=new CartServiceImpl();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		homePage();
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*****************************************************************************************************************
* Function Name : homePage
* Input Parameters : void
* Return type : void
* Description : Contains the behaviour of home page
*****************************************************************************************************************/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static void homePage() {
		Scanner s=new Scanner(System.in);
		System.out.println("1. Register a new user.");
		System.out.println("2. Login");
		System.out.println("3. Log out");
		System.out.println("4. Go to cart.");
		char ch=s.next().charAt(0);
		
		switch(ch) {
		case '1':
			userRegistration();
			break;
		case '2':
			userLogin();
			break;
		case '3':
			userLogout();
			break;
		case '4':
			goToCart();
			break;
		default:
			System.out.println("Invalid input!");
			homePage();
			break;
		}
	}
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*****************************************************************************************************************
* Function Name : goToCart
* Input Parameters : void
* Return type : void
* Description : Handles cart operations
*****************************************************************************************************************/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static void goToCart() {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		CartDTO cartDTOObj=new CartDTO();
		if(!CurrentSessionInfo.isLoggedIn) {
			System.out.println("You are not logged in. Please login!");
		}
		else {
			
			cartService.displayCartItems(CurrentSessionInfo.currentUser);
			cartDTOObj.setUsername(CurrentSessionInfo.currentUser);
			String productID,quantity;
			System.out.println("1.Add items to the cart.");
			System.out.println("2.Remove item from cart.");
			System.out.println("3.Go to home page.");
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
					System.out.println("Could not add item in the CART!");
				}
				break;
				
			case '2':
				boolean emptyCart=cartService.isCartEmpty(cartDTOObj);
				if(emptyCart) {
					System.out.println("Cart is already empty!");
					break;
				}
				System.out.print("Enter Product ID:");
				productID=s.nextLine();
				cartDTOObj.setProductID(productID);
				boolean isRemoved;
				try {
					isRemoved = cartService.removeItemFromCart(cartDTOObj);
				} catch (ItemNotFoundInCartException e) {
					System.out.println(e.getMessage());
					isRemoved=false;
				}
				if(isRemoved) {
					System.out.println("Item removed from cart successfully!");
				}
				break;
			case '3':
				homePage();
				break;
			default:
				System.out.println("Invalid input!");
				goToCart();
				break;
			}
		}
		homePage();
	}

	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*****************************************************************************************************************
* Function Name : userLogout
* Input Parameters : void
* Return type : void
* Description : Logout active user if any
*****************************************************************************************************************/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static void userLogout() {
		boolean isLoggedOut=userService.userLogout();
		if(isLoggedOut) {
			System.out.println("Logged out successfully!");
		}
		else {
			System.out.println("You are already logged out!");
		}
		homePage();
	}

	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*****************************************************************************************************************
* Function Name : userLogin
* Input Parameters : void
* Return type : void
* Description : Perform login activity
*****************************************************************************************************************/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static void userLogin() {
		
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
			
			boolean loggedIn;
			try {
				loggedIn = userService.userLogin(username,password);
			} catch (UserNotFoundException | WrongPasswordException e) {
				System.out.println(e.getMessage());
				loggedIn=false;
			}
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

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*****************************************************************************************************************
* Function Name : userRegistration
* Input Parameters : void
* Return type : void
* Description : Contains user registration process
*****************************************************************************************************************/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static void userRegistration() {
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
				System.out.println(e.getMessage());
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
					System.out.println(e.getMessage());
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
				System.out.println(e.getMessage());
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
				System.out.println(e.getMessage());
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
		boolean registered;
		try {
			registered = userService.userRegistration(newUser);
		} catch (InvalidUsernameException e) {
			System.out.println(e.getMessage());
			registered=false;
		}
		if(registered) {
			System.out.println("Registration successful!");
		}
		else {
			System.out.println("Could not complete registration process. Please try again.");
		}
		homePage();
	}

}
