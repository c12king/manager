package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessRoleFunction implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessRoleFunction";

	private java.lang.Integer rofuId;
	private java.lang.Integer romeId;
	private java.lang.Integer functionId;

	public BusinessRoleFunction(){
	}

	public BusinessRoleFunction(
		java.lang.Integer rofuId
	){
		this.rofuId = rofuId;
	}

	public void setRofuId(java.lang.Integer value) {
		this.rofuId = value;
	}
	
	public java.lang.Integer getRofuId() {
		return this.rofuId;
	}
	public void setRomeId(java.lang.Integer value) {
		this.romeId = value;
	}
	
	public java.lang.Integer getRomeId() {
		return this.romeId;
	}
	public void setFunctionId(java.lang.Integer value) {
		this.functionId = value;
	}
	
	public java.lang.Integer getFunctionId() {
		return this.functionId;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("RofuId",getRofuId())
			.append("RomeId",getRomeId())
			.append("FunctionId",getFunctionId())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRofuId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessRoleFunction == false) return false;
		if(this == obj) return true;
		BusinessRoleFunction other = (BusinessRoleFunction)obj;
		return new EqualsBuilder()
			.append(getRofuId(),other.getRofuId())
			.isEquals();
	}
}

