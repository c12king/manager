package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class ManageSendMsg implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "ManageSendMsg";

	private java.lang.Integer sendId;
	private java.lang.String sendTel;
	private java.lang.String sendContent;
	private java.lang.String recvCode;
	private java.sql.Timestamp sendTime;
	private Integer sendType;

	public ManageSendMsg(){
	}

	public ManageSendMsg(
		java.lang.Integer sendId
	){
		this.sendId = sendId;
	}

	public void setSendId(java.lang.Integer value) {
		this.sendId = value;
	}
	
	public java.lang.Integer getSendId() {
		return this.sendId;
	}
	public void setSendTel(java.lang.String value) {
		this.sendTel = value;
	}
	
	public java.lang.String getSendTel() {
		return this.sendTel;
	}
	public void setSendContent(java.lang.String value) {
		this.sendContent = value;
	}
	
	public java.lang.String getSendContent() {
		return this.sendContent;
	}
	public void setRecvCode(java.lang.String value) {
		this.recvCode = value;
	}
	
	public java.lang.String getRecvCode() {
		return this.recvCode;
	}
	public void setSendTime(java.sql.Timestamp value) {
		this.sendTime = value;
	}
	
	public java.sql.Timestamp getSendTime() {
		return this.sendTime;
	}
	public void setSendType(Integer value) {
		this.sendType = value;
	}
	
	public Integer getSendType() {
		return this.sendType;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("SendId",getSendId())
			.append("SendTel",getSendTel())
			.append("SendContent",getSendContent())
			.append("RecvCode",getRecvCode())
			.append("SendTime",getSendTime())
			.append("SendType",getSendType())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getSendId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ManageSendMsg == false) return false;
		if(this == obj) return true;
		ManageSendMsg other = (ManageSendMsg)obj;
		return new EqualsBuilder()
			.append(getSendId(),other.getSendId())
			.isEquals();
	}
}

