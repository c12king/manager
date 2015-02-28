package com.manage.app.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.manage.app.bean.ManageOrgExpress;

public class ManageOrgExpressQuery extends BaseBean {
	

	private java.lang.Integer orgExpId;
	private java.lang.Integer expressId;
	private java.lang.Integer stationId;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private Integer expState;
	private String expressComppay;


	public ManageOrgExpressQuery(ManageOrgExpress manageOrgExpress) {
		this.orgExpId = manageOrgExpress.getOrgExpId();
		this.expressId = manageOrgExpress.getExpressId();
		this.stationId = manageOrgExpress.getStationId();
		this.createTime = manageOrgExpress.getCreateTime();
		this.editTime = manageOrgExpress.getEditTime();
		this.editor = manageOrgExpress.getEditor();
		this.expState = manageOrgExpress.getExpState();
		this.expressComppay = manageOrgExpress.getExpressComppay();
	}
	
	public ManageOrgExpressQuery() {
		
	}	
	
	public java.lang.Integer getOrgExpId() {
		return this.orgExpId;
	}
	
	public void setOrgExpId(java.lang.Integer value) {
		this.orgExpId = value;
	}
		
	public java.lang.Integer getExpressId() {
		return this.expressId;
	}
	
	public void setExpressId(java.lang.Integer value) {
		this.expressId = value;
	}
		
	public java.lang.Integer getStationId() {
		return this.stationId;
	}
	
	public void setStationId(java.lang.Integer value) {
		this.stationId = value;
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
		
	public Integer getExpState() {
		return this.expState;
	}
	
	public void setExpState(Integer value) {
		this.expState = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
	
	public String getExpressComppay() {
		return expressComppay;
	}

	public void setExpressComppay(String expressComppay) {
		this.expressComppay = expressComppay;
	}
	
}

