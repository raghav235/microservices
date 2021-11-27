package com.tweeter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tweeter.bo.Tweet;
import com.tweeter.dao.TweetDao;

@Component
public class TweetService {

	@Autowired
	TweetDao tweetDao;
	
	public Tweet postTweet(Tweet tweet) {
		return tweetDao.save(tweet);
	}

	public List<Tweet> getAllTweets() {
		
		return (List<Tweet>) tweetDao.findAll();
	}

	public List<Tweet> getAllTweets(String uid) {
		
		return tweetDao.findByUid(uid);
	}
	
	

}
