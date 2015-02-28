package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class ManageUnit implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "ManageUnit";

	private java.lang.Integer unitId;
	private java.lang.Integer buildingId;
	private java.lang.String unitName;
	private java.lang.Double estateLongitude;
	private java.lang.Double estateLatitude;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.String unitMap;

	public ManageUnit(){
	}

	public ManageUnit(
		java.lang.Integer unitId
	){
		this.unitId = unitId;
	}

	public void setUnitId(java.lang.Integer value) {
		this.unitId = value;
	}
	
	public java.lang.Integer getUnitId() {
		return this.unitId;
	}
	public void setBuildingId(java.lang.Integer value) {
		this.buildingId = value;
	}
	
	public java.lang.Integer getBuildingId() {
		return this.buildingId;
	}
	public void setUnitName(java.lang.String value) {
		this.unitName = value;
	}
	
	public java.lang.String getUnitName() {
		return this.unitName;
	}
	public void setEstateLongitude(java.lang.Double value) {
		this.estateLongitude = value;
	}
	
	public java.lang.Double getEstateLongitude() {
		return this.estateLongitude;
	}
	public void setEstateLatitude(java.lang.Double value) {
		this.estateLatitude = value;
	}
	
	public java.lang.Double getEstateLatitude() {
		return this.estateLatitude;
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
	public void setUnitMap(java.lang.String value) {
		this.unitMap = value;
	}
	
	public java.lang.String getUnitMap() {
		return this.unitMap;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("UnitId",getUnitId())
			.append("BuildingId",getBuildingId())
			.append("UnitName",getUnitName())
			.append("EstateLongitude",getEstateLongitude())
			.append("EstateLatitude",getEstateLatitude())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.append("UnitMap",getUnitMap())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getUnitId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ManageUnit == false) return false;
		if(this == obj) return true;
		ManageUnit other = (ManageUnit)obj;
		return new EqualsBuilder()
			.append(getUnitId(),other.getUnitId())
			.isEquals();
	}
}

