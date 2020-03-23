package com.capgemini.greatoutdoors.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.greatoutdoors.exceptions.InvalidEmailException;
import com.capgemini.greatoutdoors.exceptions.InvalidPasswordException;
import com.capgemini.greatoutdoors.exceptions.InvalidPhoneNumberException;
import com.capgemini.greatoutdoors.exceptions.InvalidUsernameException;

public class ValidationService {
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*****************************************************************************************************************
* Function Name : isUsernameValid;
* Input Parameters : username;
* Return type : boolean
* Description : This function check whether a username is valid or not.
*****************************************************************************************************************/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static boolean isUsernameValid(String username) throws InvalidUsernameException{
		final String  USERNAME_PATTERN="[a-zA-Z]{1}[a-zA-Z0-9]{1,}";
		Pattern pattern=Pattern.compile(USERNAME_PATTERN);
		Matcher matcher=pattern.matcher(username);
		if(!matcher.matches()) {
			throw new InvalidUsernameException("Invalid username!username must start with a letter and it should be alphanumeric.");
		}
		return matcher.matches();
		
	}
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*****************************************************************************************************************
* Function Name : isPasswordValid;
* Input Parameters : password;
* Return type : boolean
* Description : Checks whether a password is valid or not
*****************************************************************************************************************/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public static boolean isPasswordValid(String password) throws InvalidPasswordException {
		
		if(password.length()>=8) {
			Pattern pwdPattern,lowerPattern,upperPattern,numPattern,specialCharPattern;
			Matcher pwdMatcher,lowerMatcher,upperMatcher,numMatcher,specialCharMatcher;
			String PASSWORD="[a-zA-Z0-9@#!]{8,}";
			String SPECIAL_CHARACTER="[@#!]{1,}";
			String LOWERCASE="[a-z]{1,}";
			String UPPERCASE="[A-Z]{1,}";
			String NUMBER="[0-9]{1,}";
		
			pwdPattern=Pattern.compile(PASSWORD);
			lowerPattern=Pattern.compile(LOWERCASE);
			upperPattern=Pattern.compile(UPPERCASE);
			numPattern=Pattern.compile(NUMBER);
			specialCharPattern=Pattern.compile(SPECIAL_CHARACTER);
		
			pwdMatcher=pwdPattern.matcher(password);
			lowerMatcher=lowerPattern.matcher(password);
			upperMatcher=upperPattern.matcher(password);
			numMatcher=numPattern.matcher(password);
			specialCharMatcher=specialCharPattern.matcher(password);
		
			if(pwdMatcher.matches()&&lowerMatcher.find()&&upperMatcher.find()&&numMatcher.find()
				&&specialCharMatcher.find()) {
				return true;
			}
			
		}
		throw new InvalidPasswordException("Password should contain at leat one small letter"
					+ ", one capital letter, one digit, one special character like @,#,! and must be at least"
					+ " 8 characters long.");
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*****************************************************************************************************************
* Function Name : isPhoneNumberValid;
* Input Parameters : phone
* Return type : boolean
* Description :  Checks weather a phone number is valid or not
*****************************************************************************************************************/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public static boolean isPhoneNumberValid(String phone) throws InvalidPhoneNumberException {
		Pattern pattern=Pattern.compile("[1-9]{1}[0-9]{9}");
		Matcher matcher=pattern.matcher(phone);
		if(!matcher.matches()) {
			throw new InvalidPhoneNumberException("Phone no. should contain only 10 digits.");
		}
		return matcher.matches();
	}
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*****************************************************************************************************************
* Function Name : isEmailValid;
* Input Parameters : email;
* Return type : boolean;
* Description : Checks whether an email is valid or not
*****************************************************************************************************************/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static boolean isEmailValid(String email) throws InvalidEmailException {
		Pattern pattern=Pattern.compile("[a-z0-9._]+@{1}[a-z0-9.]+");
		Matcher emailMatcher=pattern.matcher(email);
		if(!emailMatcher.matches()) {
			throw new InvalidEmailException("Email should contain only small letters, "
					+ "special characters like (. _) in the format \"user@domain\"");
		}
		return emailMatcher.matches();
	}
}
