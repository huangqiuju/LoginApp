package com.tutorial.service;

import java.util.HashMap;

import com.tutorial.dto.User;

public class LoginService {
	HashMap<String, String> users=new HashMap<String, String>();
	
	public LoginService()
	{
		//simulating populating database
		users.put("JohnDow", "John Dow");
		users.put("qhuang", "qiuju huang");
		
	}
	
	//simulating authentication of password
	public boolean authenticate(String userId, String password)
	{
		if ((password!="")&&(password.trim()!=""))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//simulating retrieving data from database
	public User getUserDetails(String id)
	{
		User user=new User();
		user.setUserId(id);
		user.setName((String)users.get(id));
		return user;
	}

}
