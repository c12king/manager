package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessRoleCommunity implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessRoleCommunity";

	private java.lang.Integer rocoId;
	private java.lang.Integer refuId;
	private java.lang.Integer comId;
	private String comName;

	public BusinessRoleCommunity(){
	}

	public BusinessRoleCommunity(
		java.lang.Integer rocoId
	){
		this.rocoId = rocoId;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public void setRocoId(java.lang.Integer value) {
		this.rocoId = value;
	}
	
	public java.lang.Integer getRocoId() {
		return this.rocoId;
	}
	public void setRefuId(java.lang.Integer value) {
		this.refuId = value;
	}
	
	public java.lang.Integer getRefuId() {
		return this.refuId;
	}
	public void setComId(java.lang.Integer value) {
		this.comId = value;
	}
	
	public java.lang.Integer getComId() {
		return this.comId;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("RocoId",getRocoId())
			.append("RefuId",getRefuId())
			.append("ComId",getComId())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRocoId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessRoleCommunity == false) return false;
		if(this == obj) return true;
		BusinessRoleCommunity other = (BusinessRoleCommunity)obj;
		return new EqualsBuilder()
			.append(getRocoId(),other.getRocoId())
			.isEquals();
	}
}

