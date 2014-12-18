package com.manage.app.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.manage.app.bean.BusinessTelGroup;

public class BusinessTelGroupQuery extends BaseBean {
	

	private java.lang.Integer groupId;
	private java.lang.Integer cityId;
	private java.lang.Integer comId;
	private java.lang.Integer estateId;
	private java.lang.String groupName;
	private java.lang.String memo;

	public BusinessTelGroupQuery(BusinessTelGroup businessTelGroup) {
		this.groupId = businessTelGroup.getGroupId();
		this.cityId = businessTelGroup.getCityId();
		this.comId = businessTelGroup.getComId();
		this.estateId = businessTelGroup.getEstateId();
		this.groupName = businessTelGroup.getGroupName();
		this.memo = businessTelGroup.getMemo();
	}
	
	public BusinessTelGroupQuery() {
		
	}	
	
	public java.lang.Integer getGroupId() {
		return this.groupId;
	}
	
	public void setGroupId(java.lang.Integer value) {
		this.groupId = value;
	}
		
	public java.lang.Integer getCityId() {
		return this.cityId;
	}
	
	public void setCityId(java.lang.Integer value) {
		this.cityId = value;
	}
		
	public java.lang.Integer getComId() {
		return this.comId;
	}
	
	public void setComId(java.lang.Integer value) {
		this.comId = value;
	}
		
	public java.lang.Integer getEstateId() {
		return this.estateId;
	}
	
	public void setEstateId(java.lang.Integer value) {
		this.estateId = value;
	}
		
	public java.lang.String getGroupName() {
		return this.groupName;
	}
	
	public void setGroupName(java.lang.String value) {
		this.groupName = value;
	}
		
	public java.lang.String getMemo() {
		return this.memo;
	}
	
	public void setMemo(java.lang.String value) {
		this.memo = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

