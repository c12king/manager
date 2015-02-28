package com.manage.app.vo;

import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.manage.app.bean.BusinessRoleGroup;

public class BusinessRoleGroupQuery extends BaseBean {
	

	private java.lang.Integer groupId;
	private java.lang.String groupName;
	private java.lang.String groupDesc;

	private Map fieldMap;
	
	public BusinessRoleGroupQuery(BusinessRoleGroup businessRoleGroup) {
		this.groupId = businessRoleGroup.getGroupId();
		this.groupName = businessRoleGroup.getGroupName();
		this.groupDesc = businessRoleGroup.getGroupDesc();
	}
	
	public BusinessRoleGroupQuery() {
		
	}	
	
	public java.lang.Integer getGroupId() {
		return this.groupId;
	}
	
	public void setGroupId(java.lang.Integer value) {
		this.groupId = value;
	}
		
	public java.lang.String getGroupName() {
		return this.groupName;
	}
	
	public void setGroupName(java.lang.String value) {
		this.groupName = value;
	}
		
	public java.lang.String getGroupDesc() {
		return this.groupDesc;
	}
	
	public void setGroupDesc(java.lang.String value) {
		this.groupDesc = value;
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

