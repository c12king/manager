package com.manage.app.vo;

import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.manage.app.bean.BusinessRole;

public class BusinessRoleQuery extends BaseBean {
	

	private java.lang.Integer roleId;
	private java.lang.String roleName;
	private java.lang.String roleDesc;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.Integer isSpecial;
	
	private  Integer groupId;

	private Map fieldMap;
	
	private String resourceRightAdd;
	
	public BusinessRoleQuery(BusinessRole businessRole) {
		this.roleId = businessRole.getRoleId();
		this.roleName = businessRole.getRoleName();
		this.roleDesc = businessRole.getRoleDesc();
		this.createTime = businessRole.getCreateTime();
		this.editTime = businessRole.getEditTime();
		this.editor = businessRole.getEditor();
		this.isSpecial = businessRole.getIsSpecial();
		this.groupId = businessRole.getGroupId();
	}
	
	public String getResourceRightAdd() {
		return resourceRightAdd;
	}

	public void setResourceRightAdd(String resourceRightAdd) {
		this.resourceRightAdd = resourceRightAdd;
	}

	public BusinessRoleQuery() {
		
	}	
	
	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public java.lang.Integer getRoleId() {
		return this.roleId;
	}
	
	public void setRoleId(java.lang.Integer value) {
		this.roleId = value;
	}
		
	public java.lang.String getRoleName() {
		return this.roleName;
	}
	
	public void setRoleName(java.lang.String value) {
		this.roleName = value;
	}
		
	public java.lang.String getRoleDesc() {
		return this.roleDesc;
	}
	
	public void setRoleDesc(java.lang.String value) {
		this.roleDesc = value;
	}
		
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
		
	public java.sql.Timestamp getEditTime() {
		return this.editTime;
	}
	
	public void setEditTime(java.sql.Timestamp value) {
		this.editTime = value;
	}
		
	public java.lang.String getEditor() {
		return this.editor;
	}
	
	public void setEditor(java.lang.String value) {
		this.editor = value;
	}
		
	public java.lang.Integer getIsSpecial() {
		return this.isSpecial;
	}
	
	public void setIsSpecial(java.lang.Integer value) {
		this.isSpecial = value;
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

