package com.capgemini.greatoutdoors.service;

import com.capgemini.greatdoors.dao.CartDaoImpl;
import com.capgemini.greatoutdoors.dto.CartDTO;

public class CartServiceImpl implements CartService {
	CartDaoImpl cart=new CartDaoImpl();
	public boolean addItemToCart(CartDTO cartDTOObj) {
		return cart.addItemToCart(cartDTOObj);
	}

	public boolean removeItemFromCart(CartDTO cartDTOObj) {
		return cart.removeItemFromCart(cartDTOObj);
	}

}
