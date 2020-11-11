package com.spring.mybatics.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.spring.mybatics.domain.PageBean;
import org.springframework.stereotype.Service;

import com.haier.result.ServiceResult;
import com.haier.result.exception.BusinessException;
import com.haier.result.exception.ExceptionConstants.BusinessExceptionCode;
import com.spring.mybatics.dao.IUserDao;
import com.spring.mybatics.domain.Hair_employee;
import com.spring.mybatics.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao iUserDao;

	@Override
	public ServiceResult saveUser(Hair_employee user) {
		ServiceResult serviceResult=new ServiceResult();
		//保存
		try{
			int id=iUserDao.save(user);
			if(id==1){
				serviceResult.setResult(id);
			}else{
				serviceResult.setMessage("保存失败,请重试");
				serviceResult.setResult(id);
			}
			return serviceResult;
		}catch (Exception e) {
			throw new BusinessException(BusinessExceptionCode.param_error, "已存在手机或者理发门店没有选择，请重试");
		}

	}

	/**
	 * 根据用户名和密码查询用户，登录使用
	 * @param user
	 * @return
	 */
	@Override
	public ServiceResult findUserService(Hair_employee user) {
		if(user.getUserName()==null || user.getUserName().trim()==""){
			throw new BusinessException(BusinessExceptionCode.login_null_username, "用户名不能为空");
		}
		if(user.getPassWord()==null || user.getPassWord().trim()==""){
			throw new BusinessException(BusinessExceptionCode.login_null_password, "密码不能为空");
		}
		PageBean pageCond=new PageBean();
		ServiceResult serviceResult=new ServiceResult();
		List<Hair_employee> users=iUserDao.findByParams(user,pageCond);
		if(user!=null && users.size()>0){
			serviceResult.setResult(users.get(0));
		}else{
			throw new BusinessException(BusinessExceptionCode.no_user, "没有该用户");
		}
		return serviceResult;

	}

	/**
	 * 根据用户的id删除用户信息
	 *
	 */
	public ServiceResult deleteUserById(Hair_employee user){
		ServiceResult serviceResult=new ServiceResult();
		if(user==null || user.getId() < 0){
			throw new BusinessException(BusinessExceptionCode.param_error, "请选择要删除的用户");
		}
		try {
			int id=iUserDao.delete(user.getId());
			if(id==1){
				serviceResult.setResult(id);
			}else{
				serviceResult.setMessage("删除失败");
				serviceResult.setResult(id);
			}
			return serviceResult;
		} catch (Exception e) {
			throw new BusinessException(BusinessExceptionCode.param_error, "确认是否有此条信息");
		}
	}


	/**
	 * 根据用户的电话删除用户信息
	 *
	 */
	@Override
	public ServiceResult deleteUserByPhoneNService(Hair_employee user) {
		ServiceResult serviceResult=new ServiceResult();
		if(user==null || user.getPhoneNumber().trim()==""){
			throw new BusinessException(BusinessExceptionCode.param_error, "请选择要删除的用户");
		}
		try {
			int res= iUserDao.deleteUserByPhoneNDAO(user.getPhoneNumber());
			if(res==1){
				serviceResult.setResult(res);
			}else{
				serviceResult.setMessage("删除失败");
				serviceResult.setResult(res);
			}
			return serviceResult;
		} catch (Exception e) {
			throw new BusinessException(BusinessExceptionCode.param_error, "确认是否有此条信息");
		}

	}

	/**
	 * 根据电话和姓名查询用户信息
	 *
	 */
	@Override
	public ServiceResult searchUserByphoneOrNameService(Hair_employee user) {
		ServiceResult serviceResult=new ServiceResult();
		if(user.getUserName()==null && user.getPhoneNumber()==null){
			throw new BusinessException(BusinessExceptionCode.param_error, "请输入要查询的用户姓名或者电话信息");
		}
		List<Hair_employee> listUser=null;
		try {
			listUser=iUserDao.findByParamsByphoneOrNameService(user);
		} catch (Exception e) {
			throw new BusinessException(BusinessExceptionCode.param_error, "查询出错!");
		}
		if(listUser!=null && listUser.size()>0){
			serviceResult.setResult(listUser);
		}else{
			throw new BusinessException(BusinessExceptionCode.no_user, "没有查询到符合条件的用户");
		}
		return serviceResult;
	}

	/**
	 * 根据用户的id进行更新操作
	 *
	 */
	@Override
	public ServiceResult updateUserByIdService(Hair_employee user) {
		ServiceResult serviceResult=new ServiceResult();
		if(user==null || user.getId()<0){
			throw new BusinessException(BusinessExceptionCode.param_error, "请选择要修改的用户");
		}
		try {
			int res=iUserDao.update(user);
			if(res==1){
				serviceResult.setResult(res);
			}else{
				serviceResult.setMessage("修改失败");
				serviceResult.setResult(res);
			}
			return serviceResult;
		} catch (Exception e) {
			throw new BusinessException(BusinessExceptionCode.param_error, "更新出错!");
		}

	}


}
