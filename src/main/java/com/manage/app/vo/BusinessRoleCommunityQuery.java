package com.manage.app.vo;

import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.manage.app.bean.BusinessRoleCommunity;

public class BusinessRoleCommunityQuery extends BaseBean {
	

	private java.lang.Integer rocoId;
	private java.lang.Integer refuId;
	private java.lang.Integer comId;

	private Map fieldMap;
	
	public BusinessRoleCommunityQuery(BusinessRoleCommunity businessRoleCommunity) {
		this.rocoId = businessRoleCommunity.getRocoId();
		this.refuId = businessRoleCommunity.getRefuId();
		this.comId = businessRoleCommunity.getComId();
	}
	
	public BusinessRoleCommunityQuery() {
		
	}	
	
	public java.lang.Integer getRocoId() {
		return this.rocoId;
	}
	
	public void setRocoId(java.lang.Integer value) {
		this.rocoId = value;
	}
		
	public java.lang.Integer getRefuId() {
		return this.refuId;
	}
	
	public void setRefuId(java.lang.Integer value) {
		this.refuId = value;
	}
		
	public java.lang.Integer getComId() {
		return this.comId;
	}
	
	public void setComId(java.lang.Integer value) {
		this.comId = value;
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

