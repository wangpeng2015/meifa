package com.spring.mybatics.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.mybatics.domain.Hair_customers;

public interface ICustomerDAO  extends CommonDAO<Hair_customers,Integer>{
	
	/**
	 * 根据电话更新客户金钱
	 * @param danju_price
	 * @param danju_id
	 */
	int updateCustomer(@Param("danju_price")BigDecimal danju_price, @Param("customer_phoneNumber")String customer_phoneNumber);
	
	/**
	 * 
	 * 根据id查询出这个用户的金钱
	 * 
	 */
	BigDecimal findCustomerMoneyByPhoneNumber(@Param("customer_phoneNumber")String customer_phoneNumber);

	/**
	 * 根据门店编码查询门店下的客户信息
	 * @param storeCode
	 * @return
	 */
	List<Hair_customers> searchCustomerListByStoreCode(@Param("storeCode")String storeCode);

	/**
	 * 根据电话删除用户信息
	 * @param phoneNumber
	 * @return
	 */
	int deleteCustomerByphoneDao(@Param("phoneNumber")String phoneNumber);
	
	/**
	 * 根据用户电话删除用户信息
	 * @param phoneNumber
	 * @return
	 */
	int updateCustomerByPhone(Hair_customers customers);

}
