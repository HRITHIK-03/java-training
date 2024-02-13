package com.example.LearningPortal.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LearningPortal.Entity.User;
import com.example.LearningPortal.Repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		user.setCreatedOn(LocalDateTime.now());
		user.setUpdatedOn(LocalDateTime.now());
		return userRepository.save(user);

	}

	public User getUserById(long userId) {
		return userRepository.findById(userId).orElse(null);
	}

}
