package com.manage.app.vo;

import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.manage.app.bean.BusinessUserCommunity;

public class BusinessUserCommunityQuery extends BaseBean {
	

	private java.lang.Integer urcoId;
	private java.lang.Integer userId;
	private java.lang.Integer comId;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;

	private Map fieldMap;
	
	public BusinessUserCommunityQuery(BusinessUserCommunity businessUserCommunity) {
		this.urcoId = businessUserCommunity.getUrcoId();
		this.userId = businessUserCommunity.getUserId();
		this.comId = businessUserCommunity.getComId();
		this.createTime = businessUserCommunity.getCreateTime();
		this.editTime = businessUserCommunity.getEditTime();
	}
	
	public BusinessUserCommunityQuery() {
		
	}	
	
	public java.lang.Integer getUrcoId() {
		return this.urcoId;
	}
	
	public void setUrcoId(java.lang.Integer value) {
		this.urcoId = value;
	}
		
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
		
	public java.lang.Integer getComId() {
		return this.comId;
	}
	
	public void setComId(java.lang.Integer value) {
		this.comId = value;
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
		
	
	public Map getFieldMap() {
		return this.fieldMap;
	}
	
	public void setFieldMap(Map fieldMap) {
		this.fieldMap = fieldMap;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

