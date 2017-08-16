package com.edu.pos5ible.dao;

import java.util.List;
import java.util.Map;

import com.edu.pos5ible.entity.Comment;
import com.edu.pos5ible.entity.Page;

public interface ForumCommentDao {

	List<Comment> findCommentById(Integer forumId, Page page);

	Integer findIsLike(Integer userId, Integer commentId);

	void addIsLike(Map<String, Integer> map);

	void updateIsLike(Map<String, Integer> map);

	Integer findLikeNum(Integer commentId);
	
	Integer findUnikeNum(Integer commentId);
	
	void alterLikeNum(Integer number, Integer commentId);
	
	void alterUnikeNum(Integer number, Integer commentId);

	void addComment(Integer userId, Integer id, String commentContent);

}
