package com.tweeter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/greeting")
public class WelcomeController {
	
	@GetMapping("/welcome")
	public String welcomeUser() {
		return "Welcome to user portal.";
	}

}
