package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class ManageCounty implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "ManageCounty";

	private java.lang.Integer countyId;
	private java.lang.Integer cityId;
	private java.lang.String countyName;
	private java.lang.String countyCode;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public ManageCounty(){
	}

	public ManageCounty(
		java.lang.Integer countyId
	){
		this.countyId = countyId;
	}

	public void setCountyId(java.lang.Integer value) {
		this.countyId = value;
	}
	
	public java.lang.Integer getCountyId() {
		return this.countyId;
	}
	public void setCityId(java.lang.Integer value) {
		this.cityId = value;
	}
	
	public java.lang.Integer getCityId() {
		return this.cityId;
	}
	public void setCountyName(java.lang.String value) {
		this.countyName = value;
	}
	
	public java.lang.String getCountyName() {
		return this.countyName;
	}
	public void setCountyCode(java.lang.String value) {
		this.countyCode = value;
	}
	
	public java.lang.String getCountyCode() {
		return this.countyCode;
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

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("CountyId",getCountyId())
			.append("CityId",getCityId())
			.append("CountyName",getCountyName())
			.append("CountyCode",getCountyCode())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCountyId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ManageCounty == false) return false;
		if(this == obj) return true;
		ManageCounty other = (ManageCounty)obj;
		return new EqualsBuilder()
			.append(getCountyId(),other.getCountyId())
			.isEquals();
	}
}

