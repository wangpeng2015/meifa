package com.spring.mybatics.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户表
 * @author Administrator
 *
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = -8393447995276303795L;

	private Integer id;
    
    private String userName;
    
    private String passWord;
    
    private String email;
    
    private String roles;//角色  0代表客户，1代表店主
    
    private Date createTime;
    
    private Date updateTime;
    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
}