package com.spring.mybatics.serviceTest;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.haier.result.ServiceResult;
import com.spring.mybatics.dao.IOrderDao;
import com.spring.mybatics.domain.Hair_danju;
import com.spring.mybatics.service.IOrderService;


@RunWith(SpringJUnit4ClassRunner.class)////表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {
		"classpath:/spring/spring-core.xml",
		"classpath:/spring/spring-mybatis.xml",
		"classpath:/spring/spring-aop.xml"
		})

@Transactional
public class TestOrderMybatis {
	
	@Resource
	private IOrderService orderService;
	@Resource
	private IOrderDao iOrderDao;
	
	@Test
	public void testGetList(){
		ServiceResult listOrder=orderService.getAllOrder();
		
		@SuppressWarnings("unchecked")
		List<Hair_danju> listDanju=(List<Hair_danju>) listOrder.getResult();
		if(listDanju!=null && listDanju.size()>0){
			System.out.println(listDanju.size());
		}else{
			System.out.println(listDanju);
		}
		
		
	}
	
	
	@Test
	@Rollback(false) //不回滚
	public void testSaveOrder(){
		Hair_danju danju=new Hair_danju();
		danju.setDanju_applicant("zhangsan");
		danju.setDanju_applicant_id(2);
		danju.setDanju_deal("lisi");
		danju.setDanju_deal_code("004");
		danju.setDanju_name("剪发");
		danju.setDanju_price(new BigDecimal(20));
		danju.setDanju_message("精剪一次");
		danju.setDanju_storesCode("001");
		orderService.saveDanjuService(danju);
	}
	
	@Test
	@Rollback(false)
	public void testUpdateDanjuConfirm(){
		Hair_danju danju=new Hair_danju();
		danju.setDanju_id(1);
		danju.setDanju_isConfirm("已审核");
		iOrderDao.updateDanjuConfirm(danju);
	}
	

}
