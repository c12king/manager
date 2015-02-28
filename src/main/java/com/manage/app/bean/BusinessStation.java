package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessStation implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessStation";

	private java.lang.Integer stationId;
	private java.lang.Integer orgId;
	private java.lang.String staName;
	private java.lang.String staBrief;
	private java.lang.String staService;
	private java.lang.String staTel;
	private java.lang.String staEmail;
	private java.lang.String staWeixin;
	private java.lang.String staIcon;
	private java.lang.Double staLongitude;
	private java.lang.Double staLatitude;
	private java.sql.Timestamp crateTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.String orgName;
	private java.lang.String staCode;
	private java.lang.Integer isDoor;
	
	public java.lang.String getOrgName() {
		return orgName;
	}

	public void setOrgName(java.lang.String orgName) {
		this.orgName = orgName;
	}

	public BusinessStation(){
	}

	public BusinessStation(
		java.lang.Integer stationId
	){
		this.stationId = stationId;
	}

	public void setStationId(java.lang.Integer value) {
		this.stationId = value;
	}
	
	public java.lang.Integer getStationId() {
		return this.stationId;
	}
	public void setOrgId(java.lang.Integer value) {
		this.orgId = value;
	}
	
	public java.lang.Integer getOrgId() {
		return this.orgId;
	}
	public void setStaName(java.lang.String value) {
		this.staName = value;
	}
	
	public java.lang.String getStaName() {
		return this.staName;
	}
	public void setStaBrief(java.lang.String value) {
		this.staBrief = value;
	}
	
	public java.lang.String getStaBrief() {
		return this.staBrief;
	}
	public void setStaService(java.lang.String value) {
		this.staService = value;
	}
	
	public java.lang.String getStaService() {
		return this.staService;
	}
	public void setStaTel(java.lang.String value) {
		this.staTel = value;
	}
	
	public java.lang.String getStaTel() {
		return this.staTel;
	}
	public void setStaEmail(java.lang.String value) {
		this.staEmail = value;
	}
	
	public java.lang.String getStaEmail() {
		return this.staEmail;
	}
	public void setStaWeixin(java.lang.String value) {
		this.staWeixin = value;
	}
	
	public java.lang.String getStaWeixin() {
		return this.staWeixin;
	}
	public void setStaIcon(java.lang.String value) {
		this.staIcon = value;
	}
	
	public java.lang.String getStaIcon() {
		return this.staIcon;
	}
	public void setStaLongitude(java.lang.Double value) {
		this.staLongitude = value;
	}
	
	public java.lang.Double getStaLongitude() {
		return this.staLongitude;
	}
	public void setStaLatitude(java.lang.Double value) {
		this.staLatitude = value;
	}
	
	public java.lang.Double getStaLatitude() {
		return this.staLatitude;
	}
	public void setCrateTime(java.sql.Timestamp value) {
		this.crateTime = value;
	}
	
	public java.sql.Timestamp getCrateTime() {
		return this.crateTime;
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
			.append("StationId",getStationId())
			.append("OrgId",getOrgId())
			.append("StaName",getStaName())
			.append("StaBrief",getStaBrief())
			.append("StaService",getStaService())
			.append("StaTel",getStaTel())
			.append("StaEmail",getStaEmail())
			.append("StaWeixin",getStaWeixin())
			.append("StaIcon",getStaIcon())
			.append("StaLongitude",getStaLongitude())
			.append("StaLatitude",getStaLatitude())
			.append("isDoor",getIsDoor())
			.append("CrateTime",getCrateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getStationId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessStation == false) return false;
		if(this == obj) return true;
		BusinessStation other = (BusinessStation)obj;
		return new EqualsBuilder()
			.append(getStationId(),other.getStationId())
			.isEquals();
	}

	public java.lang.String getStaCode() {
		return staCode;
	}

	public void setStaCode(java.lang.String staCode) {
		this.staCode = staCode;
	}

	public java.lang.Integer getIsDoor() {
		return isDoor;
	}

	public void setIsDoor(java.lang.Integer isDoor) {
		this.isDoor = isDoor;
	}
	
}

