package com.spring.mybatics.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.haier.result.ServiceResult;
import com.haier.result.exception.BusinessException;
import com.haier.result.exception.ExceptionConstants.BusinessExceptionCode;
import com.spring.mybatics.dao.ICustomerDao;
import com.spring.mybatics.dao.IEmployeeDao;
import com.spring.mybatics.dao.IOrderDao;
import com.spring.mybatics.dao.IStoreIncomeDao;
import com.spring.mybatics.dao.IStoresDao;
import com.spring.mybatics.domain.Hair_danju;
import com.spring.mybatics.service.IOrderService;


@Service("orderService")
public class OrderServiceImpl implements IOrderService{

	/**
	 * 
	 * 订单
	 */
	@Resource
	private IOrderDao iOrderDao;
	/**
	 * 客户vip
	 */
	@Resource
	private ICustomerDao iCustomerDao;
	/**
	 * 员工与单据
	 */
	@Resource
	private IEmployeeDao iEmployeeDao;
	/**
	 * 门店
	 */
	@Resource
	private IStoresDao iStoresDao;
	/**
	 * 门店收入
	 */
	@Resource
	private IStoreIncomeDao iStoreIncomeDao;
	
	/**
	 * 
	 * 查询所有单据
	 */
	@Override
	public ServiceResult getAllOrder() {
		ServiceResult serviceResult=new ServiceResult();
		//查询订单
		List<Hair_danju> listDanju=iOrderDao.getAllOrderDAO();
		if(listDanju!=null && listDanju.size()>0){
			serviceResult.setResult(listDanju);
		}else{
			serviceResult.setMessage("没有查询到订单信息");
		}
		return serviceResult;
	}

	/**
	 * 
	 * 保存单据
	 * 
	 */
	@Override
	public ServiceResult saveDanjuService(Hair_danju danju) {
		ServiceResult serviceResult=new ServiceResult();
		if(equals(danju.getDanju_applicant_id()<=0)){
			throw new BusinessException(BusinessExceptionCode.param_error, "请填写申请人信息");
		}
		if(equals(danju.getDanju_applicant_id()<=0)){
			throw new BusinessException(BusinessExceptionCode.param_error, "请填写消费金额");
		}
		try {
			int id=iOrderDao.save(danju);
			if(id==1){
				serviceResult.setResult(id);
			}else{
				serviceResult.setResult(id);
				serviceResult.setMessage("保存单据失败!");
			}
			return serviceResult;
		} catch (Exception e) {
			throw new BusinessException(BusinessExceptionCode.param_error, "保存单据失败!");
		}
		
	}

	/**
	 * 
	 * 处理订单
	 * 
	 */
	@Override
	public ServiceResult dealOrderService(Hair_danju danju) {
		ServiceResult serviceResult=new ServiceResult();
		//判断订单是否存在
		if(danju.getDanju_id()<=0){
			throw new BusinessException(BusinessExceptionCode.param_error, "请确认订单是否存在");
		}
		//更新审核字段
		int isSave=0;
		try {
			danju.setDanju_isConfirm("已审核");
			isSave=iOrderDao.updateDanjuConfirm(danju);
		} catch (Exception e) {
			throw new BusinessException(BusinessExceptionCode.param_error, "审核失败请重新审核");
		}
		
		if(isSave==1){
			//判断如果是vip,则进行金额减法 vip   不等于0就是会员
			if(!"0".equals(danju.getDanju_isVip().trim())){
				//更新客户的金钱
				BigDecimal money=iCustomerDao.findCustomerMoneyByPhoneNumber(danju.getCustomer_phone());
				double resDouble=money.subtract(danju.getDanju_price()).doubleValue();
				if(resDouble<=0){
//					throw new BusinessException(BusinessExceptionCode.param_error, "余额不足,剩余:"+money+"元");
					serviceResult.setResultCode("300");
					serviceResult.setResult(0);
					serviceResult.setMessage("余额不足,剩余:"+money+"元");
				}
				//更新用户金钱
				try {
					int uu=iCustomerDao.updateCustomer(new BigDecimal(Double.valueOf(resDouble)),danju.getCustomer_phone());
					if(uu==1){
						//保存店员和单据价格字段
						int empdan=iEmployeeDao.saveEmployeeDanDao(danju.getDanju_applicant_id(),danju.getDanju_id(),danju.getDanju_price());
						if(empdan==1){
							//更新店的金额
							int income=iStoreIncomeDao.updateStoreIncomeDay(danju.getDanju_storesCode(),danju.getDanju_price());
							serviceResult.setResultCode("200");
							serviceResult.setResult(income);
							serviceResult.setMessage("success");
						}
					}
				} catch (Exception e) {
					serviceResult.setResultCode("300");
					serviceResult.setResult(0);
					serviceResult.setMessage("处理订单失败!");
					return serviceResult;
				}
			}
		}
		return serviceResult;
	}

}
