package com.tweeter.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tweeter.bo.Tweet;

public interface TweetDao extends CrudRepository<Tweet, Integer>{

	List<Tweet> findByUid(String uid);
	
	

}
