package com.manage.app.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

import com.manage.app.bean.ManageUserFunction;
import com.manage.app.vo.BaseBean;

public class ManageUserFunctionQuery extends BaseBean {
	

	private java.lang.Integer userAuthId;
	private java.lang.Integer functionId;
	private java.lang.Integer userId;
	private java.lang.String functionName;
	private java.lang.Integer menuId;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.String moduleCode;
	private java.lang.String functionCode;

	public ManageUserFunctionQuery(ManageUserFunction manageUserFunction) {
		this.userAuthId = manageUserFunction.getUserAuthId();
		this.functionId = manageUserFunction.getFunctionId();
		this.userId = manageUserFunction.getUserId();
		this.functionName = manageUserFunction.getFunctionName();
		this.menuId = manageUserFunction.getMenuId();
		this.createTime = manageUserFunction.getCreateTime();
		this.editTime = manageUserFunction.getEditTime();
		this.editor = manageUserFunction.getEditor();
		this.moduleCode = manageUserFunction.getModuleCode();
		this.functionCode = manageUserFunction.getFunctionCode();
	}
	
	public ManageUserFunctionQuery() {
		
	}	
	
	public java.lang.String getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(java.lang.String functionCode) {
		this.functionCode = functionCode;
	}

	public java.lang.Integer getUserAuthId() {
		return this.userAuthId;
	}
	
	public void setUserAuthId(java.lang.Integer value) {
		this.userAuthId = value;
	}
		
	public java.lang.Integer getFunctionId() {
		return this.functionId;
	}
	
	public void setFunctionId(java.lang.Integer value) {
		this.functionId = value;
	}
		
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
		
	public java.lang.String getFunctionName() {
		return this.functionName;
	}
	
	public void setFunctionName(java.lang.String value) {
		this.functionName = value;
	}
		
	public java.lang.Integer getMenuId() {
		return this.menuId;
	}
	
	public void setMenuId(java.lang.Integer value) {
		this.menuId = value;
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
		
	public java.lang.String getModuleCode() {
		return this.moduleCode;
	}
	
	public void setModuleCode(java.lang.String value) {
		this.moduleCode = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

