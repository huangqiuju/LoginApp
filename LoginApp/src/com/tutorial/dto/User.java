package com.tutorial.dto;

import java.io.Serializable;

public class User implements Serializable{
	//add some comments
	//add more comments
	String userId;
	String name;
	
	public User()
	{
		
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	


}
