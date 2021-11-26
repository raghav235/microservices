package com.tweeter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tweeter.dao.UserDAO;

import com.tweeter.pojo.User;
@Component
public class UserService {
    @Autowired
	UserDAO userDAO;
	
	public List<User> getAllUsers() {
		return (List<User>) userDAO.findAll();
	}

	public User saveUser(User user) {
		return userDAO.save(user);
	}

	public Optional<User> getUser(String userId) {
		return userDAO.findById(userId);
	}

}
