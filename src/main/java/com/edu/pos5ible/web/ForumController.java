package com.edu.pos5ible.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.pos5ible.entity.Content;
import com.edu.pos5ible.entity.Page;
import com.edu.pos5ible.util.JsonResult;
import com.edu.pos5ible.util.Util;

@Controller
@RequestMapping("/f")
public class ForumController extends BaseController{

	@ResponseBody
	@RequestMapping("")
	public Object showForum(String kw, Page page) {
		List<Map<String, Object>> forums = forumService.showForum(kw,page);
		return new JsonResult(forums);
	}
	
	@ResponseBody
	@RequestMapping("/mf") 
	public Object showMyForum(Page page, HttpServletRequest request) { 
		Integer userId = new Util().getUserId(request);
		List<Map<String, Object>> myForums = forumService.showMyForum(userId, page);
		return new JsonResult(myForums);
	}
	
	@ResponseBody
	@RequestMapping("/fc")
	public Object showForumContent(Integer forumId, HttpServletRequest request) {
		Integer userId = new Util().getUserId(request);
		Map<String, Object> forum = forumService.showForumContent(forumId, userId);
		return new JsonResult(forum);
	}
	
	@ResponseBody
	@RequestMapping("/af")
	public Object addForum(Content forum, HttpServletRequest request) {
		Integer userId = new Util().getUserId(request);
		forum.setUserId(userId);
		Integer status = forumService.addForum(forum);
		return new JsonResult(status);
	}
	
	@ResponseBody
	@RequestMapping("/ilf")
	public Object addForumLike(Integer forumId, Integer isLike, HttpServletRequest request) {
		Integer userId = new Util().getUserId(request);
		Integer status = forumService.isLikeForum(forumId, isLike, userId);
		System.out.println(userId);
		return new JsonResult(status);
	}
	
	@ResponseBody
	@RequestMapping("/afc")
	public void addForumClick(Integer forumId) {
		forumService.addForumClick(forumId);
	}
}






