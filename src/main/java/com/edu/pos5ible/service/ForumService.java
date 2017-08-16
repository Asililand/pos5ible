package com.edu.pos5ible.service;

import java.util.List;
import java.util.Map;

import com.edu.pos5ible.entity.Content;
import com.edu.pos5ible.entity.Page;

public interface ForumService {

	List<Map<String, Object>> showForum(String kw, Page page) throws RuntimeException;

	List<Map<String, Object>> showMyForum(Integer userId, Page page) throws RuntimeException;

	Map<String, Object> showForumContent(Integer forumId, Integer userId) throws RuntimeException;

	Integer addForum(Content forum) throws RuntimeException;

	Integer isLikeForum(Integer forumId, Integer isLike, Integer userId) throws RuntimeException;

	void addForumClick(Integer forumId) throws RuntimeException;
}
