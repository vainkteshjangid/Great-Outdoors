package com.capgemini.greatoutdoors.service;


import com.capgemini.greatdoors.dao.UserDaoImpl;
import com.capgemini.greatoutdoors.dto.UserDTO;

public class UserServiceImpl implements UserService {
	UserDaoImpl user=new UserDaoImpl();

	public boolean userRegistration(UserDTO newUser) {
		
		return user.userRegistration(newUser);
	}

	public boolean userLogin(String username,String password) {
		return user.userLogin(username, password);
	}

	public boolean userLogout() {
		return user.userLogout();
	}

}
