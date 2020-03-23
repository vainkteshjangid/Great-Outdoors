package com.capgemini.greatdoors.dao;

import java.util.HashMap;

import com.capgemini.greatoutdoors.dto.CartDTO;
import com.capgemini.greatoutdoors.dto.UserDTO;
import com.capgemini.greatoutdoors.exceptions.InvalidUsernameException;
import com.capgemini.greatoutdoors.exceptions.UserNotFoundException;
import com.capgemini.greatoutdoors.exceptions.WrongPasswordException;
import com.capgemini.greatoutdoors.ui.UserInterface;
import com.capgemini.greatoutdoors.util.CartRepository;
import com.capgemini.greatoutdoors.util.CurrentSessionInfo;
import com.capgemini.greatoutdoors.util.UserRepository;

public class UserDaoImpl implements UserDao{

	public boolean userRegistration(UserDTO newUser) throws InvalidUsernameException {
		boolean userAlreadyExist=UserRepository.userList.containsKey(newUser.getUsername());
		if(userAlreadyExist) {
			throw new InvalidUsernameException("username already exist! Try another username.");
		}
		
		UserDTO res=UserRepository.userList.put(newUser.getUsername(),newUser);
		if(res==null) {
			return true;
		}
		return false;
	}

	public boolean userLogin(String username,String password) throws UserNotFoundException, WrongPasswordException {
		boolean isValid;
		
		//Check if username exist
		isValid=UserRepository.userList.containsKey(username);
		if(!isValid) {
			throw new UserNotFoundException("username does not exist!");
		}
		
		//check if password is correct
		isValid=(password.equals(UserRepository.userList.get(username).getPassword()));
		if(!isValid) {
			throw new WrongPasswordException("Password is wrong! Try again");
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
