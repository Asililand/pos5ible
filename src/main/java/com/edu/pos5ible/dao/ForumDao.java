package com.edu.pos5ible.dao;

import java.util.List;
import java.util.Map;

import com.edu.pos5ible.entity.Content;
import com.edu.pos5ible.entity.Page;

public interface ForumDao {

	List<Content> findForumTime(Page page);
	
	List<Content> findForumNum(Page page);
	
	List<Content> findForumByKwTime(String kw, Page page);
	
	List<Content> findForumByKwNum(String kw, Page page);
	
	List<Content> findForumByUserIdTime(Integer forumUserId, Page page);
	
	List<Content> findForumByUserIdNum(Integer forumUserId, Page page);
	
	Content findForumById(Integer id);

	Integer findIsLike(Integer userId, Integer forumId);

	void addForum(Content forum);

	void addIsLike(Map<String, Object> map);

	void updateIsLike(Map<String, Object> map);

	Integer findClickNum(Integer forumId);
	
	Integer findLikeNum(Integer forumId);
	
	Integer findUnlikeNum(Integer forumId);
	
	void alterLikeNum(Integer number, Integer forumId);
	
	void alterUnlikeNum(Integer number, Integer forumId);
	
	void alterClikeNum(Integer number, Integer forumId);

	List<String> findForumTagById(Integer id);
}
