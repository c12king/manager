package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessRoleMenu implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessRoleMenu";

	private java.lang.Integer romeId;
	private java.lang.Integer roleId;
	private java.lang.Integer menuId;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.Integer no;

	public BusinessRoleMenu(){
	}

	public BusinessRoleMenu(
		java.lang.Integer romeId
	){
		this.romeId = romeId;
	}

	public void setRomeId(java.lang.Integer value) {
		this.romeId = value;
	}
	
	public java.lang.Integer getRomeId() {
		return this.romeId;
	}
	public void setRoleId(java.lang.Integer value) {
		this.roleId = value;
	}
	
	public java.lang.Integer getRoleId() {
		return this.roleId;
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
	public void setNo(java.lang.Integer value) {
		this.no = value;
	}
	
	public java.lang.Integer getNo() {
		return this.no;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("RomeId",getRomeId())
			.append("RoleId",getRoleId())
			.append("MenuId",getMenuId())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.append("No",getNo())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRomeId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessRoleMenu == false) return false;
		if(this == obj) return true;
		BusinessRoleMenu other = (BusinessRoleMenu)obj;
		return new EqualsBuilder()
			.append(getRomeId(),other.getRomeId())
			.isEquals();
	}
}

