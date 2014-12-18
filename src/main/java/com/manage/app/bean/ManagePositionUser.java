package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class ManagePositionUser implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "ManagePositionUser";

	private java.lang.Integer posUserId;
	private java.lang.Integer userId;
	private java.lang.Integer positionId;
	private java.lang.String positionName;
	private java.lang.String userName;
	private Integer userState;
	private Integer isCharge;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.String orgName;

	public java.lang.String getOrgName() {
		return orgName;
	}

	public void setOrgName(java.lang.String orgName) {
		this.orgName = orgName;
	}

	public ManagePositionUser(){
	}

	public ManagePositionUser(
		java.lang.Integer posUserId
	){
		this.posUserId = posUserId;
	}

	public void setPosUserId(java.lang.Integer value) {
		this.posUserId = value;
	}
	
	public java.lang.Integer getPosUserId() {
		return this.posUserId;
	}
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
	
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	public void setPositionId(java.lang.Integer value) {
		this.positionId = value;
	}
	
	public java.lang.Integer getPositionId() {
		return this.positionId;
	}
	public void setPositionName(java.lang.String value) {
		this.positionName = value;
	}
	
	public java.lang.String getPositionName() {
		return this.positionName;
	}
	public void setUserName(java.lang.String value) {
		this.userName = value;
	}
	
	public java.lang.String getUserName() {
		return this.userName;
	}
	public void setUserState(Integer value) {
		this.userState = value;
	}
	
	public Integer getUserState() {
		return this.userState;
	}
	public void setIsCharge(Integer value) {
		this.isCharge = value;
	}
	
	public Integer getIsCharge() {
		return this.isCharge;
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
			.append("PosUserId",getPosUserId())
			.append("UserId",getUserId())
			.append("PositionId",getPositionId())
			.append("PositionName",getPositionName())
			.append("UserName",getUserName())
			.append("UserState",getUserState())
			.append("IsCharge",getIsCharge())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getPosUserId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ManagePositionUser == false) return false;
		if(this == obj) return true;
		ManagePositionUser other = (ManagePositionUser)obj;
		return new EqualsBuilder()
			.append(getPosUserId(),other.getPosUserId())
			.isEquals();
	}
}

