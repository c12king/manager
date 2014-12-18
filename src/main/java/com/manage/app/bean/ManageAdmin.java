package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class ManageAdmin implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "ManageAdmin";

	private java.lang.Integer adminId;
	private java.lang.String adminName;
	private java.lang.String adminPassword;
	private java.lang.Integer adminType;

	public ManageAdmin(){
	}

	public ManageAdmin(
		java.lang.Integer adminId
	){
		this.adminId = adminId;
	}

	public void setAdminId(java.lang.Integer value) {
		this.adminId = value;
	}
	
	public java.lang.Integer getAdminId() {
		return this.adminId;
	}
	public void setAdminName(java.lang.String value) {
		this.adminName = value;
	}
	
	public java.lang.String getAdminName() {
		return this.adminName;
	}
	public void setAdminPassword(java.lang.String value) {
		this.adminPassword = value;
	}
	
	public java.lang.String getAdminPassword() {
		return this.adminPassword;
	}
	public void setAdminType(java.lang.Integer value) {
		this.adminType = value;
	}
	
	public java.lang.Integer getAdminType() {
		return this.adminType;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("AdminId",getAdminId())
			.append("AdminName",getAdminName())
			.append("AdminPassword",getAdminPassword())
			.append("AdminType",getAdminType())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getAdminId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ManageAdmin == false) return false;
		if(this == obj) return true;
		ManageAdmin other = (ManageAdmin)obj;
		return new EqualsBuilder()
			.append(getAdminId(),other.getAdminId())
			.isEquals();
	}
}

