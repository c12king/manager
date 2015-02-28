package com.manage.app.vo;

import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.manage.app.bean.BusinessSpecialFunction;

public class BusinessSpecialFunctionQuery extends BaseBean {
	

	private java.lang.Integer spfuId;
	private java.lang.Integer spmeId;
	private java.lang.Integer functionId;

	private Map fieldMap;
	
	public BusinessSpecialFunctionQuery(BusinessSpecialFunction businessSpecialFunction) {
		this.spfuId = businessSpecialFunction.getSpfuId();
		this.spmeId = businessSpecialFunction.getSpmeId();
		this.functionId = businessSpecialFunction.getFunctionId();
	}
	
	public BusinessSpecialFunctionQuery() {
		
	}	
	
	public java.lang.Integer getSpfuId() {
		return this.spfuId;
	}
	
	public void setSpfuId(java.lang.Integer value) {
		this.spfuId = value;
	}
		
	public java.lang.Integer getSpmeId() {
		return this.spmeId;
	}
	
	public void setSpmeId(java.lang.Integer value) {
		this.spmeId = value;
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

