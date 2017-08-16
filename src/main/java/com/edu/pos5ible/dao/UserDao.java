package com.edu.pos5ible.dao;

import java.util.List;

import com.edu.pos5ible.entity.Page;
import com.edu.pos5ible.entity.User;

public interface UserDao {

	void addUser(User user);
	
	User findUserByNick(String userNick);
	
	User findUserByEmail(String email);
	
	User findUserById(Integer userId);
	
	void updateUser(User user);

	List<Integer> findFollow(Integer userId, Page page);
	
	Integer followerCount(Integer followId);

}
