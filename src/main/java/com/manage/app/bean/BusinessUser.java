package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessUser implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessUser";

	private java.lang.Integer userId;
	private java.lang.String userName;
	private java.lang.String userTel;
	private java.lang.String userPassword;
	private java.lang.String userCode;
	private java.sql.Timestamp lastLoginTime;
	private java.lang.String userEmail;
	private java.lang.String userPhoto;
	private java.lang.String userBrief;
	private java.lang.String userService;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.Integer positionId;
	private java.lang.String posName;
	private java.lang.String modules;
	private Integer isCharge;
	private java.lang.String fullPosName;
	private java.lang.String orgType;
	
	public java.lang.Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(java.lang.Integer positionId) {
		this.positionId = positionId;
	}

	public java.lang.String getPosName() {
		return posName;
	}

	public void setPosName(java.lang.String posName) {
		this.posName = posName;
	}

	public java.lang.String getModules() {
		return modules;
	}

	public void setModules(java.lang.String modules) {
		this.modules = modules;
	}

	public Integer getIsCharge() {
		return isCharge;
	}

	public void setIsCharge(Integer isCharge) {
		this.isCharge = isCharge;
	}

	public BusinessUser(){
	}

	public BusinessUser(
		java.lang.Integer userId
	){
		this.userId = userId;
	}

	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
	
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	public void setUserName(java.lang.String value) {
		this.userName = value;
	}
	
	public java.lang.String getUserName() {
		return this.userName;
	}
	public void setUserTel(java.lang.String value) {
		this.userTel = value;
	}
	
	public java.lang.String getUserTel() {
		return this.userTel;
	}
	public void setUserPassword(java.lang.String value) {
		this.userPassword = value;
	}
	
	public java.lang.String getUserPassword() {
		return this.userPassword;
	}
	public void setUserCode(java.lang.String value) {
		this.userCode = value;
	}
	
	public java.lang.String getUserCode() {
		return this.userCode;
	}
	public void setLastLoginTime(java.sql.Timestamp value) {
		this.lastLoginTime = value;
	}
	
	public java.sql.Timestamp getLastLoginTime() {
		return this.lastLoginTime;
	}
	public void setUserEmail(java.lang.String value) {
		this.userEmail = value;
	}
	
	public java.lang.String getUserEmail() {
		return this.userEmail;
	}
	public void setUserPhoto(java.lang.String value) {
		this.userPhoto = value;
	}
	
	public java.lang.String getUserPhoto() {
		return this.userPhoto;
	}
	public void setUserBrief(java.lang.String value) {
		this.userBrief = value;
	}
	
	public java.lang.String getUserBrief() {
		return this.userBrief;
	}
	public void setUserService(java.lang.String value) {
		this.userService = value;
	}
	
	public java.lang.String getUserService() {
		return this.userService;
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
			.append("UserId",getUserId())
			.append("UserName",getUserName())
			.append("UserTel",getUserTel())
			.append("UserPassword",getUserPassword())
			.append("UserCode",getUserCode())
			.append("LastLoginTime",getLastLoginTime())
			.append("UserEmail",getUserEmail())
			.append("UserPhoto",getUserPhoto())
			.append("UserBrief",getUserBrief())
			.append("UserService",getUserService())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getUserId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessUser == false) return false;
		if(this == obj) return true;
		BusinessUser other = (BusinessUser)obj;
		return new EqualsBuilder()
			.append(getUserId(),other.getUserId())
			.isEquals();
	}

	public java.lang.String getFullPosName() {
		return fullPosName;
	}

	public void setFullPosName(java.lang.String fullPosName) {
		this.fullPosName = fullPosName;
	}

	public java.lang.String getOrgType() {
		return orgType;
	}

	public void setOrgType(java.lang.String orgType) {
		this.orgType = orgType;
	}
	
}

