package com.spring.mybatics.service;

import com.haier.result.ServiceResult;
import com.spring.mybatics.domain.Hair_danju;

public interface IOrderService {
	
	public ServiceResult getAllOrder();

	
	/**
	 * 保存单据
	 * @param danju
	 * @return
	 */
	public ServiceResult saveDanjuService(Hair_danju danju);

	/**
	 * 处理订单
	 * @param danju
	 * @return
	 */
	public ServiceResult dealOrderService(Hair_danju danju);

}
