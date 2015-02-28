package com.manage.app.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.manage.app.bean.BusinessStation;

public class BusinessStationQuery extends BaseBean {
	

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
	private java.lang.Integer isDoor;
	
	public BusinessStationQuery(BusinessStation businessStation) {
		this.stationId = businessStation.getStationId();
		this.orgId = businessStation.getOrgId();
		this.staName = businessStation.getStaName();
		this.staBrief = businessStation.getStaBrief();
		this.staService = businessStation.getStaService();
		this.staTel = businessStation.getStaTel();
		this.staEmail = businessStation.getStaEmail();
		this.staWeixin = businessStation.getStaWeixin();
		this.staIcon = businessStation.getStaIcon();
		this.staLongitude = businessStation.getStaLongitude();
		this.staLatitude = businessStation.getStaLatitude();
		this.isDoor = businessStation.getIsDoor();
		this.crateTime = businessStation.getCrateTime();
		this.editTime = businessStation.getEditTime();
		this.editor = businessStation.getEditor();
	}
	
	public BusinessStationQuery() {
		
	}	
	
	public java.lang.Integer getStationId() {
		return this.stationId;
	}
	
	public void setStationId(java.lang.Integer value) {
		this.stationId = value;
	}
		
	public java.lang.Integer getOrgId() {
		return this.orgId;
	}
	
	public void setOrgId(java.lang.Integer value) {
		this.orgId = value;
	}
		
	public java.lang.String getStaName() {
		return this.staName;
	}
	
	public void setStaName(java.lang.String value) {
		this.staName = value;
	}
		
	public java.lang.String getStaBrief() {
		return this.staBrief;
	}
	
	public void setStaBrief(java.lang.String value) {
		this.staBrief = value;
	}
		
	public java.lang.String getStaService() {
		return this.staService;
	}
	
	public void setStaService(java.lang.String value) {
		this.staService = value;
	}
		
	public java.lang.String getStaTel() {
		return this.staTel;
	}
	
	public void setStaTel(java.lang.String value) {
		this.staTel = value;
	}
		
	public java.lang.String getStaEmail() {
		return this.staEmail;
	}
	
	public void setStaEmail(java.lang.String value) {
		this.staEmail = value;
	}
		
	public java.lang.String getStaWeixin() {
		return this.staWeixin;
	}
	
	public void setStaWeixin(java.lang.String value) {
		this.staWeixin = value;
	}
		
	public java.lang.String getStaIcon() {
		return this.staIcon;
	}
	
	public void setStaIcon(java.lang.String value) {
		this.staIcon = value;
	}
		
	public java.lang.Double getStaLongitude() {
		return this.staLongitude;
	}
	
	public void setStaLongitude(java.lang.Double value) {
		this.staLongitude = value;
	}
		
	public java.lang.Double getStaLatitude() {
		return this.staLatitude;
	}
	
	public void setStaLatitude(java.lang.Double value) {
		this.staLatitude = value;
	}
		
	public java.sql.Timestamp getCrateTime() {
		return this.crateTime;
	}
	
	public void setCrateTime(java.sql.Timestamp value) {
		this.crateTime = value;
	}
		
	public java.sql.Timestamp getEditTime() {
		return this.editTime;
	}
	
	public void setEditTime(java.sql.Timestamp value) {
		this.editTime = value;
	}
		
	public java.lang.String getEditor() {
		return this.editor;
	}
	
	public void setEditor(java.lang.String value) {
		this.editor = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}

	public java.lang.Integer getIsDoor() {
		return isDoor;
	}

	public void setIsDoor(java.lang.Integer isDoor) {
		this.isDoor = isDoor;
	}
	
}

