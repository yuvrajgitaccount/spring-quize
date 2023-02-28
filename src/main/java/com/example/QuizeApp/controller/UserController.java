package com.example.QuizeApp.controller;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.QuizeApp.model.Role;
import com.example.QuizeApp.model.User;
import com.example.QuizeApp.model.UserRole;
import com.example.QuizeApp.service.UserService;



@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	@Autowired
	private BCryptPasswordEncoder password;
	
	
	@PostMapping("/save")
	
	public  ResponseEntity< User>  creUser(@RequestBody User user) throws Exception
	{
		//bcryte password
		user.setPassword(this.password.encode(user.getPassword()));
		
		//user.setPassword(user.getPassword());
		
		
		Set<UserRole>userRoles=new HashSet<UserRole>();
		
       Role role=new Role();
        role.setRoleId(2L);
       role.setRoleName("NORMAL");


		UserRole userRole=new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		
		
		userRoles.add(userRole);
		
	User user2=	this.service.createUserService(user, userRoles);
		return  ResponseEntity.ok().body( user2);   
		
		//return new  ResponseEntity< User>(user2,HttpStatus.CREATED);
	
		
		
		
	}

}
