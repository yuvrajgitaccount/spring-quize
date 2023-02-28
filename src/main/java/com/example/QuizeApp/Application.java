package com.example.QuizeApp;




import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.QuizeApp.model.Role;
import com.example.QuizeApp.model.User;
import com.example.QuizeApp.model.UserRole;
import com.example.QuizeApp.service.UserService;



@SpringBootApplication
public class Application implements CommandLineRunner {

//	@Autowired
//	private UserService service;
//	
//	@Autowired
//	private BCryptPasswordEncoder encoder;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		

	}

}
