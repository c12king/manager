package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class ManageEstate implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "ManageEstate";

	private java.lang.Integer estateId;
	private java.lang.String estateName;
	private java.lang.String estateDesc;
	private java.lang.String estateAddress;
	private java.lang.String estateMap;
	private java.lang.Double estateLongitude;
	private java.lang.Double estateLatitude;
	private java.lang.String estateCarMap;
	private Integer estateType;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.Integer countyId;
	private java.lang.Integer stationId;
	private java.lang.Integer proId;
	private java.lang.Integer comId;

	public ManageEstate(){
	}

	public ManageEstate(
		java.lang.Integer estateId
	){
		this.estateId = estateId;
	}

	public void setEstateId(java.lang.Integer value) {
		this.estateId = value;
	}
	
	public java.lang.Integer getEstateId() {
		return this.estateId;
	}
	
	
	
	public void setEstateName(java.lang.String value) {
		this.estateName = value;
	}
	
	public java.lang.String getEstateName() {
		return this.estateName;
	}
	public void setEstateDesc(java.lang.String value) {
		this.estateDesc = value;
	}
	
	public java.lang.String getEstateDesc() {
		return this.estateDesc;
	}
	public void setEstateAddress(java.lang.String value) {
		this.estateAddress = value;
	}
	
	public java.lang.String getEstateAddress() {
		return this.estateAddress;
	}
	public void setEstateMap(java.lang.String value) {
		this.estateMap = value;
	}
	
	public java.lang.String getEstateMap() {
		return this.estateMap;
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
	public void setEstateCarMap(java.lang.String value) {
		this.estateCarMap = value;
	}
	
	public java.lang.String getEstateCarMap() {
		return this.estateCarMap;
	}
	public void setEstateType(Integer value) {
		this.estateType = value;
	}
	
	public Integer getEstateType() {
		return this.estateType;
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
			.append("EstateId",getEstateId())
			.append("EstateName",getEstateName())
			.append("EstateDesc",getEstateDesc())
			.append("EstateAddress",getEstateAddress())
			.append("EstateMap",getEstateMap())
			.append("EstateLongitude",getEstateLongitude())
			.append("EstateLatitude",getEstateLatitude())
			.append("EstateCarMap",getEstateCarMap())
			.append("EstateType",getEstateType())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getEstateId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ManageEstate == false) return false;
		if(this == obj) return true;
		ManageEstate other = (ManageEstate)obj;
		return new EqualsBuilder()
			.append(getEstateId(),other.getEstateId())
			.isEquals();
	}

	public java.lang.Integer getCountyId() {
		return countyId;
	}

	public void setCountyId(java.lang.Integer countyId) {
		this.countyId = countyId;
	}

	public java.lang.Integer getStationId() {
		return stationId;
	}

	public void setStationId(java.lang.Integer stationId) {
		this.stationId = stationId;
	}

	public java.lang.Integer getProId() {
		return proId;
	}

	public void setProId(java.lang.Integer proId) {
		this.proId = proId;
	}

	public java.lang.Integer getComId() {
		return comId;
	}

	public void setComId(java.lang.Integer comId) {
		this.comId = comId;
	}
	
}

