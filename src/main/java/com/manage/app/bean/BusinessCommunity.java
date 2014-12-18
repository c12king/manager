package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class BusinessCommunity implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessCommunity";

	private java.lang.Integer comId;
	private java.lang.Integer orgId;
	private java.lang.String comName;
	private java.lang.String comBrief;
	private java.lang.String comService;
	private java.lang.String comTel;
	private java.lang.String comEmail;
	private java.lang.String comWeixin;
	private java.lang.String comIcon;
	private java.lang.Double comLongitude;
	private java.lang.Double comLatitude;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.String orgName;
	private java.lang.String comCode;
	

	public java.lang.String getOrgName() {
		return orgName;
	}

	public void setOrgName(java.lang.String orgName) {
		this.orgName = orgName;
	}

	public BusinessCommunity(){
	}

	public BusinessCommunity(
		java.lang.Integer comId
	){
		this.comId = comId;
	}

	public void setComId(java.lang.Integer value) {
		this.comId = value;
	}
	
	public java.lang.Integer getComId() {
		return this.comId;
	}
	public void setOrgId(java.lang.Integer value) {
		this.orgId = value;
	}
	
	public java.lang.Integer getOrgId() {
		return this.orgId;
	}
	public void setComName(java.lang.String value) {
		this.comName = value;
	}
	
	public java.lang.String getComName() {
		return this.comName;
	}
	public void setComBrief(java.lang.String value) {
		this.comBrief = value;
	}
	
	public java.lang.String getComBrief() {
		return this.comBrief;
	}
	public void setComService(java.lang.String value) {
		this.comService = value;
	}
	
	public java.lang.String getComService() {
		return this.comService;
	}
	public void setComTel(java.lang.String value) {
		this.comTel = value;
	}
	
	public java.lang.String getComTel() {
		return this.comTel;
	}
	public void setComEmail(java.lang.String value) {
		this.comEmail = value;
	}
	
	public java.lang.String getComEmail() {
		return this.comEmail;
	}
	public void setComWeixin(java.lang.String value) {
		this.comWeixin = value;
	}
	
	public java.lang.String getComWeixin() {
		return this.comWeixin;
	}
	public void setComIcon(java.lang.String value) {
		this.comIcon = value;
	}
	
	public java.lang.String getComIcon() {
		return this.comIcon;
	}
	public void setComLongitude(java.lang.Double value) {
		this.comLongitude = value;
	}
	
	public java.lang.Double getComLongitude() {
		return this.comLongitude;
	}
	public void setComLatitude(java.lang.Double value) {
		this.comLatitude = value;
	}
	
	public java.lang.Double getComLatitude() {
		return this.comLatitude;
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
			.append("ComId",getComId())
			.append("OrgId",getOrgId())
			.append("ComName",getComName())
			.append("ComBrief",getComBrief())
			.append("ComService",getComService())
			.append("ComTel",getComTel())
			.append("ComEmail",getComEmail())
			.append("ComWeixin",getComWeixin())
			.append("ComIcon",getComIcon())
			.append("ComLongitude",getComLongitude())
			.append("ComLatitude",getComLatitude())
			.append("CrateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getComId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessCommunity == false) return false;
		if(this == obj) return true;
		BusinessCommunity other = (BusinessCommunity)obj;
		return new EqualsBuilder()
			.append(getComId(),other.getComId())
			.isEquals();
	}

	public java.lang.String getComCode() {
		return comCode;
	}

	public void setComCode(java.lang.String comCode) {
		this.comCode = comCode;
	}
	
}

