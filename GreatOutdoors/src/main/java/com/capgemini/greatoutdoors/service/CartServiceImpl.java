package com.capgemini.greatoutdoors.service;

import com.capgemini.greatdoors.dao.CartDaoImpl;
import com.capgemini.greatoutdoors.dto.CartDTO;
import com.capgemini.greatoutdoors.exceptions.ItemNotFoundInCartException;

public class CartServiceImpl implements CartService {
	CartDaoImpl cart=new CartDaoImpl();
	public boolean addItemToCart(CartDTO cartDTOObj) {
		return cart.addItemToCart(cartDTOObj);
	}

	public boolean removeItemFromCart(CartDTO cartDTOObj) throws ItemNotFoundInCartException {
		return cart.removeItemFromCart(cartDTOObj);
	}

	public void displayCartItems(String currentUser) {
		// TODO Auto-generated method stub
		cart.displayCartItems(currentUser);
		
	}

	public boolean isCartEmpty(CartDTO cartDTOObj) {
		return cart.isCartEmpty(cartDTOObj);
	}

}
