package com.capgemini.greatoutdoors.util;

import java.util.HashMap;

import com.capgemini.greatoutdoors.dto.AddressDTO;
import com.capgemini.greatoutdoors.dto.UserDTO;

public class UserRepository {
	public static HashMap<String,UserDTO> userList=new HashMap<String,UserDTO>();
	static{
	AddressDTO address1=new AddressDTO("AID"+Math.random()*1000000,"RID"+Math.random()*1000000,"7","Gangapur City","Rajasthan","Udai mod","322201");
	UserDTO user1=new UserDTO("vainktesh","Hello@2020","Admin","vainktesh@gmail.com","7825639812",address1);
	userList.put(user1.getUsername(), user1);
	}
}
