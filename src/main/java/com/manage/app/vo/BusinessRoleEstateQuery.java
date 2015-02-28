package com.manage.app.vo;

import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.manage.app.bean.BusinessRoleEstate;

public class BusinessRoleEstateQuery extends BaseBean {
	

	private java.lang.Integer roesId;
	private java.lang.Integer rocoId;
	private java.lang.Integer estateId;

	private Map fieldMap;
	
	public BusinessRoleEstateQuery(BusinessRoleEstate businessRoleEstate) {
		this.roesId = businessRoleEstate.getRoesId();
		this.rocoId = businessRoleEstate.getRocoId();
		this.estateId = businessRoleEstate.getEstateId();
	}
	
	public BusinessRoleEstateQuery() {
		
	}	
	
	public java.lang.Integer getRoesId() {
		return this.roesId;
	}
	
	public void setRoesId(java.lang.Integer value) {
		this.roesId = value;
	}
		
	public java.lang.Integer getRocoId() {
		return this.rocoId;
	}
	
	public void setRocoId(java.lang.Integer value) {
		this.rocoId = value;
	}
		
	public java.lang.Integer getEstateId() {
		return this.estateId;
	}
	
	public void setEstateId(java.lang.Integer value) {
		this.estateId = value;
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

