package com.capgemini.greatoutdoors.service;


import com.capgemini.greatdoors.dao.UserDaoImpl;
import com.capgemini.greatoutdoors.dto.UserDTO;
import com.capgemini.greatoutdoors.exceptions.InvalidUsernameException;
import com.capgemini.greatoutdoors.exceptions.UserNotFoundException;
import com.capgemini.greatoutdoors.exceptions.WrongPasswordException;

public class UserServiceImpl implements UserService {
	UserDaoImpl user=new UserDaoImpl();

	public boolean userRegistration(UserDTO newUser) throws InvalidUsernameException {
		
		return user.userRegistration(newUser);
	}

	public boolean userLogin(String username,String password) throws UserNotFoundException, WrongPasswordException {
		return user.userLogin(username, password);
	}

	public boolean userLogout() {
		return user.userLogout();
	}

}
