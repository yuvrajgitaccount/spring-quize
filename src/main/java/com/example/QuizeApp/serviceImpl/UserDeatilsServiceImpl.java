package com.example.QuizeApp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.QuizeApp.Repository.UserRepository;
import com.example.QuizeApp.model.User;
@Service
public class UserDeatilsServiceImpl implements UserDetailsService {

	
	@Autowired
	private UserRepository userrepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	User user=	this. userrepo.findByUsername(username);
	
	
	if (user==null) {

		
		System.out.println("usere is not found");
		
		throw new UsernameNotFoundException("user is Required !!");
	}
		
		return user;
	}

}
