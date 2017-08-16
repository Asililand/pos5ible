package com.edu.pos5ible.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.pos5ible.entity.Comment;
import com.edu.pos5ible.entity.Page;

@Service("forumCommentService")
public class ForumCommentServiceImpl extends BaseService implements ForumCommentSerivce {

	@Transactional
	public List<Map<String, Object>> showComment(Integer forumId, Page page, Integer userId) throws RuntimeException{
		if (forumId == null) {
			throw new RuntimeException("forum error");
		}
		if (page == null) {
			throw new RuntimeException("page error");
		}
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Comment> listComment = forumCommentDao.findCommentById(forumId, page);
		if (!(listComment.isEmpty())) {
			Map<String, Object> map = new HashMap<String, Object>();
			Integer isLike = null;
			Integer commentUserId = null;
			for (Comment comment : listComment) {
				map.clear();
				if (userId == null) {
					isLike = 0;
				}else {
					isLike = forumCommentDao.findIsLike(userId, comment.getCommentId());
				}
				commentUserId = comment.getCommentUserId();
				String commenter = userDao.findUserById(commentUserId).getUserNick();
				if (isLike == null) {
					isLike = 0;
				}
				map.put("isLike", isLike);
				map.put("commenter", commenter);
				map.put("comment", comment);
				list.add(map);
			}
		}
		return null;
	}

	@Transactional
	public Integer alterLike(Integer commentId, Integer isLike, Integer userId) throws RuntimeException {
		if (commentId == null){
			throw new RuntimeException("comment error");
		}
		if (userId == null) {
			throw new RuntimeException("please login");
		}
		if (isLike == null) {
			throw new RuntimeException("servlet error");
		}
		Integer status = 1;
		Integer likeNum = forumCommentDao.findIsLike(userId, commentId);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("userId", userId);
		map.put("commentId", commentId);
		map.put("isLike", isLike);
		if (likeNum == null) {
			likeNum = 0;
			forumCommentDao.addIsLike(map);
		}else {
			forumCommentDao.updateIsLike(map);
		}
		if (likeNum == 0) {
			if (isLike == 1) {
				Integer number = forumDao.findLikeNum(commentId);
				forumDao.alterLikeNum(number+1, commentId);
			}
			if (isLike == 2) {
				Integer number = forumDao.findUnlikeNum(commentId);
				forumDao.alterUnlikeNum(number+1, commentId);
			}
		}
		if (likeNum == 1) {
			if (isLike == 0) {
				Integer number = forumDao.findLikeNum(commentId);
				forumDao.alterLikeNum(number-1, commentId);
			}
			if (isLike == 2) {
				Integer number = forumDao.findLikeNum(commentId);
				forumDao.alterLikeNum(number-1, commentId);
				Integer number2 = forumDao.findUnlikeNum(commentId);
				forumDao.alterUnlikeNum(number2+1, commentId);
			}
		}
		if (likeNum == 2) {
			if (isLike == 0) {
				Integer number = forumDao.findUnlikeNum(commentId);
				forumDao.alterUnlikeNum(number-1, commentId);
			}
			if (isLike == 1) {
				Integer number = forumDao.findLikeNum(commentId);
				forumDao.alterLikeNum(number+1, commentId);
				Integer number1 = forumDao.findUnlikeNum(commentId);
				forumDao.alterUnlikeNum(number1-1, commentId);
			}
		}
		status = 0;
		return status;
	}

	@Transactional
	public Integer addComment(Comment comment, Integer userId) throws RuntimeException {
		if (userId == null) {
			throw new RuntimeException("please login");
		}
		if (comment == null) {
			throw new RuntimeException("comment error");
		}
		Integer status = 1;
		forumCommentDao.addComment(userId, comment.getId(), comment.getCommentContent());
		status = 0;
		return status;
	}

}
















