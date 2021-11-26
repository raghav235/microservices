package com.tweeter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweeter.pojo.User;
import com.tweeter.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	

	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user){
		return userService.saveUser(user);
	}
	
	@GetMapping("/getUser/{id}")
	public User getUser(@PathVariable("id") String userId){
		return userService.getUser(userId).get();
	}
}

