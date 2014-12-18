package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class BusinessUserResource implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessUserResource";

	private java.lang.Integer usreId;
	private java.lang.Integer userId;
	private java.lang.Integer estateId;
	private java.lang.Integer buildingId;
	private java.lang.Integer unitId;
	private java.lang.String estateName;
	private java.lang.String buildingName;
	private java.lang.Integer comId;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private String unitName;

	public BusinessUserResource(){
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public BusinessUserResource(
		java.lang.Integer usreId
	){
		this.usreId = usreId;
	}

	public void setUsreId(java.lang.Integer value) {
		this.usreId = value;
	}
	
	public java.lang.Integer getUsreId() {
		return this.usreId;
	}
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
	
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	public void setEstateId(java.lang.Integer value) {
		this.estateId = value;
	}
	
	public java.lang.Integer getEstateId() {
		return this.estateId;
	}
	public void setBuildingId(java.lang.Integer value) {
		this.buildingId = value;
	}
	
	public java.lang.Integer getBuildingId() {
		return this.buildingId;
	}
	public void setUnitId(java.lang.Integer value) {
		this.unitId = value;
	}
	
	public java.lang.Integer getUnitId() {
		return this.unitId;
	}
	public void setEstateName(java.lang.String value) {
		this.estateName = value;
	}
	
	public java.lang.String getEstateName() {
		return this.estateName;
	}
	public void setBuildingName(java.lang.String value) {
		this.buildingName = value;
	}
	
	public java.lang.String getBuildingName() {
		return this.buildingName;
	}
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
	
	public java.lang.Integer getComId() {
		return comId;
	}

	public void setComId(java.lang.Integer comId) {
		this.comId = comId;
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
			.append("UsreId",getUsreId())
			.append("UserId",getUserId())
			.append("EstateId",getEstateId())
			.append("BuildingId",getBuildingId())
			.append("UnitId",getUnitId())
			.append("EstateName",getEstateName())
			.append("BuildingName",getBuildingName())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getUsreId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessUserResource == false) return false;
		if(this == obj) return true;
		BusinessUserResource other = (BusinessUserResource)obj;
		return new EqualsBuilder()
			.append(getUsreId(),other.getUsreId())
			.isEquals();
	}
}

