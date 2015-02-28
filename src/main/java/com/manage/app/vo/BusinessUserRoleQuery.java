package com.manage.app.vo;

import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.manage.app.bean.BusinessUserRole;

public class BusinessUserRoleQuery extends BaseBean {
	

	private java.lang.Integer usroId;
	private java.lang.Integer roleId;
	private java.lang.Integer userId;

	private Map fieldMap;
	
	public BusinessUserRoleQuery(BusinessUserRole businessUserRole) {
		this.usroId = businessUserRole.getUsroId();
		this.roleId = businessUserRole.getRoleId();
		this.userId = businessUserRole.getUserId();
	}
	
	public BusinessUserRoleQuery() {
		
	}	
	
	public java.lang.Integer getUsroId() {
		return this.usroId;
	}
	
	public void setUsroId(java.lang.Integer value) {
		this.usroId = value;
	}
		
	public java.lang.Integer getRoleId() {
		return this.roleId;
	}
	
	public void setRoleId(java.lang.Integer value) {
		this.roleId = value;
	}
		
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
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

