package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class ManageModulemenu implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "ManageModulemenu";

	private java.lang.Integer moduleMenuId;
	private java.lang.Integer moduleId;
	private java.lang.Integer menuId;
	private java.lang.String name;

	public ManageModulemenu(){
	}

	public ManageModulemenu(
		java.lang.Integer moduleMenuId
	){
		this.moduleMenuId = moduleMenuId;
	}

	public void setModuleMenuId(java.lang.Integer value) {
		this.moduleMenuId = value;
	}
	
	public java.lang.Integer getModuleMenuId() {
		return this.moduleMenuId;
	}
	public void setModuleId(java.lang.Integer value) {
		this.moduleId = value;
	}
	
	public java.lang.Integer getModuleId() {
		return this.moduleId;
	}
	public void setMenuId(java.lang.Integer value) {
		this.menuId = value;
	}
	
	public java.lang.Integer getMenuId() {
		return this.menuId;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("ModuleMenuId",getModuleMenuId())
			.append("ModuleId",getModuleId())
			.append("MenuId",getMenuId())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getModuleMenuId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ManageModulemenu == false) return false;
		if(this == obj) return true;
		ManageModulemenu other = (ManageModulemenu)obj;
		return new EqualsBuilder()
			.append(getModuleMenuId(),other.getModuleMenuId())
			.isEquals();
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}
	
}

