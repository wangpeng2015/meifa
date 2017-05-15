package com.spring.mybatics.serviceTest;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.spring.mybatics.domain.User;
import com.spring.mybatics.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)////表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {
		"classpath:/spring/spring-core.xml",
		"classpath:/spring/spring-mybatis.xml",
		"classpath:/spring/spring-aop.xml"
		})

@Transactional
public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
	@Autowired
	private IUserService userService;

	@Test
//	@Rollback(false) //不回滚
//	@Rollback(true) //回滚
	public void test1() {
		User user=new User();
		user.setPassWord("password");
		user.setUserName("wagpeng");
		user.setRoles("1");
		logger.info(JSON.toJSONString(user));
		//保存
		int ss=userService.saveUser(user);
	}
}
