package com.spring.mybatics.serviceTest;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.haier.result.ServiceResult;
import com.spring.mybatics.dao.ICustomerDAO;
import com.spring.mybatics.domain.Hair_customers;
import com.spring.mybatics.service.ICustomerService;

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
	ICustomerService iCustomerService;
	@Resource
	ICustomerDAO iCustomerDao;
	
	
	/**
	 * 
	 * 保存新的客户
	 */
	@Test
	@Rollback(false)
	public void testSaveCustomer(){
		Hair_customers customer=new Hair_customers();
		customer.setCustomer_name("消费者1");
		customer.setCustomer_isVip("1");//是vip  1级别
		customer.setCustomer_address("山东青岛李沧区");
		customer.setCustomer_code("cu_001");
		customer.setCustomer_money(new BigDecimal(100));
		customer.setCustomer_phoneNumber("18300247761");
		customer.setCustomer_storeCode("001");
		iCustomerService.saveCustomer(customer);
	}
	
	/**
	 * 根据门店查询用户列表
	 * 
	 */
	@Test
	public void testSearchCustomerByStoreCode(){
		String storeCode="001";
		ServiceResult list= iCustomerService.searchCustomerByStoreCode(storeCode);
		System.out.println(list.getResult().toString());
	}
	
	/**
	 * 根据电话信息删除用户
	 */
	@Test
	public void testdeleteCustomerByphoneNumber(){
		String phonenumber="18300247760";
		ServiceResult res=iCustomerService.deleteCustomerByphoneService(phonenumber);
		System.out.println(res);
	}
	
	/**
	 * 根据用户电话更新用户金额
	 */
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
	 * 根据电话更新用户
	 */
	@Test
	@Rollback(false)
	public void testupdatephoneNumber(){
		Hair_customers customer=new Hair_customers();
//		customer.setCustomer_code("002");//设置用户的编码
//		customer.setUpdateTime(new Date());
//		customer.setCustomer_integral(new BigDecimal(300));
//		customer.setCustomer_isVip("1");
		customer.setCustomer_phoneNumber("18300247760");
		customer.setCustomer_storeCode("002");//设置门店编码
		customer.setCustomer_name("张三三");
		ServiceResult money=iCustomerService.updateCustomerByphoneService(customer);
		System.out.println(money.getResult().toString());
	}

}
