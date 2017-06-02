package com.spring.mybatics.serviceTest;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mybatics.dao.IEmployeeDanDao;


@RunWith(SpringJUnit4ClassRunner.class)////表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {
		"classpath:/spring/spring-core.xml",
		"classpath:/spring/spring-mybatis.xml",
		"classpath:/spring/spring-aop.xml"
		})

@Transactional
public class TestEmployeeDaoMybatis {
	
	
	@Resource
	IEmployeeDanDao iEmployeeDanDao;
	
	/**
	 * 保存店员单据
	 * 
	 */
	@Test
	@Rollback(false) //不回滚
	public void testSaveCustomer(){
		int res=iEmployeeDanDao.saveEmployeeDanDao(3,2,new BigDecimal(20));
		System.out.println(res);
	} 

}
