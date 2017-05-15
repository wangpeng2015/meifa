package com.spring.mybatics.service;

import com.spring.mybatics.domain.User;

public interface IUserService {
	public User getUserById(int userId);
	
	public int saveUser(User user);
}
