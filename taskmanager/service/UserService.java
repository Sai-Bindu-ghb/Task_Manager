package com.taskmanager.service;

import com.taskmanager.entity.User;

public interface UserService {
	
	

	 User registerUser(User user);         
	 User findByEmail(String email); 
}
