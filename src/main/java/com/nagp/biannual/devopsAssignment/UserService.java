package com.nagp.biannual.devopsAssignment;


import org.springframework.stereotype.Service;



@Service("UserService")
public class UserService {
	
	private static String userName= "Himanshi";
	
	
	public String getUser()
	{
	
		return userName;
	}

}
