package com.spring.mybatics.dao;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;

import com.spring.mybatics.domain.Hair_customers;

public interface ICustomerDao  extends CommonDAO<Hair_customers,Integer>{
	
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

}
