package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class ManageUserFunction implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "ManageUserFunction";

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
	
	public ManageUserFunction(){
	}

	public java.lang.String getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(java.lang.String functionCode) {
		this.functionCode = functionCode;
	}

	public ManageUserFunction(
		java.lang.Integer userAuthId
	){
		this.userAuthId = userAuthId;
	}

	public void setUserAuthId(java.lang.Integer value) {
		this.userAuthId = value;
	}
	
	public java.lang.Integer getUserAuthId() {
		return this.userAuthId;
	}
	public void setFunctionId(java.lang.Integer value) {
		this.functionId = value;
	}
	
	public java.lang.Integer getFunctionId() {
		return this.functionId;
	}
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
	
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	public void setFunctionName(java.lang.String value) {
		this.functionName = value;
	}
	
	public java.lang.String getFunctionName() {
		return this.functionName;
	}
	public void setMenuId(java.lang.Integer value) {
		this.menuId = value;
	}
	
	public java.lang.Integer getMenuId() {
		return this.menuId;
	}
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
	
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	public void setEditTime(java.sql.Timestamp value) {
		this.editTime = value;
	}
	
	public java.sql.Timestamp getEditTime() {
		return this.editTime;
	}
	public void setEditor(java.lang.String value) {
		this.editor = value;
	}
	
	public java.lang.String getEditor() {
		return this.editor;
	}
	public void setModuleCode(java.lang.String value) {
		this.moduleCode = value;
	}
	
	public java.lang.String getModuleCode() {
		return this.moduleCode;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("UserAuthId",getUserAuthId())
			.append("FunctionId",getFunctionId())
			.append("UserId",getUserId())
			.append("FunctionName",getFunctionName())
			.append("MenuId",getMenuId())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.append("ModuleId",getModuleCode())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getUserAuthId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ManageUserFunction == false) return false;
		if(this == obj) return true;
		ManageUserFunction other = (ManageUserFunction)obj;
		return new EqualsBuilder()
			.append(getUserAuthId(),other.getUserAuthId())
			.isEquals();
	}
}

