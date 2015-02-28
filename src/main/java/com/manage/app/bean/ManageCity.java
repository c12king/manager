package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class ManageCity implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "ManageCity";

	private java.lang.Integer cityId;
	private java.lang.Integer provinceId;
	private java.lang.String cityName;
	private java.lang.String cityCode;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public ManageCity(){
	}

	public ManageCity(
		java.lang.Integer cityId
	){
		this.cityId = cityId;
	}

	public void setCityId(java.lang.Integer value) {
		this.cityId = value;
	}
	
	public java.lang.Integer getCityId() {
		return this.cityId;
	}
	public void setProvinceId(java.lang.Integer value) {
		this.provinceId = value;
	}
	
	public java.lang.Integer getProvinceId() {
		return this.provinceId;
	}
	public void setCityName(java.lang.String value) {
		this.cityName = value;
	}
	
	public java.lang.String getCityName() {
		return this.cityName;
	}
	public void setCityCode(java.lang.String value) {
		this.cityCode = value;
	}
	
	public java.lang.String getCityCode() {
		return this.cityCode;
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
			.append("CityId",getCityId())
			.append("ProvinceId",getProvinceId())
			.append("CityName",getCityName())
			.append("CityCode",getCityCode())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCityId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ManageCity == false) return false;
		if(this == obj) return true;
		ManageCity other = (ManageCity)obj;
		return new EqualsBuilder()
			.append(getCityId(),other.getCityId())
			.isEquals();
	}
}

