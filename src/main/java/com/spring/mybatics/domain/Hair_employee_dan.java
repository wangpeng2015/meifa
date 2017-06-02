package com.spring.mybatics.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 
 * 店员和单据的关系表
 * @author Administrator
 *
 */
public class Hair_employee_dan implements Serializable{
	
	private static final long serialVersionUID = -2294266007291695210L;
	
	private int empDan_id;
	private int employee_id;//雇员的id
	private int employee_danjuID;//雇员的单号
	private BigDecimal employee_money;//雇员产生金额
	private Date employee_createTime;//产生时间
	
	
	public int getEmpDan_id() {
		return empDan_id;
	}
	public void setEmpDan_id(int empDan_id) {
		this.empDan_id = empDan_id;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	
	public BigDecimal getEmployee_money() {
		return employee_money;
	}
	public void setEmployee_money(BigDecimal employee_money) {
		this.employee_money = employee_money;
	}
	public int getEmployee_danjuID() {
		return employee_danjuID;
	}
	public void setEmployee_danjuID(int employee_danjuID) {
		this.employee_danjuID = employee_danjuID;
	}
	public Date getEmployee_createTime() {
		return employee_createTime;
	}
	public void setEmployee_createTime(Date employee_createTime) {
		this.employee_createTime = employee_createTime;
	}
	@Override
	public String toString() {
		return "Hair_employee_dan [empDan_id=" + empDan_id + ", employee_id="
				+ employee_id + ", employee_danjuID=" + employee_danjuID
				+ ", employee_money=" + employee_money
				+ ", employee_createTime=" + employee_createTime + "]";
	}
	
	
}
