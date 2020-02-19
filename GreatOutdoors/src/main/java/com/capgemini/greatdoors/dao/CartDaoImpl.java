package com.capgemini.greatdoors.dao;

import java.util.HashMap;

import com.capgemini.greatoutdoors.dto.CartDTO;
import com.capgemini.greatoutdoors.util.CartRepository;

public class CartDaoImpl implements CartDao {

	public boolean addItemToCart(CartDTO cartDTOObj) {
		String username=cartDTOObj.getUsername();
		String productID=cartDTOObj.getProductID();
		if(CartRepository.cart.containsKey(username)){
			CartRepository.cart.get(username).put(productID, cartDTOObj);
		}
		else {
			HashMap<String,CartDTO> cartItems=new HashMap<String,CartDTO>();
			cartItems.put(productID,cartDTOObj);
			CartRepository.cart.put(username, cartItems);
		}
		
		if(CartRepository.cart.get(username).containsKey(productID)) {
			return true;
		}
		else {
			return false;
		}
	}

	
	public boolean removeItemFromCart(CartDTO cartDTOObj) {
		String username=cartDTOObj.getUsername();
		String productID=cartDTOObj.getProductID();
		CartRepository.cart.get(username).remove(productID);
		if(!CartRepository.cart.get(username).containsKey(productID)) {
			return true;
		}
		else {
			return false;
		}
	}

}
