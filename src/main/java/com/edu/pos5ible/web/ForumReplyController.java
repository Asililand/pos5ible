package com.edu.pos5ible.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.pos5ible.entity.Page;
import com.edu.pos5ible.entity.Reply;
import com.edu.pos5ible.util.JsonResult;
import com.edu.pos5ible.util.Util;

@Controller
@RequestMapping("/fr")
public class ForumReplyController extends BaseController{

	@ResponseBody
	@RequestMapping("")
	public Object showReply(Integer commentId, Page page) {
		List<Reply> list = forumReplyService.showReply(commentId, page);
		return new JsonResult(list);
	}
	
	@ResponseBody
	@RequestMapping("/ar")
	public Object addReply(Reply reply, HttpServletRequest request) {
		Integer userId = new Util().getUserId(request);
		Integer status = 1;
		status = forumReplyService.addReply(userId, reply);
		return new JsonResult(status);
	}
}






