package com.capgemini.greatoutdoors.servicetest;


import org.junit.Assert;
import org.junit.Test;

import com.capgemini.greatoutdoors.service.ValidationService;

public class ValidationServiceTest{
////////////////////////////////////////////////////////////////////////////////////////
/*------------------------Testcases to validate Username-----------------------------*/
///////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void isUsernameValidTest1() {
		
		Assert.assertFalse(ValidationService.isUsernameValid("Vainktesh@123"));
	}
	@Test
	public void isUsernameValidTest2() {
		Assert.assertFalse(ValidationService.isUsernameValid("123vainktesh"));
	}
	@Test
	public void isUsernameValidTest3() {
		Assert.assertFalse(ValidationService.isUsernameValid("12345"));
	}
	@Test
	public void isUsernameValidTest4() {
		Assert.assertTrue(ValidationService.isUsernameValid("Vainktesh123"));
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////
	/*------------------------Testcases to validate Password-----------------------------*/
	///////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void isPasswordValidTest1() {
		Assert.assertFalse(ValidationService.isPasswordValid("hello@2020"));
	}
	@Test
	public void isPasswordValidTest2() {
		Assert.assertFalse(ValidationService.isPasswordValid("HELLO@2020"));
	}
	@Test
	public void isPasswordValidTest3() {
		Assert.assertFalse(ValidationService.isPasswordValid("Hello2020"));
	}
	@Test
	public void isPasswordValidTest4() {
		Assert.assertFalse(ValidationService.isPasswordValid("hello@INDIA"));
	}
	@Test
	public void isPasswordValidTest5() {
		Assert.assertFalse(ValidationService.isPasswordValid("Hi#123"));
	}
	@Test
	public void isPasswordValidTest6() {
		Assert.assertTrue(ValidationService.isPasswordValid("Hello@2020!"));
	}
	
	////////////////////////////////////////////////////////////////////////////////////////
	/*------------------------Testcases to validate Phone number-----------------------------*/
	///////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void isPhoneNumberValidTest1() {
		Assert.assertFalse(ValidationService.isPhoneNumberValid("985263"));
	}
	@Test
	public void isPhoneNumberValidTest2() {
		Assert.assertFalse(ValidationService.isPhoneNumberValid("985263447725"));
	}
	@Test
	public void isPhoneNumberValidTest3() {
		Assert.assertFalse(ValidationService.isPhoneNumberValid("0852634512"));
	}
	@Test
	public void isPhoneNumberValidTest4() {
		Assert.assertTrue(ValidationService.isPhoneNumberValid("9852634512"));
	}
	@Test
	public void isPhoneNumberValidTest5() {
		Assert.assertFalse(ValidationService.isPhoneNumberValid("985263abcd"));
	}
	
	////////////////////////////////////////////////////////////////////////////////////////
	/*------------------------Testcases to validate Email-----------------------------*/
	///////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void isEmailValidTest1() {
		Assert.assertFalse(ValidationService.isEmailValid("Abhishek@gmail.com"));
	}
	@Test
	public void isEmailValidTest2() {
		Assert.assertFalse(ValidationService.isEmailValid("abhishek.gmail.com"));
	}
	@Test
	public void isEmailValidTest3() {
		Assert.assertFalse(ValidationService.isEmailValid("abhishek@"));
	}
	@Test
	public void isEmailValidTest4() {
		Assert.assertFalse(ValidationService.isEmailValid("@abhishek.gmail.com"));
	}
	@Test
	public void isEmailValidTest5() {
		Assert.assertFalse(ValidationService.isEmailValid("Abhi_sharma.123@gmail_com"));
	}
	@Test
	public void isEmailValidTest6() {
		Assert.assertTrue(ValidationService.isEmailValid("abhi_sharma.123@gmail.com"));
	}
}
