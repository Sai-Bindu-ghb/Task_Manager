package com.taskmanager.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


import com.taskmanager.entity.User;
import com.taskmanager.repo.UserRepo;
import com.taskmanager.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	 @Autowired
	 private UserRepo userRepository;

	@Override
	public User registerUser(User user) {
		String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);

        // Default role = USER if not provided
        if (user.getRole() == null) {
            user.setRole("USER");
        }
        return userRepository.save(user);
	}

	@Override
	public User findByEmail(String email) {
		 Optional<User> userOpt = userRepository.findByEmail(email);
	        return userOpt.orElse(null);
	}

   
    
   
    
}
