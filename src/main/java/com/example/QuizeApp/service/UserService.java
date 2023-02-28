package com.example.QuizeApp.service;

import java.util.Set;

import com.example.QuizeApp.model.User;
import com.example.QuizeApp.model.UserRole;

public interface UserService {

	
	//post all data
		public User createUserService(User user,Set<UserRole>userRoles) throws Exception;
		
		//get by name
		
		public User getName(String username);
}
