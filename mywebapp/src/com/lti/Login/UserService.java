package com.lti.Login;

import java.util.*;

public class UserService {
	
	private List<User> users;
	
	public UserService() {	 
		users = new ArrayList<User>();
		users.add(new User("Mayuri","123",true));
		users.add(new User("Sonali","345",true));
		users.add(new User("Grishma","789",false));
		users.add(new User("Akankshya","1011",false));
	}
	
	public boolean isValidUser(String username,String password){
		
		for(User str:users){
			if(str.getUsername().equals(username))
				if(str.getPassword().equals(password))
					if(str.isAllowed())
					return true;
		}
		return false;
		
	}
}
