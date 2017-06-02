package com.spring.mybatics.dao;

import java.util.List;

import com.spring.mybatics.domain.Hair_danju;

public interface IOrderDao extends CommonDAO<Hair_danju,Integer>{

	List<Hair_danju> getAllOrderDAO();
	
	int updateDanjuConfirm(Hair_danju hair_danju);

}
