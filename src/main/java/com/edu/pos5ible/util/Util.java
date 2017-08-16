package com.edu.pos5ible.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;

public class Util {

	private static final String salt = "com.edu.pos5ible";
	/*
	 * 封装加密算法
	 * codec的md5Hex是线程安全的加密算法
	 */
	public String getSaltMD5(String data) {
		
		return DigestUtils.md5Hex(data+salt);
	}
	
	public Integer getUserId(HttpServletRequest request) {
		Integer userId = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("userId".equals(cookie.getName())){
				userId = Integer.valueOf(cookie.getValue());
			}
		}
		return userId;
	}
}
