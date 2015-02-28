package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class ManageFunction implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "ManageFunction";

	private java.lang.Integer functionId;
	private java.lang.Integer menuId;
	private java.lang.String functionName;
	private java.lang.String functionDesc;
	private java.lang.String functionCode;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.String menuName;
	private java.lang.String name;

	public java.lang.String getMenuName() {
		return menuName;
	}

	public void setMenuName(java.lang.String menuName) {
		this.menuName = menuName;
	}

	public ManageFunction(){
	}

	public ManageFunction(
		java.lang.Integer functionId
	){
		this.functionId = functionId;
	}

	public void setFunctionId(java.lang.Integer value) {
		this.functionId = value;
	}
	
	public java.lang.Integer getFunctionId() {
		return this.functionId;
	}
	public void setMenuId(java.lang.Integer value) {
		this.menuId = value;
	}
	
	public java.lang.Integer getMenuId() {
		return this.menuId;
	}
	public void setFunctionName(java.lang.String value) {
		this.functionName = value;
	}
	
	public java.lang.String getFunctionName() {
		return this.functionName;
	}
	public void setFunctionDesc(java.lang.String value) {
		this.functionDesc = value;
	}
	
	public java.lang.String getFunctionDesc() {
		return this.functionDesc;
	}
	public void setFunctionCode(java.lang.String value) {
		this.functionCode = value;
	}
	
	public java.lang.String getFunctionCode() {
		return this.functionCode;
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

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("FunctionId",getFunctionId())
			.append("MenuId",getMenuId())
			.append("FunctionName",getFunctionName())
			.append("FunctionDesc",getFunctionDesc())
			.append("FunctionCode",getFunctionCode())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getFunctionId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ManageFunction == false) return false;
		if(this == obj) return true;
		ManageFunction other = (ManageFunction)obj;
		return new EqualsBuilder()
			.append(getFunctionId(),other.getFunctionId())
			.isEquals();
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}
	
}

