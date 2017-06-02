package com.spring.mybatics.dao;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;

import com.spring.mybatics.domain.Hair_store_income;

public interface IStoreIncomeDao extends CommonDAO<Hair_store_income,Integer>{

	int updateStoreIncomeDay(@Param("danju_storesCode")String danju_storesCode, @Param("danju_price")BigDecimal danju_price);
}
