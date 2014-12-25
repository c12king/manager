package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class ManageOrgExpress implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "ManageOrgExpress";

	private java.lang.Integer orgExpId;
	private java.lang.Integer expressId;
	private java.lang.Integer stationId;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private Integer expState;
	private String staName;
	private String expressComppay;
	
	public ManageOrgExpress(){
	}

	public ManageOrgExpress(
		java.lang.Integer orgExpId
	){
		this.orgExpId = orgExpId;
	}

	public void setOrgExpId(java.lang.Integer value) {
		this.orgExpId = value;
	}
	
	public java.lang.Integer getOrgExpId() {
		return this.orgExpId;
	}
	public void setExpressId(java.lang.Integer value) {
		this.expressId = value;
	}
	
	public java.lang.Integer getExpressId() {
		return this.expressId;
	}
	public void setStationId(java.lang.Integer value) {
		this.stationId = value;
	}
	
	public java.lang.Integer getStationId() {
		return this.stationId;
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
	public void setExpState(Integer value) {
		this.expState = value;
	}
	
	public Integer getExpState() {
		return this.expState;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("OrgExpId",getOrgExpId())
			.append("ExpressId",getExpressId())
			.append("StationId",getStationId())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.append("ExpState",getExpState())
			.append("staName",getExpState())
			.append("expressComppay",getExpState())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getOrgExpId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ManageOrgExpress == false) return false;
		if(this == obj) return true;
		ManageOrgExpress other = (ManageOrgExpress)obj;
		return new EqualsBuilder()
			.append(getOrgExpId(),other.getOrgExpId())
			.isEquals();
	}

	public String getStaName() {
		return staName;
	}

	public void setStaName(String staName) {
		this.staName = staName;
	}

	public String getExpressComppay() {
		return expressComppay;
	}

	public void setExpressComppay(String expressComppay) {
		this.expressComppay = expressComppay;
	}
}

