package com.capgemini.greatoutdoors.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationService {
	public static boolean isUsernameValid(String username) {
		final String  USERNAME_PATTERN="[a-zA-Z]{1}[a-zA-Z0-9]{1,}";
		Pattern pattern=Pattern.compile(USERNAME_PATTERN);
		Matcher matcher=pattern.matcher(username);
		return matcher.matches();
		
	}
	
	public static boolean isPasswordValid(String password) {
		
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
		
		return false;	
	}

	public static boolean isPhoneNumberValid(String phone) {
		Pattern pattern=Pattern.compile("[1-9]{1}[0-9]{9}");
		Matcher matcher=pattern.matcher(phone);
		return matcher.matches();
	}
	
	public static boolean isEmailValid(String email) {
		Pattern pattern=Pattern.compile("[a-z0-9._]+@{1}[a-z0-9.]+");
		Matcher emailMatcher=pattern.matcher(email);
		return emailMatcher.matches();
	}
}
