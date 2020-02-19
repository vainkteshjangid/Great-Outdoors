package com.capgemini.greatdoors.dao;

import com.capgemini.greatoutdoors.dto.UserDTO;

public interface UserDao {
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*****************************************************************************************************************
* Function Name : userRegistration
* Input Parameters : newUser
* Return type : boolean
* Description : returns true if registraion is successful else return false
*****************************************************************************************************************/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	boolean userRegistration(UserDTO newUser);
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*****************************************************************************************************************
* Function Name : userLogin
* Input Parameters : username,password
* Return type : boolean
* Description : return true if login is successful else return false
*****************************************************************************************************************/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	boolean userLogin(String username,String password);
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*****************************************************************************************************************
* Function Name : userLogout
* Input Parameters : void
* Return type : boolean
* Description :  logout active user and return true, else return false
*****************************************************************************************************************/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	boolean userLogout();
	
}
