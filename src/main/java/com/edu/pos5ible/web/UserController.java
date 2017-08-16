package com.edu.pos5ible.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.pos5ible.entity.User;
import com.edu.pos5ible.util.JsonResult;
import com.edu.pos5ible.util.Util;

@Controller
@RequestMapping("/u")
public class UserController extends BaseController{

	@ResponseBody
	@RequestMapping("/l")
	public Object login(String name, String password, HttpServletResponse response) {
		User user = userService.login(name, password);
		Cookie cookie = new Cookie("token",user.getToken());
		Cookie cookie2 = new Cookie("userId",user.getUserId().toString());
		cookie.setPath("/");
		cookie2.setPath("/");
		response.addCookie(cookie);
		response.addCookie(cookie2);
		return new JsonResult(user);
	}
	
	@ResponseBody
	@RequestMapping("/r")
	public Object regist(String name, String email, String password) {
		User user = userService.regist(name, email, password);
		return new JsonResult(user);
	}
	
	@ResponseBody
	@RequestMapping("/a/d")
	public Object alter(User user, HttpServletRequest request) {
		Integer userId = new Util().getUserId(request);
		Integer status = 1;
		status = userService.alterUser(userId, user);
		return new JsonResult(status);
	}
	
	@ResponseBody
	@RequestMapping("/a/p")
	public Object alterPassword(String oldPassword, String newPassword, HttpServletRequest request) {
		Integer userId = new Util().getUserId(request);
		Integer status = 1;
		status = userService.alterPassword(userId, oldPassword, newPassword);
		return new JsonResult(status);
	}
	
	@ResponseBody
	@RequestMapping("/a/e")
	public Object alterEmail(String email, HttpServletRequest request) {
		Integer userId = new Util().getUserId(request);
		Integer status = 1;
		status = userService.alterEmail(userId, email);
		return new JsonResult(status);
	}
}








