package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessRoleGroup implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessRoleGroup";

	private java.lang.Integer groupId;
	private java.lang.String groupName;
	private java.lang.String groupDesc;

	public BusinessRoleGroup(){
	}

	public BusinessRoleGroup(
		java.lang.Integer groupId
	){
		this.groupId = groupId;
	}

	public void setGroupId(java.lang.Integer value) {
		this.groupId = value;
	}
	
	public java.lang.Integer getGroupId() {
		return this.groupId;
	}
	public void setGroupName(java.lang.String value) {
		this.groupName = value;
	}
	
	public java.lang.String getGroupName() {
		return this.groupName;
	}
	public void setGroupDesc(java.lang.String value) {
		this.groupDesc = value;
	}
	
	public java.lang.String getGroupDesc() {
		return this.groupDesc;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("GroupId",getGroupId())
			.append("GroupName",getGroupName())
			.append("GroupDesc",getGroupDesc())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getGroupId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessRoleGroup == false) return false;
		if(this == obj) return true;
		BusinessRoleGroup other = (BusinessRoleGroup)obj;
		return new EqualsBuilder()
			.append(getGroupId(),other.getGroupId())
			.isEquals();
	}
}

