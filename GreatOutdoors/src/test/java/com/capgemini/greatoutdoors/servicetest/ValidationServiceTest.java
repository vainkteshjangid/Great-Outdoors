package com.capgemini.greatoutdoors.servicetest;



import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import com.capgemini.greatoutdoors.exceptions.InvalidEmailException;
import com.capgemini.greatoutdoors.exceptions.InvalidPasswordException;
import com.capgemini.greatoutdoors.exceptions.InvalidPhoneNumberException;
import com.capgemini.greatoutdoors.exceptions.InvalidUsernameException;
import com.capgemini.greatoutdoors.service.ValidationService;

public class ValidationServiceTest{
////////////////////////////////////////////////////////////////////////////////////////
/*------------------------Testcases to validate Username-----------------------------*/
///////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void isUsernameValidTest1() throws InvalidUsernameException {
		Assertions.assertThrows(InvalidUsernameException.class,()->ValidationService.isUsernameValid("Vainktesh@123"));
	}
	@Test
	public void isUsernameValidTest2() throws InvalidUsernameException{
		Assertions.assertThrows(InvalidUsernameException.class,()->ValidationService.isUsernameValid("123vainktesh"));
	}
	@Test
	public void isUsernameValidTest3() throws InvalidUsernameException{
		Assertions.assertThrows(InvalidUsernameException.class,()->ValidationService.isUsernameValid("12345"));
	}
	@Test
	public void isUsernameValidTest4() throws InvalidUsernameException{
		Assert.assertTrue(ValidationService.isUsernameValid("Vainktesh123"));
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////
	/*------------------------Testcases to validate Password-----------------------------*/
	///////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void isPasswordValidTest1() {
		Assertions.assertThrows(InvalidPasswordException.class,()->ValidationService.isPasswordValid("hello@2020"));
	}
	@Test
	public void isPasswordValidTest2() {
		Assertions.assertThrows(InvalidPasswordException.class,()->ValidationService.isPasswordValid("HELLO@2020"));
	}
	@Test
	public void isPasswordValidTest3() {
		Assertions.assertThrows(InvalidPasswordException.class,()->ValidationService.isPasswordValid("Hello2020"));
	}
	@Test
	public void isPasswordValidTest4() {
		Assertions.assertThrows(InvalidPasswordException.class,()->ValidationService.isPasswordValid("hello@INDIA"));
	}
	@Test
	public void isPasswordValidTest5() {
		Assertions.assertThrows(InvalidPasswordException.class,()->ValidationService.isPasswordValid("Hi#123"));
	}
	@Test
	public void isPasswordValidTest6() throws InvalidPasswordException {
		Assert.assertTrue(ValidationService.isPasswordValid("Hello@2020!"));
	}
	
	////////////////////////////////////////////////////////////////////////////////////////
	/*------------------------Testcases to validate Phone number-----------------------------*/
	///////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void isPhoneNumberValidTest1() {
		Assertions.assertThrows(InvalidPhoneNumberException.class,()->ValidationService.isPhoneNumberValid("985263"));
	}
	@Test
	public void isPhoneNumberValidTest2() {
		Assertions.assertThrows(InvalidPhoneNumberException.class,()->ValidationService.isPhoneNumberValid("985263447725"));
	}
	@Test
	public void isPhoneNumberValidTest3() {
		Assertions.assertThrows(InvalidPhoneNumberException.class,()->ValidationService.isPhoneNumberValid("0852634512"));
	}
	@Test
	public void isPhoneNumberValidTest4() throws InvalidPhoneNumberException {
		Assert.assertTrue(ValidationService.isPhoneNumberValid("9852634512"));
	}
	@Test
	public void isPhoneNumberValidTest5() {
		Assertions.assertThrows(InvalidPhoneNumberException.class,()->ValidationService.isPhoneNumberValid("985263abcd"));
	}
	
	////////////////////////////////////////////////////////////////////////////////////////
	/*------------------------Testcases to validate Email-----------------------------*/
	///////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void isEmailValidTest1() {
		Assertions.assertThrows(InvalidEmailException.class,()->ValidationService.isEmailValid("Abhishek@gmail.com"));
	}
	@Test
	public void isEmailValidTest2() {
		Assertions.assertThrows(InvalidEmailException.class,()->ValidationService.isEmailValid("abhishek.gmail.com"));
	}
	@Test
	public void isEmailValidTest3() {
		Assertions.assertThrows(InvalidEmailException.class,()->ValidationService.isEmailValid("abhishek@"));
	}
	@Test
	public void isEmailValidTest4() {
		Assertions.assertThrows(InvalidEmailException.class,()->ValidationService.isEmailValid("@abhishek.gmail.com"));
	}
	@Test
	public void isEmailValidTest5() {
		Assertions.assertThrows(InvalidEmailException.class,()->ValidationService.isEmailValid("Abhi_sharma.123@gmail_com"));
	}
	@Test
	public void isEmailValidTest6() throws InvalidEmailException{
		Assert.assertTrue(ValidationService.isEmailValid("abhi_sharma.123@gmail.com"));
	}
}
