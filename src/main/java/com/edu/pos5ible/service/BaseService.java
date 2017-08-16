package com.edu.pos5ible.service;

import javax.annotation.Resource;

import com.edu.pos5ible.dao.BlogDao;
import com.edu.pos5ible.dao.BlogReplyDao;
import com.edu.pos5ible.dao.ForumCommentDao;
import com.edu.pos5ible.dao.BlogCommentDao;
import com.edu.pos5ible.dao.ForumDao;
import com.edu.pos5ible.dao.ForumReplyDao;
import com.edu.pos5ible.dao.UserDao;

public abstract class BaseService {

	@Resource
	protected UserDao userDao;
	
	@Resource
	protected BlogCommentDao blogCommentDao;
	
	@Resource
	protected BlogReplyDao blogReplyDao;
	
	@Resource
	protected BlogDao blogDao;
	
	@Resource
	protected ForumDao forumDao;
	
	@Resource
	protected ForumCommentDao forumCommentDao;
	
	@Resource
	protected ForumReplyDao forumReplyDao;
}
