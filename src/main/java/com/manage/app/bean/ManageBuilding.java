package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class ManageBuilding implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "ManageBuilding";

	private java.lang.Integer buildingId;
	private java.lang.Integer estateId;
	private java.lang.String buildingName;
	private java.lang.String buildingDesc;
	private java.lang.Integer buildingFloor;
	private java.lang.Double estateLongitude;
	private java.lang.Double estateLatitude;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.String buildingMap;

	public ManageBuilding(){
	}

	public ManageBuilding(
		java.lang.Integer buildingId
	){
		this.buildingId = buildingId;
	}

	public void setBuildingId(java.lang.Integer value) {
		this.buildingId = value;
	}
	
	public java.lang.Integer getBuildingId() {
		return this.buildingId;
	}
	public void setEstateId(java.lang.Integer value) {
		this.estateId = value;
	}
	
	public java.lang.Integer getEstateId() {
		return this.estateId;
	}
	public void setBuildingName(java.lang.String value) {
		this.buildingName = value;
	}
	
	public java.lang.String getBuildingName() {
		return this.buildingName;
	}
	public void setBuildingDesc(java.lang.String value) {
		this.buildingDesc = value;
	}
	
	public java.lang.String getBuildingDesc() {
		return this.buildingDesc;
	}
	public void setBuildingFloor(java.lang.Integer value) {
		this.buildingFloor = value;
	}
	
	public java.lang.Integer getBuildingFloor() {
		return this.buildingFloor;
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
	public void setBuildingMap(java.lang.String value) {
		this.buildingMap = value;
	}
	
	public java.lang.String getBuildingMap() {
		return this.buildingMap;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("BuildingId",getBuildingId())
			.append("EstateId",getEstateId())
			.append("BuildingName",getBuildingName())
			.append("BuildingDesc",getBuildingDesc())
			.append("BuildingFloor",getBuildingFloor())
			.append("EstateLongitude",getEstateLongitude())
			.append("EstateLatitude",getEstateLatitude())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.append("BuildingMap",getBuildingMap())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getBuildingId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ManageBuilding == false) return false;
		if(this == obj) return true;
		ManageBuilding other = (ManageBuilding)obj;
		return new EqualsBuilder()
			.append(getBuildingId(),other.getBuildingId())
			.isEquals();
	}
}

