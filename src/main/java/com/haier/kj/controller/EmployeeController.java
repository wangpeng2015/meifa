package com.haier.kj.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haier.result.ServiceResult;
import com.spring.mybatics.domain.Hair_employee;
import com.spring.mybatics.service.IUserService;
import com.spring.mybatics.util.LoginContextUtil;


/**
 * 员工信息controller
 * @author wp
 *
 */
@Controller
@RequestMapping(value="/employeeController")
public class EmployeeController{
	
	private static Logger logger = Logger.getLogger(EmployeeController.class);

    /**
     * 注入userService
     */
    @Autowired
    private IUserService userService;

    /**
     * 登录功能
     * 访问方式：localhost:8081/meifa/employeeController/doLogin?userName=王鹏&passWord=123
     * @param user
     * @return
     * 对应数据库表为 meifa.hair_employee
     */
    @RequestMapping(value="/doLogin")
    @ResponseBody
    public Object doLoginMember(Hair_employee user,HttpServletRequest request){
    	  logger.info("--------------login---------------");
    	  logger.info("userName="+user.getUserName()+",PassWord="+user.getPassWord());
    	  //统一声明返回类型
    	  ServiceResult serviceResult=userService.findUserService(user);
    	  Hair_employee resUser=(Hair_employee) serviceResult.getResult();
    	  if(resUser!=null){
    		//保存用户信息到session
    		  LoginContextUtil.writeToSession(request, resUser,resUser.getUserName(),resUser.getUserCode());
    	  }
    	  return serviceResult;
     }
    
    /**
     * 添加人员功能,添加的人员是店员或者店长而不是顾客，顾客的人员信息修改是在顾客表中，hair_customers表
     * 访问方式：localhost:8081/meifa/employeeController/doSave
     * @param user
     * @return
     */
    @RequestMapping(value="/doSave")
    @ResponseBody
    public Object doSaveMember(Hair_employee user){
    	ServiceResult serviceResult=userService.saveUser(user);
    	return serviceResult;
    }
    
    /**
     * 根据员工id删除员工
     * 访问方式：localhost:8081/meifa/employeeController/doDelete?id=4
     * @param user
     * @return
     */
    @RequestMapping(value="doDelete")
    @ResponseBody
    public Object doDelete(Hair_employee user){
    	//统一声明返回类型
  	  	ServiceResult deleteId=userService.deleteUserById(user);
		return deleteId;
    }
    
    /**
     * 根据员工phoneNumber删除员工信息
     * @param user
     * @return
     */
    @RequestMapping(value="/doDeleteByphoneNumber")
    @ResponseBody
    public Object doDeleteByphoneNumber(Hair_employee user){
  	    ServiceResult deleteId=userService.deleteUserByPhoneNService(user);
		return deleteId;
    }
    
    
    /**
     * 查询会员根据电话或者姓名 hair_employee表有些过时，我们单独建立一个表示放客户信息的那就是  hair_customers
     * localhost:8081/meifa/employeeController/doSearchUserByphoneOrName?userName=wangpeng
     */
    @RequestMapping(value="/doSearchUserByphoneOrName")
    @ResponseBody
    public Object doSearchUserByphoneOrName(Hair_employee user){
    	ServiceResult listUser=userService.searchUserByphoneOrNameService(user);
		return listUser;
    }
    
    /**
     * 更新用户根据id
     * 
     * localhost:8081/meifa/employeeController/doUpdateUserById?id=4
     */
    @RequestMapping(value="/doUpdateUserById")
    @ResponseBody
    public Object doUpdateUserById(Hair_employee user){
  	    ServiceResult res=userService.updateUserByIdService(user);
  	    return res;
    }
    
}