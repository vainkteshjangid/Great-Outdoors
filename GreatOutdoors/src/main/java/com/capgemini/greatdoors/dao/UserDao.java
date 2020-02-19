package com.capgemini.greatdoors.dao;

import com.capgemini.greatoutdoors.dto.UserDTO;

public interface UserDao {
	boolean userRegistration(UserDTO newUser);
	
	boolean userLogin(String username,String password);
	
	boolean userLogout();
	
}
