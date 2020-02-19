package com.capgemini.greatoutdoors.servicetest;

import org.junit.Test;

import com.capgemini.greatoutdoors.dto.AddressDTO;
import com.capgemini.greatoutdoors.dto.UserDTO;
import com.capgemini.greatoutdoors.service.UserServiceImpl;

import org.junit.Assert;

public class UserServiceImplTest {
	UserServiceImpl userService=new UserServiceImpl();
	@Test
	public void userRegistrationTest() {
		AddressDTO address1= new AddressDTO("AID"+Math.random()*1000000,"RID"+Math.random()*1000000,"45","Kanpur","Uttar Pradesh","NA","421220");
		UserDTO user1=new UserDTO("abc","Hello@123","Retailer","abc@gmail.com","8796521472",address1);
		Assert.assertTrue(userService.userRegistration(user1));
	}
	
	@Test
	public void userLoginTest1() {
		Assert.assertFalse(userService.userLogin("xyz123", "secure#1CODE"));
	}
	
	@Test
	public void userLoginTest2() {
		Assert.assertTrue(userService.userLogin("vainktesh", "Hello@2020"));
	}
	
	@Test
	public void userLogoutTest() {
		Assert.assertFalse(userService.userLogout());
	}

}
