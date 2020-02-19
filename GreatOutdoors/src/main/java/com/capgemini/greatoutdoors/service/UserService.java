package com.capgemini.greatoutdoors.service;

import com.capgemini.greatoutdoors.dto.CartDTO;
import com.capgemini.greatoutdoors.dto.UserDTO;

public interface UserService {
	
	boolean userRegistration(UserDTO newUser);
	
	boolean userLogin(String username,String password);
	
	boolean userLogout();
	
}
