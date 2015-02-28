package com.manage.app.vo;

import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.manage.app.bean.BusinessRoleRefu;

public class BusinessRoleRefuQuery extends BaseBean {
	

	private java.lang.Integer refuId;
	private java.lang.Integer roleId;

	private Map fieldMap;
	
	public BusinessRoleRefuQuery(BusinessRoleRefu businessRoleRefu) {
		this.refuId = businessRoleRefu.getRefuId();
		this.roleId = businessRoleRefu.getRoleId();
	}
	
	public BusinessRoleRefuQuery() {
		
	}	
	
	public java.lang.Integer getRefuId() {
		return this.refuId;
	}
	
	public void setRefuId(java.lang.Integer value) {
		this.refuId = value;
	}
		
	public java.lang.Integer getRoleId() {
		return this.roleId;
	}
	
	public void setRoleId(java.lang.Integer value) {
		this.roleId = value;
	}
		
	
	public Map getFieldMap() {
		return this.fieldMap;
	}
	
	public void setFieldMap(Map fieldMap) {
		this.fieldMap = fieldMap;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

