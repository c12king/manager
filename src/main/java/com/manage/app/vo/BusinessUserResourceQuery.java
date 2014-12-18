package com.manage.app.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.manage.app.bean.BusinessUserResource;
import com.manage.app.vo.BaseBean;

public class BusinessUserResourceQuery extends BaseBean {
	

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

	public java.lang.Integer getComId() {
		return comId;
	}

	public void setComId(java.lang.Integer comId) {
		this.comId = comId;
	}

	public BusinessUserResourceQuery(BusinessUserResource businessUserResource) {
		this.usreId = businessUserResource.getUsreId();
		this.userId = businessUserResource.getUserId();
		this.estateId = businessUserResource.getEstateId();
		this.buildingId = businessUserResource.getBuildingId();
		this.unitId = businessUserResource.getUnitId();
		this.estateName = businessUserResource.getEstateName();
		this.buildingName = businessUserResource.getBuildingName();
		this.createTime = businessUserResource.getCreateTime();
		this.editTime = businessUserResource.getEditTime();
		this.editor = businessUserResource.getEditor();
	}
	
	public BusinessUserResourceQuery() {
		
	}	
	
	public java.lang.Integer getUsreId() {
		return this.usreId;
	}
	
	public void setUsreId(java.lang.Integer value) {
		this.usreId = value;
	}
		
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
		
	public java.lang.Integer getEstateId() {
		return this.estateId;
	}
	
	public void setEstateId(java.lang.Integer value) {
		this.estateId = value;
	}
		
	public java.lang.Integer getBuildingId() {
		return this.buildingId;
	}
	
	public void setBuildingId(java.lang.Integer value) {
		this.buildingId = value;
	}
		
	public java.lang.Integer getUnitId() {
		return this.unitId;
	}
	
	public void setUnitId(java.lang.Integer value) {
		this.unitId = value;
	}
		
	public java.lang.String getEstateName() {
		return this.estateName;
	}
	
	public void setEstateName(java.lang.String value) {
		this.estateName = value;
	}
		
	public java.lang.String getBuildingName() {
		return this.buildingName;
	}
	
	public void setBuildingName(java.lang.String value) {
		this.buildingName = value;
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
	
}

