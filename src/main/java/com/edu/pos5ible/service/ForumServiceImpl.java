package com.edu.pos5ible.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.pos5ible.entity.Content;
import com.edu.pos5ible.entity.Page;
import com.edu.pos5ible.entity.User;
import com.edu.pos5ible.exception.contentException.ContentException;
import com.edu.pos5ible.exception.contentException.TitleException;

@Service("forumService")
public class ForumServiceImpl extends BaseService implements ForumService {

	@Transactional
	public List<Map<String, Object>> showForum(String kw, Page page) throws RuntimeException{
		if (page == null) {
			throw new RuntimeException("page error");
		}
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Content> forums = new ArrayList<Content>();
		if (kw == null || kw.trim().isEmpty() || kw == "") {
			if (page.getType() == 0) {
				forums = forumDao.findForumNum(page);
			}
			if (page.getType() == 1) {
				forums = forumDao.findForumTime(page);
			}
		}else {
			kw.replaceAll("&nbsp", "%");
			kw.replaceAll(",", "%");
			kw.replaceAll("，", "%");
			kw = "%" + kw + "%";
			if (page.getType() == 0) {
				forums = forumDao.findForumByKwNum(kw,page);
			}
			if (page.getType() == 1) {
				forums = forumDao.findForumByKwTime(kw,page);
			}
		}
		if (!(forums.isEmpty())) {
			Map<String, Object> map = new HashMap<String, Object>();
			for (Content content : forums) {
				map.clear();
				String str = content.getContent();
				str.replaceAll("&nbsp", " ");
				str.replaceAll("<br>", " ");
				if (str.length()>20) {
					str.substring(0,18);
					str = str + "...";
					content.setContent(str);
				}
				List<String> listTag = forumDao.findForumTagById(content.getId());
				map.put("content", content);
				map.put("tag", listTag);
				list.add(map);
			}
		}
		return list;
	}

	@Transactional
	public List<Map<String, Object>> showMyForum(Integer userId, Page page) throws RuntimeException{
		if (userId == null) {
			throw new RuntimeException("user is not exist");
		}
		User user = userDao.findUserById(userId);
		if (user == null) {
			throw new RuntimeException("user is not exits");
		}
		List<Content> forums = new ArrayList<Content>();
		if (page.getType() == 0){
			forums = forumDao.findForumByUserIdNum(userId, page);
		}
		if (page.getType() == 1) {
			forums = forumDao.findForumByUserIdTime(userId, page);
		}
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		if (!(forums.isEmpty())) {
			Map<String, Object> map = new HashMap<String, Object>();
			for (Content content : forums) {
				map.clear();
				String str = content.getContent();
				str.replaceAll("&nbsp", " ");
				str.replaceAll("<br>", " ");
				if (str.length()>20) {
					str.substring(0,18);
					str = str + "...";
					content.setContent(str);
				}
				List<String> listTag = forumDao.findForumTagById(content.getId());
				map.put("content", content);
				map.put("tag", listTag);
				list.add(map);
			}
		}
		
		return list;
	}

	@Transactional
	public Map<String, Object> showForumContent(Integer forumId, Integer userId) throws RuntimeException{
		if (forumId == null) {
			throw new RuntimeException("forum error");
		}
		System.out.println(userId);
		Integer isLike = null;
		if (userId != null) {
			isLike = forumDao.findIsLike(userId, forumId);
		}
		if (isLike == null) {
			isLike = 0;
		}
		Content forum = forumDao.findForumById(forumId);
		User user = userDao.findUserById(forum.getUserId());
		String author = user.getUserNick();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isLike", isLike);
		map.put("author", author);
		map.put("forumContent", forum.getContent());
		return map;
	}

	@Transactional
	public Integer addForum(Content forum) throws TitleException, ContentException, RuntimeException {
		Integer status = 1;
		if (forum.getUserId() == null) {
			throw new RuntimeException("user error");
		}
		if (forum.getTitle() == null || forum.getTitle().trim().isEmpty()) {
			throw new TitleException("title is empty");
		}
		if (forum.getContent() == null || forum.getContent().trim().isEmpty()) {
			throw new ContentException("content is empty");
		}
		forumDao.addForum(forum);
		status = 0;
		return status;
	}

	@Transactional
	public Integer isLikeForum(Integer forumId, Integer isLike, Integer userId) throws RuntimeException {
		if (forumId == null || isLike == null || userId == null) {
			throw new RuntimeException("unknown error");
		}
		Integer status = 1;
		Integer likeNum = forumDao.findIsLike(userId, forumId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("forumId", forumId);
		map.put("isLike", isLike);
		if (likeNum == null) {
			forumDao.addIsLike(map);
			likeNum = 0;
		}else {
			forumDao.updateIsLike(map);
		}
		if (likeNum == 0) {
			if (isLike == 1) {
				Integer number = forumDao.findLikeNum(forumId);
				forumDao.alterLikeNum(number+1, forumId);
			}
			if (isLike == 2) {
				Integer number = forumDao.findUnlikeNum(forumId);
				forumDao.alterUnlikeNum(number+1, forumId);
			}
		}
		if (likeNum == 1) {
			if (isLike == 0) {
				Integer number = forumDao.findLikeNum(forumId);
				forumDao.alterLikeNum(number-1, forumId);
			}
			if (isLike == 2) {
				Integer number = forumDao.findLikeNum(forumId);
				forumDao.alterLikeNum(number-1, forumId);
				Integer number2 = forumDao.findUnlikeNum(forumId);
				forumDao.alterUnlikeNum(number2+1, forumId);
			}
		}
		if (likeNum == 2) {
			if (isLike == 0) {
				Integer number = forumDao.findUnlikeNum(forumId);
				forumDao.alterUnlikeNum(number-1, forumId);
			}
			if (isLike == 1) {
				Integer number = forumDao.findLikeNum(forumId);
				forumDao.alterLikeNum(number+1, forumId);
				Integer number1 = forumDao.findUnlikeNum(forumId);
				forumDao.alterUnlikeNum(number1-1, forumId);
			}
		}
		status = 0;
		return status;
	}

	@Transactional
	public void addForumClick(Integer forumId) throws RuntimeException {
		Integer number = forumDao.findClickNum(forumId);
		forumDao.alterClikeNum(number+1, forumId);
	}

}












