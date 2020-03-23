package com.capgemini.greatdoors.dao;

import com.capgemini.greatoutdoors.dto.UserDTO;
import com.capgemini.greatoutdoors.exceptions.InvalidUsernameException;
import com.capgemini.greatoutdoors.exceptions.UserNotFoundException;
import com.capgemini.greatoutdoors.exceptions.WrongPasswordException;

public interface UserDao {
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*****************************************************************************************************************
* Function Name : userRegistration
* Input Parameters : newUser
* Return type : boolean
* Description : returns true if registraion is successful else return false
* @throws InvalidUsernameException 
*****************************************************************************************************************/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	boolean userRegistration(UserDTO newUser) throws InvalidUsernameException;
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*****************************************************************************************************************
* Function Name : userLogin
* Input Parameters : username,password
* Return type : boolean
* Description : return true if login is successful else return false
 * @throws UserNotFoundException 
 * @throws WrongPasswordException 
*****************************************************************************************************************/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	boolean userLogin(String username,String password) throws UserNotFoundException, WrongPasswordException;
	
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
