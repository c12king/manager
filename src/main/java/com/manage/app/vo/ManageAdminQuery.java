package com.manage.app.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.Map;
import java.io.Serializable;
import com.manage.app.bean.ManageAdmin;
import com.manage.app.vo.BaseBean;

public class ManageAdminQuery extends BaseBean {
	

	private java.lang.Integer adminId;
	private java.lang.String adminName;
	private java.lang.String adminPassword;
	private java.lang.Integer adminType;

	private Map fieldMap;
	
	public ManageAdminQuery(ManageAdmin manageAdmin) {
		this.adminId = manageAdmin.getAdminId();
		this.adminName = manageAdmin.getAdminName();
		this.adminPassword = manageAdmin.getAdminPassword();
		this.adminType = manageAdmin.getAdminType();
	}
	
	public ManageAdminQuery() {
		
	}	
	
	public java.lang.Integer getAdminId() {
		return this.adminId;
	}
	
	public void setAdminId(java.lang.Integer value) {
		this.adminId = value;
	}
		
	public java.lang.String getAdminName() {
		return this.adminName;
	}
	
	public void setAdminName(java.lang.String value) {
		this.adminName = value;
	}
		
	public java.lang.String getAdminPassword() {
		return this.adminPassword;
	}
	
	public void setAdminPassword(java.lang.String value) {
		this.adminPassword = value;
	}
		
	public java.lang.Integer getAdminType() {
		return this.adminType;
	}
	
	public void setAdminType(java.lang.Integer value) {
		this.adminType = value;
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

