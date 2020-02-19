package com.capgemini.greatoutdoors.servicetest;

import org.junit.Test;
import org.junit.Assert;

import com.capgemini.greatdoors.dao.CartDaoImpl;
import com.capgemini.greatoutdoors.dto.CartDTO;
import com.capgemini.greatoutdoors.service.CartServiceImpl;

public class CartServiceImplTest {
	CartServiceImpl cart=new CartServiceImpl();
	
	@Test
	public void addItemToCartTest() {
		CartDTO cartDTOObj=new CartDTO("vainktesh",""+Math.random()*1000000,"2");
		Assert.assertTrue(cart.addItemToCart(cartDTOObj));
	}
	
	@Test 
	public void removeItemFromCartTest() {
		CartDTO cartDTOObj=new CartDTO("vainktesh",""+Math.random()*1000000,"2");
		Assert.assertTrue(cart.addItemToCart(cartDTOObj));
	}
}
