package com.edu.pos5ible.service;

import java.util.List;

import com.edu.pos5ible.entity.Page;
import com.edu.pos5ible.entity.Reply;

public interface ForumReplyService {

	List<Reply> showReply(Integer commentId, Page page) throws RuntimeException;

	Integer addReply(Integer userId, Reply reply);
}
