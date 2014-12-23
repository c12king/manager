package com.manage.app.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.manage.app.bean.BusinessStationService;

public class BusinessStationServiceQuery extends BaseBean {
	

	private java.lang.Integer serviceId;
	private java.lang.Integer stationId;
	private java.lang.String serviceName;
	private java.lang.String servicePic;
	private java.lang.String content;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	
	private java.lang.String staName;

	public BusinessStationServiceQuery(BusinessStationService businessStationService) {
		this.serviceId = businessStationService.getServiceId();
		this.stationId = businessStationService.getStationId();
		this.serviceName = businessStationService.getServiceName();
		this.servicePic = businessStationService.getServicePic();
		this.content = businessStationService.getContent();
		this.createTime = businessStationService.getCreateTime();
		this.editTime = businessStationService.getEditTime();
		this.editor = businessStationService.getEditor();
	}
	
	public BusinessStationServiceQuery() {
		
	}	
	
	public java.lang.Integer getServiceId() {
		return this.serviceId;
	}
	
	public void setServiceId(java.lang.Integer value) {
		this.serviceId = value;
	}
		
	public java.lang.Integer getStationId() {
		return this.stationId;
	}
	
	public void setStationId(java.lang.Integer value) {
		this.stationId = value;
	}
		
	public java.lang.String getServiceName() {
		return this.serviceName;
	}
	
	public void setServiceName(java.lang.String value) {
		this.serviceName = value;
	}
		
	public java.lang.String getServicePic() {
		return this.servicePic;
	}
	
	public void setServicePic(java.lang.String value) {
		this.servicePic = value;
	}
		
	public java.lang.String getContent() {
		return this.content;
	}
	
	public void setContent(java.lang.String value) {
		this.content = value;
	}
		
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
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

	public java.lang.String getStaName() {
		return staName;
	}

	public void setStaName(java.lang.String staName) {
		this.staName = staName;
	}
	
}

