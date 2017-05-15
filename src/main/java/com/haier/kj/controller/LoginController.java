package com.haier.kj.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mybatics.domain.User;
import com.spring.mybatics.service.IUserService;


/**
 * 登录controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/loginController")
public class LoginController{
	
	private static Logger logger = Logger.getLogger(LoginController.class);

    /**
     * 注入userService
     */
    @Autowired
    private IUserService iUserService;

    /**
     * 访问方式：localhost:8081/meifa/loginController/doLogin
     * @param user
     * @param request
     * @param userName
     * @param password
     * @return
     * 对应数据库表为
     */
    @RequestMapping(value="/doLogin")
    @ResponseBody
    public ModelAndView saveUser(User user){
    	  logger.info("--------------login---------------");
    	  logger.info("userName="+user.getUserName());
    	  logger.info("userName="+user.getPassWord());
    	  logger.info("userName="+user.getRoles());
		  return null;
     }

}