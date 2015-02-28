package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class ManageExpressFee implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "ManageExpressFee";

	private java.lang.Integer feeId;
	private java.lang.Integer expressId;
	private java.lang.String title;
	private java.lang.String content;
	private java.sql.Timestamp createTime;

	public ManageExpressFee(){
	}

	public ManageExpressFee(
		java.lang.Integer feeId
	){
		this.feeId = feeId;
	}

	public void setFeeId(java.lang.Integer value) {
		this.feeId = value;
	}
	
	public java.lang.Integer getFeeId() {
		return this.feeId;
	}
	public void setExpressId(java.lang.Integer value) {
		this.expressId = value;
	}
	
	public java.lang.Integer getExpressId() {
		return this.expressId;
	}
	public void setTitle(java.lang.String value) {
		this.title = value;
	}
	
	public java.lang.String getTitle() {
		return this.title;
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

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("FeeId",getFeeId())
			.append("ExpressId",getExpressId())
			.append("Title",getTitle())
			.append("Content",getContent())
			.append("CreateTime",getCreateTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getFeeId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ManageExpressFee == false) return false;
		if(this == obj) return true;
		ManageExpressFee other = (ManageExpressFee)obj;
		return new EqualsBuilder()
			.append(getFeeId(),other.getFeeId())
			.isEquals();
	}
}

