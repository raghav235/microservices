package com.tweeter.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tweeter.bo.Tweet;
import com.tweeter.pojo.User;
import com.tweeter.service.TweetService;

@RestController
@RequestMapping("/tweet")
public class TweetController {
	
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	TweetService tweetService;
	
	@PostMapping("/post")
	public Tweet postTweet(@RequestBody Tweet tweet) throws URISyntaxException {
		User user=getUser(tweet.getUid());
		tweet.setUserName(user.getUserName());
		return tweetService.postTweet(tweet);
	}
	
	
	@GetMapping("/getAllTweets")
	public List<Tweet> getAllTweets() {
		return tweetService.getAllTweets();
	}
	
	@GetMapping("/getAllTweets/{uid}")
	public List<Tweet> getAllTweetsForAUser(@PathVariable("uid") String uid) throws URISyntaxException {
		User user=getUser(uid);
		
		if (user==null) {
			return new ArrayList<>();
		}
		List<Tweet> tweets= tweetService.getAllTweets(uid);
		tweets.stream().forEach(e->e.setUserName(user.getUserName()));
		return tweets;
	}
	
	private User getUser(String uid) throws URISyntaxException{
		URI uri= new URI ("http://localhost:8081/user-service/users/getUser/"+uid);
		User user=restTemplate.getForObject(uri, User.class);
		return user;
	}
	
}

