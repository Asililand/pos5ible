package com.edu.pos5ible.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.pos5ible.entity.Comment;
import com.edu.pos5ible.entity.Page;
import com.edu.pos5ible.util.JsonResult;
import com.edu.pos5ible.util.Util;

@Controller
@RequestMapping("/fc")
public class ForumCommentController extends BaseController{

	@ResponseBody
	@RequestMapping("")
	public Object showForumComment(Integer forumId, Page page, HttpServletRequest request) {
		Integer userId = new Util().getUserId(request);
		List<Map<String, Object>> list = forumCommentService.showComment(forumId, page, userId);
		return new JsonResult(list);
	}
	
	@ResponseBody
	@RequestMapping("/al")
	public Object addLike(Integer commentId, Integer isLike, HttpServletRequest request) {
		Integer userId = new Util().getUserId(request);
		Integer status = 1;
		status = forumCommentService.alterLike(commentId, isLike, userId);
		return new JsonResult(status);
	}
	
	@ResponseBody
	@RequestMapping("/ac")
	public Object addComment(Comment comment, HttpServletRequest request) {
		Integer userId = new Util().getUserId(request);
		Integer status = 1;
		status = forumCommentService.addComment(comment, userId);
		return new JsonResult(status);
	}
}









