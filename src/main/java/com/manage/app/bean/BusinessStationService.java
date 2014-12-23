package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class BusinessStationService implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessStationService";

	private java.lang.Integer serviceId;
	private java.lang.Integer stationId;
	private java.lang.String serviceName;
	private java.lang.String servicePic;
	private java.lang.String content;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public BusinessStationService(){
	}

	public BusinessStationService(
		java.lang.Integer serviceId
	){
		this.serviceId = serviceId;
	}

	public void setServiceId(java.lang.Integer value) {
		this.serviceId = value;
	}
	
	public java.lang.Integer getServiceId() {
		return this.serviceId;
	}
	public void setStationId(java.lang.Integer value) {
		this.stationId = value;
	}
	
	public java.lang.Integer getStationId() {
		return this.stationId;
	}
	public void setServiceName(java.lang.String value) {
		this.serviceName = value;
	}
	
	public java.lang.String getServiceName() {
		return this.serviceName;
	}
	public void setServicePic(java.lang.String value) {
		this.servicePic = value;
	}
	
	public java.lang.String getServicePic() {
		return this.servicePic;
	}
	public void setContent(java.lang.String value) {
		this.content = value;
	}
	
	public java.lang.String getContent() {
		return this.content;
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
			.append("ServiceId",getServiceId())
			.append("StationId",getStationId())
			.append("ServiceName",getServiceName())
			.append("ServicePic",getServicePic())
			.append("Content",getContent())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getServiceId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessStationService == false) return false;
		if(this == obj) return true;
		BusinessStationService other = (BusinessStationService)obj;
		return new EqualsBuilder()
			.append(getServiceId(),other.getServiceId())
			.isEquals();
	}
}

