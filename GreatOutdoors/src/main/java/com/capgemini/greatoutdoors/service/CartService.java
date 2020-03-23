package com.capgemini.greatoutdoors.service;

import com.capgemini.greatoutdoors.dto.CartDTO;
import com.capgemini.greatoutdoors.exceptions.ItemNotFoundInCartException;

public interface CartService {

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*****************************************************************************************************************
* Function Name : addItemToCart
* Input Parameters : cartDTOobj
* Return type : boolean
* Description : Add item to the cart
*****************************************************************************************************************/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	boolean addItemToCart(CartDTO cartDTOObj);
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*****************************************************************************************************************
* Function Name : removeItemFromCart
* Input Parameters : cartDTOObj
* Return type : boolean
* Description : Remove an item from cart
 * @throws EmptyCartException 
 * @throws ItemNotFoundInCartException 
*****************************************************************************************************************/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	boolean removeItemFromCart(CartDTO cartDTOObj) throws ItemNotFoundInCartException;
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*****************************************************************************************************************
* Function Name : displayCartItems
* Input Parameters : currentUser
* Return type : void
* Description : Display cart products
*****************************************************************************************************************/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	void displayCartItems(String currentUser);
}
