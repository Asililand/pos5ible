package com.edu.pos5ible.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.pos5ible.service.BlogService;
import com.edu.pos5ible.service.CheckEmailService;
import com.edu.pos5ible.service.ForumCommentSerivce;
import com.edu.pos5ible.service.ForumReplyService;
import com.edu.pos5ible.service.ForumService;
import com.edu.pos5ible.service.UserService;
import com.edu.pos5ible.util.JsonResult;


public abstract class BaseController {
	
	@Resource
	protected UserService userService;
	
	@Resource
	protected CheckEmailService checkEmailService;
	
	@Resource
	protected BlogService blogService;
	
	@Resource
	protected ForumService forumService;
	
	@Resource
	protected ForumCommentSerivce forumCommentService;
	
	@Resource
	protected ForumReplyService forumReplyService;
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public JsonResult exp(Exception e){
		e.printStackTrace();
		return new JsonResult(e); 
	}
}
