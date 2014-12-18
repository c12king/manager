package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessTelGroup implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessTelGroup";

	private java.lang.Integer groupId;
	private java.lang.Integer cityId;
	private java.lang.Integer comId;
	private java.lang.Integer estateId;
	private java.lang.String groupName;
	private java.lang.String memo;

	public BusinessTelGroup(){
	}

	public BusinessTelGroup(
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
	public void setCityId(java.lang.Integer value) {
		this.cityId = value;
	}
	
	public java.lang.Integer getCityId() {
		return this.cityId;
	}
	public void setComId(java.lang.Integer value) {
		this.comId = value;
	}
	
	public java.lang.Integer getComId() {
		return this.comId;
	}
	public void setEstateId(java.lang.Integer value) {
		this.estateId = value;
	}
	
	public java.lang.Integer getEstateId() {
		return this.estateId;
	}
	public void setGroupName(java.lang.String value) {
		this.groupName = value;
	}
	
	public java.lang.String getGroupName() {
		return this.groupName;
	}
	public void setMemo(java.lang.String value) {
		this.memo = value;
	}
	
	public java.lang.String getMemo() {
		return this.memo;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("GroupId",getGroupId())
			.append("CityId",getCityId())
			.append("ComId",getComId())
			.append("EstateId",getEstateId())
			.append("GroupName",getGroupName())
			.append("Memo",getMemo())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getGroupId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessTelGroup == false) return false;
		if(this == obj) return true;
		BusinessTelGroup other = (BusinessTelGroup)obj;
		return new EqualsBuilder()
			.append(getGroupId(),other.getGroupId())
			.isEquals();
	}
}

