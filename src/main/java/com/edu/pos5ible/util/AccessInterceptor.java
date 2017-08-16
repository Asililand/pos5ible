package com.edu.pos5ible.util;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.edu.pos5ible.dao.UserDao;
import com.edu.pos5ible.service.UserService;

@Component
public class AccessInterceptor implements HandlerInterceptor{

	@Resource
	private UserDao userDao;
	
	@Resource
	private UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Cookie[] cookies = request.getCookies();
		JsonResult jr = new JsonResult();
		if (cookies != null) {
			Integer userId = null;
			String token = null;
			for (Cookie cookie : cookies) {
				if ("userId".equals(cookie.getName())) {
					userId = Integer.parseInt(cookie.getValue());
				}
				if ("token".equals(cookie.getName())) {
					token = cookie.getValue();
				}
			}
			if (userId == null) {
				jr.setState(1);
				jr.setMessage("please login");
				response.getWriter().println(jr);
				return false;
			}
			if (userId != null && token == null) {
				jr.setState(1);
				jr.setMessage("login check error");
				response.getWriter().println(jr);
				return false;
			}
			if (userId != null && token != null) {
				if (userService.checkToken(userId, token)) {
					return true;
				}
				jr.setState(1);
				jr.setMessage("login in other client");
				return false;
			}
		}
		jr.setState(1);
		jr.setMessage("unknown error");
		response.getWriter().println(jr);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
