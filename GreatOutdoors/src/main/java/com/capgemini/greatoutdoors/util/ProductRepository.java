package com.capgemini.greatoutdoors.util;


import java.util.HashMap;

import com.capgemini.greatoutdoors.dto.ProductDTO;

public class ProductRepository {
	public static HashMap<String,ProductDTO> productList=new HashMap<String,ProductDTO>();
	ProductRepository(){
	 productList.put("PR101",new ProductDTO("PR101","Camping LED headlamp",990,"White","NA",1,"Waterproof","Adventure Hut",142));
	 productList.put("PR102",new ProductDTO("PR102","Straight Claw Hammer",369,"Red+Black","0.48 Kg",1,"Camping Hammer","CampingMania pvt. ltd",256));
	 productList.put("PR103",new ProductDTO("PR103","Locking caranabiner",249,"Silver","NA",1,"NA","ZincPro Ltd.",115));
	 productList.put("PR104",new ProductDTO("PR104","Night scope binocular telescope",1500,"Grey","12cmX12cm",1,"NA","Korean Space Tools",147));
	 productList.put("PR105",new ProductDTO("PR105","Golf basic penguin magnetic cap",450,"Blue","NA",2,"NA","Penguin accessories",75));
	 productList.put("PR106",new ProductDTO("PR106","Caiton magnetic golf tee",495,"Red","45 cm",2,"NA","Caiton industries",368));
	 productList.put("PR107",new ProductDTO("PR107","Spride Unisex white turf ball",158,"White","Diameter:15cm",2,"NA","Spride unisex",812));
	 productList.put("PR108",new ProductDTO("PR108","Viper all weather Golf Glove",385,"Black","10cmX15cm",2,"NA","Viper sports ltd.",612));
	 productList.put("PR109",new ProductDTO("PR109","Mountain gear Polar ice screw",3000,"Silver","Length:19cm,Height:1.1 kg",3,"NA","Gipfel",124));
	 productList.put("PR110",new ProductDTO("PR110","Tower Climb Kit",19050,"NA","NA",3,"Top quality Kit","Heapro",23));
	 
	}
}
