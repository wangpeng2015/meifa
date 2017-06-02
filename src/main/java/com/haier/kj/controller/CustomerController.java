package com.haier.kj.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haier.result.ServiceResult;
import com.spring.mybatics.domain.Hair_customers;
import com.spring.mybatics.service.ICustomerService;
import com.spring.mybatics.util.LoginContext;
import com.spring.mybatics.util.LoginContextUtil;


/**
 * 顾客操作controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/customerController")
public class CustomerController {
	
	private static Logger logger = Logger.getLogger(CustomerController.class);

    @Autowired
    private ICustomerService iCustomerService;
    
    /**
     * 增加顾客
     * @param user
     * @return
     * 对应数据库表为 meifa.hair_customers
     */
    @RequestMapping(value="/doSaveCustomer")
    @ResponseBody
    public Object doSaveCustomer(Hair_customers customers,HttpServletRequest request){
    	  logger.info("--------------doSaveCustomer---------------");
    	  //统一声明返回类型
    	  ServiceResult serviceResult=iCustomerService.saveCustomer(customers);
    	  return serviceResult;
     }

    
    /**
     * 根据电话删除顾客
     */
    @RequestMapping(value="/doDelCustomerByPhone")
    @ResponseBody
    public Object doDelCustomerByPhone(@RequestParam("phoneNumber")String phoneNumber){
    	return iCustomerService.deleteCustomerByphoneService(phoneNumber);
    }
    
    /**
     * 根据电话修改顾客信息
     */
    @RequestMapping(value="/doUpdateCustomerByPhone")
    @ResponseBody
    public Object doUpdateCustomerByPhone(Hair_customers customer){
    	return iCustomerService.updateCustomerByphoneService(customer);
    }
    
    /**
     * 根据门店编码查询顾客(门店的)
     */
    @RequestMapping(value="/doSearchStoreCustomer")
    @ResponseBody
    public Object doSearchStoreCustomer(HttpServletRequest request){
    	LoginContext loginContext=LoginContextUtil.getLoginContext(request.getSession());
    	String storeCode=loginContext.getLoginUser().getStoreCode();
    	ServiceResult listCustomer=iCustomerService.searchCustomerByStoreCode(storeCode);
		return listCustomer;
    }
    
}
