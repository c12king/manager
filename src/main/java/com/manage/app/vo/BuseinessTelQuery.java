package com.manage.app.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.manage.app.bean.BuseinessTel;
import com.manage.app.vo.BaseBean;

public class BuseinessTelQuery extends BaseBean {
	

	private java.lang.Integer telId;
	private java.lang.Integer groupId;
	private java.lang.String tel;
	private java.lang.String telName;

	public BuseinessTelQuery(BuseinessTel buseinessTel) {
		this.telId = buseinessTel.getTelId();
		this.groupId = buseinessTel.getGroupId();
		this.tel = buseinessTel.getTel();
		this.telName = buseinessTel.getTelName();
	}
	
	public BuseinessTelQuery() {
		
	}	
	
	public java.lang.Integer getTelId() {
		return this.telId;
	}
	
	public void setTelId(java.lang.Integer value) {
		this.telId = value;
	}
		
	public java.lang.Integer getGroupId() {
		return this.groupId;
	}
	
	public void setGroupId(java.lang.Integer value) {
		this.groupId = value;
	}
		
	public java.lang.String getTel() {
		return this.tel;
	}
	
	public void setTel(java.lang.String value) {
		this.tel = value;
	}
		
	public java.lang.String getTelName() {
		return this.telName;
	}
	
	public void setTelName(java.lang.String value) {
		this.telName = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

