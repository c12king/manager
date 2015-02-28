package com.manage.app.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.manage.app.bean.ManageModulemenu;

public class ManageModulemenuQuery extends BaseBean {
	

	private java.lang.Integer moduleMenuId;
	private java.lang.Integer moduleId;
	private java.lang.Integer menuId;

	public ManageModulemenuQuery(ManageModulemenu manageModulemenu) {
		this.moduleMenuId = manageModulemenu.getModuleMenuId();
		this.moduleId = manageModulemenu.getModuleId();
		this.menuId = manageModulemenu.getMenuId();
	}
	
	public ManageModulemenuQuery() {
		
	}	
	
	public java.lang.Integer getModuleMenuId() {
		return this.moduleMenuId;
	}
	
	public void setModuleMenuId(java.lang.Integer value) {
		this.moduleMenuId = value;
	}
		
	public java.lang.Integer getModuleId() {
		return this.moduleId;
	}
	
	public void setModuleId(java.lang.Integer value) {
		this.moduleId = value;
	}
		
	public java.lang.Integer getMenuId() {
		return this.menuId;
	}
	
	public void setMenuId(java.lang.Integer value) {
		this.menuId = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

