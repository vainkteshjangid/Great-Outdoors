package com.capgemini.greatdoors.dao;

import java.util.HashMap;

import com.capgemini.greatoutdoors.dto.CartDTO;
import com.capgemini.greatoutdoors.dto.UserDTO;
import com.capgemini.greatoutdoors.exceptions.UserNotFoundException;
import com.capgemini.greatoutdoors.exceptions.WrongPasswordException;
import com.capgemini.greatoutdoors.ui.UserInterface;
import com.capgemini.greatoutdoors.util.CartRepository;
import com.capgemini.greatoutdoors.util.CurrentSessionInfo;
import com.capgemini.greatoutdoors.util.UserRepository;

public class UserDaoImpl implements UserDao{

	public boolean userRegistration(UserDTO newUser) {
		UserDTO res=UserRepository.userList.put(newUser.getUsername(),newUser);
		if(res==null) {
			return true;
		}
		return false;
	}

	public boolean userLogin(String username,String password) {
		boolean isValid;
		
		//Check if username exist
		isValid=UserRepository.userList.containsKey(username);
		try {
			if(!isValid) {
				throw new UserNotFoundException("The username entered is incorrect! Try again.");
			}
		}catch(UserNotFoundException e) {
			System.out.println(e);
			return false;
		}
		
		
		//check if password is correct
		isValid=(password.equals(UserRepository.userList.get(username).getPassword()));
		try {
			if(!isValid) {
				throw new WrongPasswordException("Password is wrong!");
			}
		}catch(WrongPasswordException e) {
			System.out.println(e);
			return false;
		}
		
		return true;
	}

	public boolean userLogout() {
		if(CurrentSessionInfo.isLoggedIn) {
			CurrentSessionInfo.isLoggedIn=false;
			CurrentSessionInfo.currentUser=null;
			return true;
		}
		return false;
	}
	
}
