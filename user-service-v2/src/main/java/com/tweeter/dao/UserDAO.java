package com.tweeter.dao;
import com.tweeter.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository; 
@Repository
public interface UserDAO extends CrudRepository<User,String>{

}
