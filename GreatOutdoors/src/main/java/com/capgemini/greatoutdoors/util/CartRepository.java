package com.capgemini.greatoutdoors.util;


import java.util.HashMap;

import com.capgemini.greatoutdoors.dto.CartDTO;
import com.capgemini.greatoutdoors.dto.ProductDTO;

public class CartRepository {
	public static HashMap<String,HashMap<String,CartDTO>> cart=new HashMap<String,HashMap<String,CartDTO>>();
}
