package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class BuseinessTel implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BuseinessTel";

	private java.lang.Integer telId;
	private java.lang.Integer groupId;
	private java.lang.String tel;
	private java.lang.String telName;

	public BuseinessTel(){
	}

	public BuseinessTel(
		java.lang.Integer telId
	){
		this.telId = telId;
	}

	public void setTelId(java.lang.Integer value) {
		this.telId = value;
	}
	
	public java.lang.Integer getTelId() {
		return this.telId;
	}
	public void setGroupId(java.lang.Integer value) {
		this.groupId = value;
	}
	
	public java.lang.Integer getGroupId() {
		return this.groupId;
	}
	public void setTel(java.lang.String value) {
		this.tel = value;
	}
	
	public java.lang.String getTel() {
		return this.tel;
	}
	public void setTelName(java.lang.String value) {
		this.telName = value;
	}
	
	public java.lang.String getTelName() {
		return this.telName;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("TelId",getTelId())
			.append("GroupId",getGroupId())
			.append("Tel",getTel())
			.append("TelName",getTelName())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getTelId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BuseinessTel == false) return false;
		if(this == obj) return true;
		BuseinessTel other = (BuseinessTel)obj;
		return new EqualsBuilder()
			.append(getTelId(),other.getTelId())
			.isEquals();
	}
}

