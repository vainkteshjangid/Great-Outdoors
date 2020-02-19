package com.capgemini.greatdoors.dao;

import com.capgemini.greatoutdoors.dto.CartDTO;

public interface CartDao {
	boolean addItemToCart(CartDTO cartDTOObj);
	
	boolean removeItemFromCart(CartDTO cartDTOObj);
}
