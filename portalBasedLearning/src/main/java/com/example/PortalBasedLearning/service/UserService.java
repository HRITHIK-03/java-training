package com.example.PortalBasedLearning.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.portalBasedLearning.entity.UserEntity;
import com.example.portalBasedLearning.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public UserEntity saveUser(UserEntity user) {
		user.setCreatedOn(LocalDateTime.now());
		user.setUpdatedOn(LocalDateTime.now());
		log.info("User saved");
		return userRepository.save(user);

	}

	public UserEntity getUserById(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}

	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}

}
