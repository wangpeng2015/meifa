package com.spring.mybatics.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.mybatics.domain.Hair_employee;

public interface IUserDao extends CommonDAO<Hair_employee,Integer>{

	/**
	 * 根据电话删除用户信息
	 * @param phoneNumber
	 * @return
	 */
	int deleteUserByPhoneNDAO(String phoneNumber);
	
	/**
	 * 根据电话或者姓名查询用户信息
	 * @param user
	 * @return
	 */
	List<Hair_employee> findByParamsByphoneOrNameService(@Param("entity")Hair_employee user);

}
