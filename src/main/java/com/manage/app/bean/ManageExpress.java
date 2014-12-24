package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class ManageExpress implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "ManageExpress";

	private java.lang.Integer expressId;
	private java.lang.String expressComppay;
	private java.lang.String expressDesc;
	private java.lang.String expressAddress;
	private java.lang.String expressIcon;
	private java.lang.String expressFee;
	private java.lang.String expressTel;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private Integer state;

	public ManageExpress(){
	}

	public ManageExpress(
		java.lang.Integer expressId
	){
		this.expressId = expressId;
	}

	public void setExpressId(java.lang.Integer value) {
		this.expressId = value;
	}
	
	public java.lang.Integer getExpressId() {
		return this.expressId;
	}
	public void setExpressComppay(java.lang.String value) {
		this.expressComppay = value;
	}
	
	public java.lang.String getExpressComppay() {
		return this.expressComppay;
	}
	public void setExpressDesc(java.lang.String value) {
		this.expressDesc = value;
	}
	
	public java.lang.String getExpressDesc() {
		return this.expressDesc;
	}
	public void setExpressAddress(java.lang.String value) {
		this.expressAddress = value;
	}
	
	public java.lang.String getExpressAddress() {
		return this.expressAddress;
	}
	public void setExpressIcon(java.lang.String value) {
		this.expressIcon = value;
	}
	
	public java.lang.String getExpressIcon() {
		return this.expressIcon;
	}
	public void setExpressFee(java.lang.String value) {
		this.expressFee = value;
	}
	
	public java.lang.String getExpressFee() {
		return this.expressFee;
	}
	public void setExpressTel(java.lang.String value) {
		this.expressTel = value;
	}
	
	public java.lang.String getExpressTel() {
		return this.expressTel;
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
	public void setState(Integer value) {
		this.state = value;
	}
	
	public Integer getState() {
		return this.state;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("ExpressId",getExpressId())
			.append("ExpressComppay",getExpressComppay())
			.append("ExpressDesc",getExpressDesc())
			.append("ExpressAddress",getExpressAddress())
			.append("ExpressIcon",getExpressIcon())
			.append("ExpressFee",getExpressFee())
			.append("ExpressTel",getExpressTel())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.append("State",getState())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getExpressId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ManageExpress == false) return false;
		if(this == obj) return true;
		ManageExpress other = (ManageExpress)obj;
		return new EqualsBuilder()
			.append(getExpressId(),other.getExpressId())
			.isEquals();
	}
}

