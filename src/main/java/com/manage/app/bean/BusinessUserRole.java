package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessUserRole implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessUserRole";

	private java.lang.Integer usroId;
	private java.lang.Integer roleId;
	private java.lang.Integer userId;
	private String userName;
	private String roleName;

	public BusinessUserRole(){
	}

	public BusinessUserRole(
		java.lang.Integer usroId
	){
		this.usroId = usroId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setUsroId(java.lang.Integer value) {
		this.usroId = value;
	}
	
	public java.lang.Integer getUsroId() {
		return this.usroId;
	}
	public void setRoleId(java.lang.Integer value) {
		this.roleId = value;
	}
	
	public java.lang.Integer getRoleId() {
		return this.roleId;
	}
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
	
	public java.lang.Integer getUserId() {
		return this.userId;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("UsroId",getUsroId())
			.append("RoleId",getRoleId())
			.append("UserId",getUserId())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getUsroId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessUserRole == false) return false;
		if(this == obj) return true;
		BusinessUserRole other = (BusinessUserRole)obj;
		return new EqualsBuilder()
			.append(getUsroId(),other.getUsroId())
			.isEquals();
	}
}

