package com.manage.app.vo;

import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.manage.app.bean.BusinessSpecialMenu;

public class BusinessSpecialMenuQuery extends BaseBean {
	

	private java.lang.Integer spmeId;
	private java.lang.Integer refuId;
	private java.lang.Integer menuId;
	private java.lang.Integer no;

	private Map fieldMap;
	
	public BusinessSpecialMenuQuery(BusinessSpecialMenu businessSpecialMenu) {
		this.spmeId = businessSpecialMenu.getSpmeId();
		this.refuId = businessSpecialMenu.getRefuId();
		this.menuId = businessSpecialMenu.getMenuId();
		this.no = businessSpecialMenu.getNo();
	}
	
	public BusinessSpecialMenuQuery() {
		
	}	
	
	public java.lang.Integer getSpmeId() {
		return this.spmeId;
	}
	
	public void setSpmeId(java.lang.Integer value) {
		this.spmeId = value;
	}
		
	public java.lang.Integer getRefuId() {
		return this.refuId;
	}
	
	public void setRefuId(java.lang.Integer value) {
		this.refuId = value;
	}
		
	public java.lang.Integer getMenuId() {
		return this.menuId;
	}
	
	public void setMenuId(java.lang.Integer value) {
		this.menuId = value;
	}
		
	public java.lang.Integer getNo() {
		return this.no;
	}
	
	public void setNo(java.lang.Integer value) {
		this.no = value;
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

