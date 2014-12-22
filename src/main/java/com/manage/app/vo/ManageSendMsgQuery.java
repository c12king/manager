package com.manage.app.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.manage.app.bean.ManageSendMsg;
import com.manage.app.vo.BaseBean;

public class ManageSendMsgQuery extends BaseBean {
	

	private java.lang.Integer sendId;
	private java.lang.String sendTel;
	private java.lang.String sendContent;
	private java.lang.String recvCode;
	private java.sql.Timestamp sendTime;
	private Integer sendType;

	public ManageSendMsgQuery(ManageSendMsg manageSendMsg) {
		this.sendId = manageSendMsg.getSendId();
		this.sendTel = manageSendMsg.getSendTel();
		this.sendContent = manageSendMsg.getSendContent();
		this.recvCode = manageSendMsg.getRecvCode();
		this.sendTime = manageSendMsg.getSendTime();
		this.sendType = manageSendMsg.getSendType();
	}
	
	public ManageSendMsgQuery() {
		
	}	
	
	public java.lang.Integer getSendId() {
		return this.sendId;
	}
	
	public void setSendId(java.lang.Integer value) {
		this.sendId = value;
	}
		
	public java.lang.String getSendTel() {
		return this.sendTel;
	}
	
	public void setSendTel(java.lang.String value) {
		this.sendTel = value;
	}
		
	public java.lang.String getSendContent() {
		return this.sendContent;
	}
	
	public void setSendContent(java.lang.String value) {
		this.sendContent = value;
	}
		
	public java.lang.String getRecvCode() {
		return this.recvCode;
	}
	
	public void setRecvCode(java.lang.String value) {
		this.recvCode = value;
	}
		
	public java.sql.Timestamp getSendTime() {
		return this.sendTime;
	}
	
	public void setSendTime(java.sql.Timestamp value) {
		this.sendTime = value;
	}
		
	public Integer getSendType() {
		return this.sendType;
	}
	
	public void setSendType(Integer value) {
		this.sendType = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

