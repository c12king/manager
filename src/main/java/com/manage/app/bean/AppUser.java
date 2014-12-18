package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class AppUser implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "AppUser";

	private java.lang.Integer userId;
	private java.lang.String realname;
	private java.lang.String nickname;
	private java.lang.String password;
	private java.lang.String tel;
	private Integer sex;
	private java.util.Date birthday;
	private java.lang.String birthdayString;
	public java.lang.String getBirthdayString() {
		return birthdayString;
	}

	public void setBirthdayString(java.lang.String birthdayString) {
		this.birthdayString = birthdayString;
	}

	private Integer type;
	private Integer state;
	private java.lang.String random;
	private java.sql.Timestamp registTime;
	private java.sql.Timestamp verifyTime;
	private java.lang.String verifier;
	private java.lang.String portrait;
	private java.lang.String idCard;
	private java.lang.Integer estateId;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public AppUser(){
	}

	public AppUser(
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
	public void setRealname(java.lang.String value) {
		this.realname = value;
	}
	
	public java.lang.String getRealname() {
		return this.realname;
	}
	public void setNickname(java.lang.String value) {
		this.nickname = value;
	}
	
	public java.lang.String getNickname() {
		return this.nickname;
	}
	public void setPassword(java.lang.String value) {
		this.password = value;
	}
	
	public java.lang.String getPassword() {
		return this.password;
	}
	public void setTel(java.lang.String value) {
		this.tel = value;
	}
	
	public java.lang.String getTel() {
		return this.tel;
	}
	public void setSex(Integer value) {
		this.sex = value;
	}
	
	public Integer getSex() {
		return this.sex;
	}
	public void setBirthday(java.util.Date value) {
		this.birthday = value;
	}
	
	public java.util.Date getBirthday() {
		return this.birthday;
	}
	public void setType(Integer value) {
		this.type = value;
	}
	
	public Integer getType() {
		return this.type;
	}
	public void setState(Integer value) {
		this.state = value;
	}
	
	public Integer getState() {
		return this.state;
	}
	public void setRandom(java.lang.String value) {
		this.random = value;
	}
	
	public java.lang.String getRandom() {
		return this.random;
	}
	public void setRegistTime(java.sql.Timestamp value) {
		this.registTime = value;
	}
	
	public java.sql.Timestamp getRegistTime() {
		return this.registTime;
	}
	public void setVerifyTime(java.sql.Timestamp value) {
		this.verifyTime = value;
	}
	
	public java.sql.Timestamp getVerifyTime() {
		return this.verifyTime;
	}
	public void setVerifier(java.lang.String value) {
		this.verifier = value;
	}
	
	public java.lang.String getVerifier() {
		return this.verifier;
	}
	public void setPortrait(java.lang.String value) {
		this.portrait = value;
	}
	
	public java.lang.String getPortrait() {
		return this.portrait;
	}
	public void setIdCard(java.lang.String value) {
		this.idCard = value;
	}
	
	public java.lang.String getIdCard() {
		return this.idCard;
	}
	public void setEstateId(java.lang.Integer value) {
		this.estateId = value;
	}
	
	public java.lang.Integer getEstateId() {
		return this.estateId;
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
			.append("Realname",getRealname())
			.append("Nickname",getNickname())
			.append("Password",getPassword())
			.append("Tel",getTel())
			.append("Sex",getSex())
			.append("Birthday",getBirthday())
			.append("Type",getType())
			.append("State",getState())
			.append("Random",getRandom())
			.append("RegistTime",getRegistTime())
			.append("VerifyTime",getVerifyTime())
			.append("Verifier",getVerifier())
			.append("Portrait",getPortrait())
			.append("IdCard",getIdCard())
			.append("EstateId",getEstateId())
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
		if(obj instanceof AppUser == false) return false;
		if(this == obj) return true;
		AppUser other = (AppUser)obj;
		return new EqualsBuilder()
			.append(getUserId(),other.getUserId())
			.isEquals();
	}
}

