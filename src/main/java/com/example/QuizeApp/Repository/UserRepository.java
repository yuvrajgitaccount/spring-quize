package com.example.QuizeApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.QuizeApp.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

}