package com.capgemini.greatoutdoors.daotest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.greatdoors.dao.UserDaoImpl;
import com.capgemini.greatoutdoors.dto.AddressDTO;
import com.capgemini.greatoutdoors.dto.UserDTO;
import com.capgemini.greatoutdoors.exceptions.InvalidUsernameException;
import com.capgemini.greatoutdoors.exceptions.UserNotFoundException;
import com.capgemini.greatoutdoors.exceptions.WrongPasswordException;


public class UserDaoImplTest {
	UserDaoImpl userService=new UserDaoImpl();
	@Test
	public void userRegistrationTest() throws InvalidUsernameException {
		AddressDTO address1= new AddressDTO("AID"+Math.random()*1000000,"RID"+Math.random()*1000000,"45","Kanpur","Uttar Pradesh","NA","421220");
		UserDTO user1=new UserDTO("xyz","Hello@123","Retailer","abc@gmail.com","8796521472",address1);
		Assertions.assertTrue(userService.userRegistration(user1));
	}
	
	@Test
	public void userLoginTest1(){
		Assertions.assertThrows(UserNotFoundException.class,()->userService.userLogin("xyz123", "secure#1CODE"));
	}
	
	@Test
	public void userLoginTest2() throws UserNotFoundException, WrongPasswordException {
		Assertions.assertTrue(userService.userLogin("vainktesh", "Hello@2020"));
	}
	
	@Test
	public void userLogoutTest() {
		Assertions.assertFalse(userService.userLogout());
	}

}
