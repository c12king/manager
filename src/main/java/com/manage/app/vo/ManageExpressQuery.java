package com.manage.app.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.manage.app.bean.ManageExpress;

public class ManageExpressQuery extends BaseBean {
	

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

	public ManageExpressQuery(ManageExpress manageExpress) {
		this.expressId = manageExpress.getExpressId();
		this.expressComppay = manageExpress.getExpressComppay();
		this.expressDesc = manageExpress.getExpressDesc();
		this.expressAddress = manageExpress.getExpressAddress();
		this.expressIcon = manageExpress.getExpressIcon();
		this.expressFee = manageExpress.getExpressFee();
		this.expressTel = manageExpress.getExpressTel();
		this.createTime = manageExpress.getCreateTime();
		this.editTime = manageExpress.getEditTime();
		this.editor = manageExpress.getEditor();
		this.state = manageExpress.getState();
	}
	
	public ManageExpressQuery() {
		
	}	
	
	public java.lang.Integer getExpressId() {
		return this.expressId;
	}
	
	public void setExpressId(java.lang.Integer value) {
		this.expressId = value;
	}
		
	public java.lang.String getExpressComppay() {
		return this.expressComppay;
	}
	
	public void setExpressComppay(java.lang.String value) {
		this.expressComppay = value;
	}
		
	public java.lang.String getExpressDesc() {
		return this.expressDesc;
	}
	
	public void setExpressDesc(java.lang.String value) {
		this.expressDesc = value;
	}
		
	public java.lang.String getExpressAddress() {
		return this.expressAddress;
	}
	
	public void setExpressAddress(java.lang.String value) {
		this.expressAddress = value;
	}
		
	public java.lang.String getExpressIcon() {
		return this.expressIcon;
	}
	
	public void setExpressIcon(java.lang.String value) {
		this.expressIcon = value;
	}
		
	public java.lang.String getExpressFee() {
		return this.expressFee;
	}
	
	public void setExpressFee(java.lang.String value) {
		this.expressFee = value;
	}
		
	public java.lang.String getExpressTel() {
		return this.expressTel;
	}
	
	public void setExpressTel(java.lang.String value) {
		this.expressTel = value;
	}
		
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
		
	public java.sql.Timestamp getEditTime() {
		return this.editTime;
	}
	
	public void setEditTime(java.sql.Timestamp value) {
		this.editTime = value;
	}
		
	public java.lang.String getEditor() {
		return this.editor;
	}
	
	public void setEditor(java.lang.String value) {
		this.editor = value;
	}
		
	public Integer getState() {
		return this.state;
	}
	
	public void setState(Integer value) {
		this.state = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

