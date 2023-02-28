package com.example.QuizeApp.serviceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.QuizeApp.Repository.RoleRepository;
import com.example.QuizeApp.Repository.UserRepository;
import com.example.QuizeApp.model.User;
import com.example.QuizeApp.model.UserRole;
import com.example.QuizeApp.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	

	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	@Override
	public User createUserService(User user, Set<UserRole> userRoles) throws Exception {
		
	     User local= this.userRepository.findByUsername(user.getUsername());
		
	     
	     if (local!=null) {
	    	 
	    	 
	    	 System.out.println("user is alredy exsit");
	    	 throw new Exception("first check user is exsit");
			
		}
		
	     else {
			
	    	 //save the role
	    	 
	    	 for (UserRole userRole : userRoles) {
	    		 
	    		 roleRepository.save(userRole.getRole());
				
			}
	    	 
	    	 
	    	 //get user role and add
	    	 user.getUserRoles().addAll(userRoles);
	    	 
	    	 //save user 
	    	 
	    local =this.userRepository.save(user);
	    	 
	    	 
		}
		
		return  local;
	}


	
	//2nd get byname
	@Override
	public User getName(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsername(username);
	}

}