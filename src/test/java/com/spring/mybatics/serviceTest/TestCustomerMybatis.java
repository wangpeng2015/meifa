package com.spring.mybatics.serviceTest;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mybatics.dao.ICustomerDao;

/**
 * 
 * 顾客
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)////表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {
		"classpath:/spring/spring-core.xml",
		"classpath:/spring/spring-mybatis.xml",
		"classpath:/spring/spring-aop.xml"
		})

@Transactional
public class TestCustomerMybatis {
	
	
	@Resource
	ICustomerDao iCustomerDao;
	
	@Test
	@Rollback(false) //不回滚
	public void testupdateCustomer(){
		iCustomerDao.updateCustomer(new BigDecimal(20),"18300247760");
	} 
	
	/**
	 * 查询电话为这个的客户
	 */
	@Test
	public void getMoneyByPhoneNumber(){
		BigDecimal money=iCustomerDao.findCustomerMoneyByPhoneNumber("18300247760");
		System.out.println(money);
	}
	
	/**
	 * 根据电话查询客户
	 */
//	@Test
	/*public void testupdatephoneNumberByID(){
		BigDecimal money=iCustomerDao.findCustomerMoneyByPhoneNumber("18300247760");
		System.out.println(money);
	}*/

}
