package com.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.entity.User;
import com.taskmanager.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	 @PostMapping("/register")
	 public String registerUser(@RequestBody User user) {
	        User existingUser = userService.findByEmail(user.getEmail());

	        if (existingUser != null) {
	            return "Email already registered!";
	        }

	        userService.registerUser(user);
	        return "User registered successfully!";
	    }

	  @PostMapping("/login")
	 public Object loginUser(@RequestBody User loginUser) {
	        User savedUser = userService.findByEmail(loginUser.getEmail());

	        if (savedUser == null) {
	            return "Invalid Email!";
	        }

	        boolean passwordMatch = BCrypt.checkpw(loginUser.getPassword(), savedUser.getPassword());

	        if (!passwordMatch) {
	            return "Invalid Password!";
	        }

	        return savedUser; // returning user object after successful login
	    }
	  
	  @GetMapping("/email/{email}")
	    public Object getUserByEmail(@PathVariable String email) {
	        User user = userService.findByEmail(email);
	        if (user == null) {
	            return "User not found!";
	        }
	        return user;
	    }
}
