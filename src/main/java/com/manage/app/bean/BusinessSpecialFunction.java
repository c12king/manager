package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessSpecialFunction implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessSpecialFunction";

	private java.lang.Integer spfuId;
	private java.lang.Integer spmeId;
	private java.lang.Integer functionId;
	private String functionName;

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public BusinessSpecialFunction(){
	}

	public BusinessSpecialFunction(
		java.lang.Integer spfuId
	){
		this.spfuId = spfuId;
	}

	public void setSpfuId(java.lang.Integer value) {
		this.spfuId = value;
	}
	
	public java.lang.Integer getSpfuId() {
		return this.spfuId;
	}
	public void setSpmeId(java.lang.Integer value) {
		this.spmeId = value;
	}
	
	public java.lang.Integer getSpmeId() {
		return this.spmeId;
	}
	public void setFunctionId(java.lang.Integer value) {
		this.functionId = value;
	}
	
	public java.lang.Integer getFunctionId() {
		return this.functionId;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("SpfuId",getSpfuId())
			.append("SpmeId",getSpmeId())
			.append("FunctionId",getFunctionId())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getSpfuId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessSpecialFunction == false) return false;
		if(this == obj) return true;
		BusinessSpecialFunction other = (BusinessSpecialFunction)obj;
		return new EqualsBuilder()
			.append(getSpfuId(),other.getSpfuId())
			.isEquals();
	}
}

