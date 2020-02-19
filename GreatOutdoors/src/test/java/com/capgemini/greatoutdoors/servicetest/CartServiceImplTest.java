package com.capgemini.greatoutdoors.servicetest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.greatoutdoors.dto.CartDTO;
import com.capgemini.greatoutdoors.service.CartServiceImpl;

public class CartServiceImplTest {
	CartServiceImpl cart=new CartServiceImpl();
	
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
