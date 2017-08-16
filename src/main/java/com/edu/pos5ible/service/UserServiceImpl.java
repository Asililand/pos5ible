package com.edu.pos5ible.service;

import java.sql.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.pos5ible.entity.User;
import com.edu.pos5ible.exception.userException.BirthdayException;
import com.edu.pos5ible.exception.userException.EmailException;
import com.edu.pos5ible.exception.userException.GenderException;
import com.edu.pos5ible.exception.userException.NameException;
import com.edu.pos5ible.exception.userException.OldPasswordException;
import com.edu.pos5ible.exception.userException.PasswordException;
import com.edu.pos5ible.exception.userException.QqException;
import com.edu.pos5ible.exception.userException.UserException;
import com.edu.pos5ible.util.Util;

@Service("userService")
public class UserServiceImpl extends BaseService implements UserService{
	
	@Transactional
	public User login(String name, String password) throws NameException, EmailException, PasswordException {
		
		if (name == null || name.trim().isEmpty()) {
			throw new NameException("the user is empty");
		}
		User user;
		if (name.matches(".com$")) {
			user = userDao.findUserByEmail(name);
			if (user == null) {
				throw new EmailException("the email is not exist");
			}
		}else {
			user = userDao.findUserByNick(name);
			if (user == null) {
				throw new NameException("the user is not exist");
			}
		
		}
		if (password == null || password.trim().isEmpty()) {
			throw new PasswordException("the password is empty");
		}
		if (!(password.equals(user.getPassword()))) {
			throw new PasswordException("the password is error");
		}
		user = userDao.findUserByNick(name);
		if (user.getUserStatus() != 1) {
			throw new EmailException("please verify email");
		}
		String token = new Util().getSaltMD5(UUID.randomUUID().toString());
		user.setToken(token);
		userDao.updateUser(user);
		return user;
	}

	@Transactional
	public User regist(String name, String email, String password)
			throws NameException, EmailException, PasswordException {
		
		if (name == null || name.trim().isEmpty()) {
			throw new NameException("the user is empty");
		}
		if (!(name.matches("^[\\w*\\t*]&") && name.length()<=10 && name.length()>1)) {
			throw new NameException("user just in \"a-zA-Z0-9_\t\"");
		}
		if (userDao.findUserByNick(name) != null) {
			throw new NameException("the user is exist");
		}
		if (email == null || email.trim().isEmpty()) {
			throw new EmailException("the email is empty");
		}
		if (!(email.matches("\\w+@.\\w+[.com]&"))) {
			throw new EmailException("email tpye is error");
		}
		if (userDao.findUserByEmail(email) != null) {
			throw new EmailException("the email is exist");
		}
		if (password == null || password.trim().isEmpty()) {
			throw new PasswordException("the password is empty");
		}
		if (!(password.matches("^[\\w&&[^_]+]&") && password.length()>=8 && password.length()<=20)) {
			throw new PasswordException("password just in \"a-zA-Z0-9\" and length between 8-20");
		}
		User user = new User();
		user.setUserNick(name);
		user.setEmail(email);
		user.setPassword(new Util().getSaltMD5(password).toString());
		userDao.addUser(user);
		user = userDao.findUserByNick(name);
		return user;
	}

	@Transactional
	public Integer alterUser(Integer userId, User user) throws NameException, EmailException, QqException, GenderException, BirthdayException{
		Integer status = 1;
		if (userId != user.getUserId()) {
			throw new RuntimeException("user error");
		}
		String name = user.getUserNick();
		String email = user.getEmail();
		String qq = user.getQq();
		char gender = user.getGender();
		Date birthday = user.getBirthday();
		
		if (name == null || name.trim().isEmpty()) {
			throw new NameException("the user is empty");
		}
		if (!(name.matches("^[\\w*\\t*]&") && name.length()<=10 && name.length()>1)) {
			throw new NameException("user just in \"a-zA-Z0-9_\t\"");
		}
		if (userDao.findUserByNick(name) != null) {
			throw new NameException("the user is exist");
		}
		if (email == null || email.trim().isEmpty()) {
			throw new EmailException("the email is empty");
		}
		if (!(email.matches("\\w+@.\\w+[.com]&"))) {
			throw new EmailException("email tpye is error");
		}
		if (userDao.findUserByEmail(email) != null) {
			throw new EmailException("the email is exist");
		}
		if (qq != null) {
			if (!(qq.matches("^[0-9]+$"))) {
				throw new QqException("the qq number just in \"0-9\"");
			}
		}
		if (gender != '\0') {
			if (gender != 'G' || gender != 'L') {
				throw new GenderException("gender is error");
			}
		}
		if (birthday != null) {
			if (!(birthday.toString().matches("^\\d{4}-\\d{2}-\\d{2}\\t\\d{2}:\\d{2}:\\d{2}&"))) {
				throw new BirthdayException("birthday is error");
			}
		}
		user.setUserId(userId);
		userDao.updateUser(user);
		status = 0;
		return status;
	}
	
	@Transactional
	public boolean checkToken(Integer userId, String token) {
		
		if (token.equals(new Util().getSaltMD5(userDao.findUserById(userId).getToken()))) {
			return true;
		}
		return false;
	}

	@Transactional
	public Integer alterPassword(Integer userId, String oldPassword, String newPassword)
			throws UserException, PasswordException, OldPasswordException {
	
		if (userId == null) {
			throw new RuntimeException("user error");
		}
		Integer status = 1;
		User user = userDao.findUserById(userId);
		if (user == null) {
			throw new UserException("user error");
		}
		if (oldPassword == null || oldPassword.trim().isEmpty()) {
			throw new OldPasswordException("password is empty");
		}
		if (!(new Util().getSaltMD5(oldPassword).toString().equals(user.getPassword()))) {
			throw new OldPasswordException("password is error");
		}
		if (newPassword == null || newPassword.trim().isEmpty()) {
			throw new PasswordException("password is empty");
		}
		if (!(newPassword.matches("^[\\w&&[^_]+]&") && newPassword.length()>=8 && newPassword.length()<=20)) {
			throw new PasswordException("password just in \"a-zA-Z0-9\" and length between 8-20");
		}
		user.setPassword(new Util().getSaltMD5(newPassword).toString());
		userDao.updateUser(user);
		status = 0;
		return status;
	}

	@Transactional
	public Integer alterEmail(Integer userId, String email) throws UserException, PasswordException, EmailException{
		Integer status = 1;
		if (userId == null) {
			throw new RuntimeException("user error");
		}
		User user = userDao.findUserById(userId);
		if (user == null) {
			throw new UserException("user is not exist");
		}
		if (email == null || email.trim().isEmpty()) {
			throw new EmailException("the email is empty");
		}
		if (!(email.matches("\\w+@.\\w+[.com]&"))) {
			throw new EmailException("email tpye is error");
		}
		user.setEmail(email);
		user.setUserStatus(0);
		userDao.updateUser(user);
		status = 0;
		return status;
	}
}




