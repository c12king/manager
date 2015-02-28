package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessRoleEstate implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessRoleEstate";

	private java.lang.Integer roesId;
	private java.lang.Integer rocoId;
	private java.lang.Integer estateId;
	private String estateName;
	
	public BusinessRoleEstate(){
	}

	public BusinessRoleEstate(
		java.lang.Integer roesId
	){
		this.roesId = roesId;
	}

	public String getEstateName() {
		return estateName;
	}

	public void setEstateName(String estateName) {
		this.estateName = estateName;
	}

	public void setRoesId(java.lang.Integer value) {
		this.roesId = value;
	}
	
	public java.lang.Integer getRoesId() {
		return this.roesId;
	}
	public void setRocoId(java.lang.Integer value) {
		this.rocoId = value;
	}
	
	public java.lang.Integer getRocoId() {
		return this.rocoId;
	}
	public void setEstateId(java.lang.Integer value) {
		this.estateId = value;
	}
	
	public java.lang.Integer getEstateId() {
		return this.estateId;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("RoesId",getRoesId())
			.append("RocoId",getRocoId())
			.append("EstateId",getEstateId())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRoesId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessRoleEstate == false) return false;
		if(this == obj) return true;
		BusinessRoleEstate other = (BusinessRoleEstate)obj;
		return new EqualsBuilder()
			.append(getRoesId(),other.getRoesId())
			.isEquals();
	}
}

