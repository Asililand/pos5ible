package com.edu.pos5ible.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.pos5ible.entity.User;
import com.edu.pos5ible.util.Util;

@Service("checkEmailService")
public class CheckEmailServiceImpl extends BaseService implements CheckEmailService{

	@Transactional
	public boolean checkEmail(String name, String email) {
		if (name != null && email != null) {
			User user = userDao.findUserByNick(name);
			String userEmail = new Util().getSaltMD5(user.getEmail());
			if (email.equals(userEmail)) {
				user.setUserStatus(0);
				userDao.updateUser(user);
				return true;
			}
		}
		return false;
	}

}
