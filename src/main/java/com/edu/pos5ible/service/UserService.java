package com.edu.pos5ible.service;

import com.edu.pos5ible.entity.User;
import com.edu.pos5ible.exception.userException.BirthdayException;
import com.edu.pos5ible.exception.userException.EmailException;
import com.edu.pos5ible.exception.userException.GenderException;
import com.edu.pos5ible.exception.userException.NameException;
import com.edu.pos5ible.exception.userException.OldPasswordException;
import com.edu.pos5ible.exception.userException.PasswordException;
import com.edu.pos5ible.exception.userException.QqException;
import com.edu.pos5ible.exception.userException.UserException;

/**
*  业务层接口
*  声明软件业务功能方法
*/
public interface UserService {

	/**
	 * 登录功能方法
	 * @param name 登录名
	 * @param password 登录密码
	 * @return 登录成功时返回用户
	 * @throw 用户名错误
	 * @throw 密码错误
	 */
	User login(String name, String password) throws NameException,EmailException,PasswordException;
	
	User regist(String name, String email, String password) throws NameException,EmailException,PasswordException;
	
	boolean checkToken(Integer userId, String token);
	
	Integer alterUser(Integer userId, User user) throws NameException, EmailException, QqException, GenderException, BirthdayException;

	Integer alterPassword(Integer userId, String oldPassword, String newPassword) throws UserException, PasswordException, OldPasswordException;
	
	Integer alterEmail(Integer userId, String email) throws UserException, PasswordException, EmailException;
	
}
