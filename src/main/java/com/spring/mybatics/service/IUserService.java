package com.spring.mybatics.service;

import com.haier.result.ServiceResult;
import com.spring.mybatics.domain.Hair_employee;

public interface IUserService {
//	public User getUserById(int userId);
	
	public ServiceResult saveUser(Hair_employee user);
	
	/**
	 * 根据用户名和密码查询用户信息
	 * @param user
	 * @return
	 */
	public ServiceResult findUserService(Hair_employee user);
	
	/**
	 * 根据用户id删除用户
	 * @param id
	 * @return
	 */
	public ServiceResult deleteUserById(Hair_employee user);
	
	/**
	 * 根据用户电话删除用户信息
	 * 
	 */
	public ServiceResult deleteUserByPhoneNService(Hair_employee user);

	/**
	 * 根据电话和名称获取用户信息（可能多条）
	 * @param user
	 * @return
	 */
	public ServiceResult searchUserByphoneOrNameService(Hair_employee user);
	
	/**
	 * 根据用户id进行更新
	 * @param user
	 * @return
	 */
	public ServiceResult updateUserByIdService(Hair_employee user);
}
