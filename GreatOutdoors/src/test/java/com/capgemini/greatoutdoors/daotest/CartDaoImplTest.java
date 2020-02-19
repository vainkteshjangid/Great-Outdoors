package com.capgemini.greatoutdoors.daotest;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.greatdoors.dao.CartDaoImpl;
import com.capgemini.greatoutdoors.dto.CartDTO;

public class CartDaoImplTest {
CartDaoImpl cart=new CartDaoImpl();
	
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
