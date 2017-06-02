package com.spring.mybatics.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haier.result.ServiceResult;
import com.haier.result.exception.BusinessException;
import com.haier.result.exception.ExceptionConstants.BusinessExceptionCode;
import com.spring.mybatics.dao.ICustomerDAO;
import com.spring.mybatics.domain.Hair_customers;
import com.spring.mybatics.service.ICustomerService;


@Service("iCustomerService")
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private ICustomerDAO iCustomerDAO;
	
	@Override
	public ServiceResult saveCustomer(Hair_customers customers) {
		ServiceResult serviceResult=null;
		try {
			serviceResult=new ServiceResult();
			int res=iCustomerDAO.save(customers);
			if(res>0){
				serviceResult.setResult(res);
			}
		} catch (Exception e) {
			throw new BusinessException(BusinessExceptionCode.param_error, "保存客户信息失败!");
		}
		return serviceResult;
	}
	
	/**
	 * 根据门店编码查询门店顾客信息
	 */
	@Override
	public ServiceResult searchCustomerByStoreCode(String storeCode) {
		ServiceResult serviceResult=null;
		if("".equals(storeCode)){
			throw new BusinessException(BusinessExceptionCode.param_error, "请填写门店编码!");
		}
		serviceResult=new ServiceResult();
		List<Hair_customers> list_customer=iCustomerDAO.searchCustomerListByStoreCode(storeCode);
		if(list_customer!=null && list_customer.size()>0){
			serviceResult.setResult(list_customer);
		}
		return serviceResult;
	}

	/**
	 * 根据电话进行用户删除
	 */
	@Override
	public ServiceResult deleteCustomerByphoneService(String phoneNumber) {
		ServiceResult serviceResult=null;
		if("".equals(phoneNumber) || null==phoneNumber){
			throw new BusinessException(BusinessExceptionCode.param_error, "请填写要删除的用户的电话信息!");
		}
		try {
			serviceResult=new ServiceResult();
			int deleId=iCustomerDAO.deleteCustomerByphoneDao(phoneNumber);
			if(deleId==1){
				serviceResult.setResult(deleId);
			}
		} catch (Exception e) {
			throw new BusinessException(BusinessExceptionCode.param_error, "删除客户信息失败!");
		}
		return serviceResult;
	}
	
	/**
	 * 根据电话进行用户信息更新
	 */
	@Override
	public ServiceResult updateCustomerByphoneService(Hair_customers customers) {
		ServiceResult serviceResult=null;
		if("".equals(customers.getCustomer_phoneNumber()) ||  null==customers.getCustomer_phoneNumber()){
			throw new BusinessException(BusinessExceptionCode.param_error, "请填写要删除的用户的电话信息!");
		}
		try {
			serviceResult=new ServiceResult();
			int res=iCustomerDAO.updateCustomerByPhone(customers);
			if(res==1){
				serviceResult.setResult(res);
			}
		} catch (Exception e) {
			throw new BusinessException(BusinessExceptionCode.param_error, "更新客户信息失败!");
		}
		return serviceResult;
	}

}
