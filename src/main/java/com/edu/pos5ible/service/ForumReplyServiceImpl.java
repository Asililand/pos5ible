package com.edu.pos5ible.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.pos5ible.entity.Page;
import com.edu.pos5ible.entity.Reply;

@Service("forumReplyService")
public class ForumReplyServiceImpl extends BaseService implements ForumReplyService {

	@Transactional
	public List<Reply> showReply(Integer commentId, Page page) throws RuntimeException {
		if (commentId == null) {
			throw new RuntimeException("comment error");
		}
		List<Reply> list = new ArrayList<Reply>();
		list = forumReplyDao.findReply(commentId, page);
		return list;
	}

	@Transactional
	public Integer addReply(Integer userId, Reply reply) {
		if (userId == null) {
			throw new RuntimeException("please login");
		}
		if (reply == null) {
			throw new RuntimeException("reply error");
		}
		Integer status = 1;
		forumReplyDao.addReply(userId, reply);
		status = 0;
		return status;
	}

}
