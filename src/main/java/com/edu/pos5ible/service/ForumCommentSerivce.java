package com.edu.pos5ible.service;

import java.util.List;
import java.util.Map;

import com.edu.pos5ible.entity.Comment;
import com.edu.pos5ible.entity.Page;

public interface ForumCommentSerivce {

	List<Map<String, Object>> showComment(Integer forumId, Page page, Integer userId) throws RuntimeException;

	Integer alterLike(Integer commentId, Integer isLike, Integer userId) throws RuntimeException;

	Integer addComment(Comment comment, Integer userId) throws RuntimeException;
}
