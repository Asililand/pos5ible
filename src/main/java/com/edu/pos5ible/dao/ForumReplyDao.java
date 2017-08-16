package com.edu.pos5ible.dao;

import java.util.List;

import com.edu.pos5ible.entity.Page;
import com.edu.pos5ible.entity.Reply;

public interface ForumReplyDao {

	List<Reply> findReply(Integer commentId, Page page);

	void addReply(Integer userId, Reply reply);

}
