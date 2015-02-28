package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessRoleRefu implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessRoleRefu";

	private java.lang.Integer refuId;
	private java.lang.Integer roleId;

	public BusinessRoleRefu(){
	}

	public BusinessRoleRefu(
		java.lang.Integer refuId
	){
		this.refuId = refuId;
	}

	public void setRefuId(java.lang.Integer value) {
		this.refuId = value;
	}
	
	public java.lang.Integer getRefuId() {
		return this.refuId;
	}
	public void setRoleId(java.lang.Integer value) {
		this.roleId = value;
	}
	
	public java.lang.Integer getRoleId() {
		return this.roleId;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("RefuId",getRefuId())
			.append("RoleId",getRoleId())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRefuId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessRoleRefu == false) return false;
		if(this == obj) return true;
		BusinessRoleRefu other = (BusinessRoleRefu)obj;
		return new EqualsBuilder()
			.append(getRefuId(),other.getRefuId())
			.isEquals();
	}
}

