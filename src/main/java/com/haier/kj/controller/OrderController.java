package com.haier.kj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haier.result.ServiceResult;
import com.spring.mybatics.domain.Hair_danju;
import com.spring.mybatics.service.IOrderService;
import com.spring.mybatics.util.LoginContext;
import com.spring.mybatics.util.LoginContextUtil;

/**
 * 
 * 订单操作controller
 * @author wp
 *
 */
@Controller
@RequestMapping(value="/orderController")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
	
	/**
	 * 
	 * localhost:8081/meifa/orderController/doDealOrder?danju_id=1
	 * 店长处理订单
	 * @return
	 */
	@RequestMapping(value="/doDealOrder")
	@ResponseBody
	public Object doDealorder(Hair_danju danju,HttpServletRequest request){
		LoginContext loginContext=LoginContextUtil.getLoginContext(request.getSession());
		//判断是否是店长
		ServiceResult serviceResult = new ServiceResult();
		if(loginContext!=null){
			if(!"2".equals(loginContext.getSoles().trim())){
				serviceResult.setMessage("抱歉，只有店长有权限审核");
			}else{
				serviceResult=orderService.dealOrderService(danju);
			}
		}else{
			
		}
		return serviceResult;
		
	}
	
	
	/**
	 * 提交保存订单
	 * @param danju
	 * @return
	 */
	@RequestMapping(value="/doRequestSaveOrder")
    @ResponseBody
    public Object doRequestSaveOrder(Hair_danju danju){
		ServiceResult res=orderService.saveDanjuService(danju);
		return res;
	}
	
	
	/**
	 * 
	 * 查询出所有的订单,根据店面的id查询出所在点的订单列表
	 * @return
	 */
	@RequestMapping(value="/doGetOrderList")
    @ResponseBody
    public Object doGetOrderList(){
		ServiceResult list_order =orderService.getAllOrder();
		return list_order;
	}
}
