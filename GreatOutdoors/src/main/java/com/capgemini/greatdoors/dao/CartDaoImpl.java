package com.capgemini.greatdoors.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.capgemini.greatoutdoors.dto.CartDTO;
import com.capgemini.greatoutdoors.util.CartRepository;
import com.capgemini.greatoutdoors.util.CurrentSessionInfo;

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


	public void displayCartItems(String currentUser) {
		// TODO Auto-generated method stub
		if(CartRepository.cart.containsKey(currentUser)) {
			HashMap<String,CartDTO> cartItems=CartRepository.cart.get(currentUser);
			Set entry=cartItems.entrySet();
			Iterator itr=entry.iterator();
			while(itr.hasNext()) {
				Map.Entry me=(Map.Entry)itr.next();
				CartDTO obj=(CartDTO) me.getValue();
				System.out.println(obj.getUsername()+" "+obj.getProductID()+" "+obj.getQuantity());
			}
		}
		
	}

}
