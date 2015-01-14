package com.manage.app.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.manage.app.bean.BusinessShopType;

public class BusinessShopTypeQuery extends BaseBean {
	

	private java.lang.Integer typeId;
	private java.lang.String typeName;

	public BusinessShopTypeQuery(BusinessShopType businessShopType) {
		this.typeId = businessShopType.getTypeId();
		this.typeName = businessShopType.getTypeName();
	}
	
	public BusinessShopTypeQuery() {
		
	}	
	
	public java.lang.Integer getTypeId() {
		return this.typeId;
	}
	
	public void setTypeId(java.lang.Integer value) {
		this.typeId = value;
	}
		
	public java.lang.String getTypeName() {
		return this.typeName;
	}
	
	public void setTypeName(java.lang.String value) {
		this.typeName = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

