package com.spring.mybatics.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 
 * 门店收入表
 * @author Administrator
 *
 */
public class Hair_store_income implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4537747505664855758L;
	
	private int storeincomeid;
	private String store_code;//门店编码  外键
	private BigDecimal store_income_day;//门店日营业额
	private BigDecimal store_income_month;//门店月营业额
	private BigDecimal store_income_year;//门店年营业额
	private Date createTime;//创建时间
	private Date updateTime;//更新时间
	
	
	public int getStoreincomeid() {
		return storeincomeid;
	}
	public void setStoreincomeid(int storeincomeid) {
		this.storeincomeid = storeincomeid;
	}
	public String getStore_code() {
		return store_code;
	}
	public void setStore_code(String store_code) {
		this.store_code = store_code;
	}
	
	public BigDecimal getStore_income_day() {
		return store_income_day;
	}
	public void setStore_income_day(BigDecimal store_income_day) {
		this.store_income_day = store_income_day;
	}
	public BigDecimal getStore_income_month() {
		return store_income_month;
	}
	public void setStore_income_month(BigDecimal store_income_month) {
		this.store_income_month = store_income_month;
	}
	public BigDecimal getStore_income_year() {
		return store_income_year;
	}
	public void setStore_income_year(BigDecimal store_income_year) {
		this.store_income_year = store_income_year;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "Hair_store_income [storeincomeid=" + storeincomeid
				+ ", store_code=" + store_code + ", store_income_day="
				+ store_income_day + ", store_income_month="
				+ store_income_month + ", store_income_year="
				+ store_income_year + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}
	
	
}
