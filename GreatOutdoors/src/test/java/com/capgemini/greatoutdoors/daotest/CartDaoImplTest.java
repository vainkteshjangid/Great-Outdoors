package com.capgemini.greatoutdoors.daotest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.greatdoors.dao.CartDaoImpl;
import com.capgemini.greatoutdoors.dto.CartDTO;

public class CartDaoImplTest {
CartDaoImpl cart=new CartDaoImpl();
	
	@Test
	public void addItemToCartTest() {
		CartDTO cartDTOObj=new CartDTO("vainktesh",""+Math.random()*1000000,"2");
		Assertions.assertTrue(cart.addItemToCart(cartDTOObj));
	}
	
	@Test 
	public void removeItemFromCartTest() {
		CartDTO cartDTOObj=new CartDTO("vainktesh",""+Math.random()*1000000,"2");
		Assertions.assertTrue(cart.addItemToCart(cartDTOObj));
	}

}
