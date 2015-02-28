package com.manage.app.vo;

import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.manage.app.bean.BusinessRoleFunction;

public class BusinessRoleFunctionQuery extends BaseBean {
	

	private java.lang.Integer rofuId;
	private java.lang.Integer romeId;
	private java.lang.Integer functionId;

	private Map fieldMap;
	
	public BusinessRoleFunctionQuery(BusinessRoleFunction businessRoleFunction) {
		this.rofuId = businessRoleFunction.getRofuId();
		this.romeId = businessRoleFunction.getRomeId();
		this.functionId = businessRoleFunction.getFunctionId();
	}
	
	public BusinessRoleFunctionQuery() {
		
	}	
	
	public java.lang.Integer getRofuId() {
		return this.rofuId;
	}
	
	public void setRofuId(java.lang.Integer value) {
		this.rofuId = value;
	}
		
	public java.lang.Integer getRomeId() {
		return this.romeId;
	}
	
	public void setRomeId(java.lang.Integer value) {
		this.romeId = value;
	}
		
	public java.lang.Integer getFunctionId() {
		return this.functionId;
	}
	
	public void setFunctionId(java.lang.Integer value) {
		this.functionId = value;
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

