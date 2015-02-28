package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessUserCommunity implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessUserCommunity";

	private java.lang.Integer urcoId;
	private java.lang.Integer userId;
	private java.lang.Integer comId;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;

	public BusinessUserCommunity(){
	}

	public BusinessUserCommunity(
		java.lang.Integer urcoId
	){
		this.urcoId = urcoId;
	}

	public void setUrcoId(java.lang.Integer value) {
		this.urcoId = value;
	}
	
	public java.lang.Integer getUrcoId() {
		return this.urcoId;
	}
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
	
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	public void setComId(java.lang.Integer value) {
		this.comId = value;
	}
	
	public java.lang.Integer getComId() {
		return this.comId;
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

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("UrcoId",getUrcoId())
			.append("UserId",getUserId())
			.append("ComId",getComId())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getUrcoId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessUserCommunity == false) return false;
		if(this == obj) return true;
		BusinessUserCommunity other = (BusinessUserCommunity)obj;
		return new EqualsBuilder()
			.append(getUrcoId(),other.getUrcoId())
			.isEquals();
	}
}

