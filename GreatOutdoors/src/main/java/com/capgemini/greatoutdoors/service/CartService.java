package com.capgemini.greatoutdoors.service;

import com.capgemini.greatoutdoors.dto.CartDTO;

public interface CartService {

	boolean addItemToCart(CartDTO cartDTOObj);
	
	boolean removeItemFromCart(CartDTO cartDTOObj);
}
