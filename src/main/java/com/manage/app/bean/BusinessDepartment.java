package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessDepartment implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessDepartment";

	private java.lang.Integer depId;
	private java.lang.String depName;
	private java.lang.String depDesc;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private String orgType;
	private java.lang.Integer orgId;
	private java.lang.String orgName;

	public BusinessDepartment(){
	}

	public BusinessDepartment(
		java.lang.Integer depId
	){
		this.depId = depId;
	}

	public void setDepId(java.lang.Integer value) {
		this.depId = value;
	}
	
	public java.lang.Integer getDepId() {
		return this.depId;
	}
	public void setDepName(java.lang.String value) {
		this.depName = value;
	}
	
	public java.lang.String getDepName() {
		return this.depName;
	}
	public void setDepDesc(java.lang.String value) {
		this.depDesc = value;
	}
	
	public java.lang.String getDepDesc() {
		return this.depDesc;
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
	public void setEditor(java.lang.String value) {
		this.editor = value;
	}
	
	public java.lang.String getEditor() {
		return this.editor;
	}
	public void setOrgType(String value) {
		this.orgType = value;
	}
	
	public String getOrgType() {
		return this.orgType;
	}
	public void setOrgId(java.lang.Integer value) {
		this.orgId = value;
	}
	
	public java.lang.Integer getOrgId() {
		return this.orgId;
	}
	public void setOrgName(java.lang.String value) {
		this.orgName = value;
	}
	
	public java.lang.String getOrgName() {
		return this.orgName;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("DepId",getDepId())
			.append("DepName",getDepName())
			.append("DepDesc",getDepDesc())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.append("OrgType",getOrgType())
			.append("OrgId",getOrgId())
			.append("OrgName",getOrgName())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getDepId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessDepartment == false) return false;
		if(this == obj) return true;
		BusinessDepartment other = (BusinessDepartment)obj;
		return new EqualsBuilder()
			.append(getDepId(),other.getDepId())
			.isEquals();
	}
}

