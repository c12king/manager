package com.manage.app.vo;

import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.manage.app.bean.BusinessRoleMenu;

public class BusinessRoleMenuQuery extends BaseBean {
	

	private java.lang.Integer romeId;
	private java.lang.Integer roleId;
	private java.lang.Integer menuId;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.Integer no;

	private Map fieldMap;
	
	public BusinessRoleMenuQuery(BusinessRoleMenu businessRoleMenu) {
		this.romeId = businessRoleMenu.getRomeId();
		this.roleId = businessRoleMenu.getRoleId();
		this.menuId = businessRoleMenu.getMenuId();
		this.createTime = businessRoleMenu.getCreateTime();
		this.editTime = businessRoleMenu.getEditTime();
		this.editor = businessRoleMenu.getEditor();
		this.no = businessRoleMenu.getNo();
	}
	
	public BusinessRoleMenuQuery() {
		
	}	
	
	public java.lang.Integer getRomeId() {
		return this.romeId;
	}
	
	public void setRomeId(java.lang.Integer value) {
		this.romeId = value;
	}
		
	public java.lang.Integer getRoleId() {
		return this.roleId;
	}
	
	public void setRoleId(java.lang.Integer value) {
		this.roleId = value;
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
		
	public java.lang.Integer getNo() {
		return this.no;
	}
	
	public void setNo(java.lang.Integer value) {
		this.no = value;
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

