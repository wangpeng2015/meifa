package com.spring.mybatics.dao;

import org.apache.ibatis.annotations.Param;

import com.spring.mybatics.domain.User;

public interface IUserDao {

    int insert(User record);
    
    User selectByPrimaryKey(@Param("id")Integer id);

	int saveUser(@Param("user")User user);

}
