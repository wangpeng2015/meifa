package com.spring.mybatics.dao;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;

import com.spring.mybatics.domain.Hair_employee_dan;

public interface IEmployeeDao extends  CommonDAO<Hair_employee_dan,Integer>{

	int saveEmployeeDanDao(@Param("danju_applicant_id")int danju_applicant_id,@Param("danju_id")int danju_id,@Param("danju_price")BigDecimal danju_price);

}
