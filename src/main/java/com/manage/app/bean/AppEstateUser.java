package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class AppEstateUser implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "AppEstateUser";

	private java.lang.Integer estMemId;
	private java.lang.Integer estateId;
	private java.lang.Integer userId;
	private java.lang.Integer buildingId;
	private java.lang.Integer unitId;
	private java.lang.Integer houseId;
	private java.lang.String estateName;
	private java.lang.String buildingName;
	private java.lang.String unitName;
	private java.lang.String houseNo;
	private Integer memberType;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public AppEstateUser(){
	}

	public AppEstateUser(
		java.lang.Integer estMemId
	){
		this.estMemId = estMemId;
	}

	public void setEstMemId(java.lang.Integer value) {
		this.estMemId = value;
	}
	
	public java.lang.Integer getEstMemId() {
		return this.estMemId;
	}
	public void setEstateId(java.lang.Integer value) {
		this.estateId = value;
	}
	
	public java.lang.Integer getEstateId() {
		return this.estateId;
	}
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
	
	public java.lang.Integer getUserId() {
		return this.userId;
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
	public void setHouseId(java.lang.Integer value) {
		this.houseId = value;
	}
	
	public java.lang.Integer getHouseId() {
		return this.houseId;
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
	public void setUnitName(java.lang.String value) {
		this.unitName = value;
	}
	
	public java.lang.String getUnitName() {
		return this.unitName;
	}
	public void setHouseNo(java.lang.String value) {
		this.houseNo = value;
	}
	
	public java.lang.String getHouseNo() {
		return this.houseNo;
	}
	public void setMemberType(Integer value) {
		this.memberType = value;
	}
	
	public Integer getMemberType() {
		return this.memberType;
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
			.append("EstMemId",getEstMemId())
			.append("EstateId",getEstateId())
			.append("UserId",getUserId())
			.append("BuildingId",getBuildingId())
			.append("UnitId",getUnitId())
			.append("HouseId",getHouseId())
			.append("EstateName",getEstateName())
			.append("BuildingName",getBuildingName())
			.append("UnitName",getUnitName())
			.append("HouseNo",getHouseNo())
			.append("MemberType",getMemberType())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getEstMemId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AppEstateUser == false) return false;
		if(this == obj) return true;
		AppEstateUser other = (AppEstateUser)obj;
		return new EqualsBuilder()
			.append(getEstMemId(),other.getEstMemId())
			.isEquals();
	}
}

