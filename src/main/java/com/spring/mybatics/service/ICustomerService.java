package com.spring.mybatics.service;

import com.haier.result.ServiceResult;
import com.spring.mybatics.domain.Hair_customers;

public interface ICustomerService {

	ServiceResult saveCustomer(Hair_customers customers);

	ServiceResult searchCustomerByStoreCode(String storeCode);

	ServiceResult deleteCustomerByphoneService(String phoneNumber);

	ServiceResult updateCustomerByphoneService(Hair_customers customers);

}
