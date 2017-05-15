package com.spring.mybatics.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.mybatics.dao.IUserDao;
import com.spring.mybatics.domain.User;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;
	/*public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userDao.selectByPrimaryKey(userId);
	}*/

	public User getUserById(int userId) {
		return this.userDao.selectByPrimaryKey(userId);
	}

	@Override
	public int saveUser(User user) {
		 int ss=userDao.saveUser(user);
		 return ss;
	}

}
