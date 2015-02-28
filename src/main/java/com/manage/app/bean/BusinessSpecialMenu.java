package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessSpecialMenu implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessSpecialMenu";

	private java.lang.Integer spmeId;
	private java.lang.Integer refuId;
	private java.lang.Integer menuId;
	private java.lang.Integer no;
	private String menuName;

	public BusinessSpecialMenu(){
	}

	public BusinessSpecialMenu(
		java.lang.Integer spmeId
	){
		this.spmeId = spmeId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public void setSpmeId(java.lang.Integer value) {
		this.spmeId = value;
	}
	
	public java.lang.Integer getSpmeId() {
		return this.spmeId;
	}
	public void setRefuId(java.lang.Integer value) {
		this.refuId = value;
	}
	
	public java.lang.Integer getRefuId() {
		return this.refuId;
	}
	public void setMenuId(java.lang.Integer value) {
		this.menuId = value;
	}
	
	public java.lang.Integer getMenuId() {
		return this.menuId;
	}
	public void setNo(java.lang.Integer value) {
		this.no = value;
	}
	
	public java.lang.Integer getNo() {
		return this.no;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("SpmeId",getSpmeId())
			.append("RefuId",getRefuId())
			.append("MenuId",getMenuId())
			.append("No",getNo())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getSpmeId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessSpecialMenu == false) return false;
		if(this == obj) return true;
		BusinessSpecialMenu other = (BusinessSpecialMenu)obj;
		return new EqualsBuilder()
			.append(getSpmeId(),other.getSpmeId())
			.isEquals();
	}
}

