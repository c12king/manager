package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessShop implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//别名
	public static final String TABLE_ALIAS = "BusinessShop";

	private java.lang.Integer shopId;
	private java.lang.String shopCode;
	private java.lang.String shopKey;
	private java.lang.String shopName;
	private java.lang.String shopImg;
	private java.lang.String shopDesc;
	private java.lang.String shopAddr;
	private java.lang.String shopUrl;
	private java.lang.Integer typeId;
	private java.sql.Timestamp creatTime;


	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	private java.lang.String typeName;
	
	public BusinessShop(){
	}

	public BusinessShop(
		java.lang.Integer shopId
	){
		this.shopId = shopId;
	}

	public void setShopId(java.lang.Integer value) {
		this.shopId = value;
	}
	
	public java.lang.Integer getShopId() {
		return this.shopId;
	}
	public void setShopCode(java.lang.String value) {
		this.shopCode = value;
	}
	
	public java.lang.String getShopCode() {
		return this.shopCode;
	}
	public void setShopKey(java.lang.String value) {
		this.shopKey = value;
	}
	
	public java.lang.String getShopKey() {
		return this.shopKey;
	}
	public void setShopName(java.lang.String value) {
		this.shopName = value;
	}
	
	public java.lang.String getShopName() {
		return this.shopName;
	}
	public void setShopImg(java.lang.String value) {
		this.shopImg = value;
	}
	
	public java.lang.String getShopImg() {
		return this.shopImg;
	}
	public void setShopDesc(java.lang.String value) {
		this.shopDesc = value;
	}
	
	public java.lang.String getShopDesc() {
		return this.shopDesc;
	}
	public void setShopAddr(java.lang.String value) {
		this.shopAddr = value;
	}
	
	public java.lang.String getShopAddr() {
		return this.shopAddr;
	}
	public void setShopUrl(java.lang.String value) {
		this.shopUrl = value;
	}
	
	public java.lang.String getShopUrl() {
		return this.shopUrl;
	}
	public void setTypeId(java.lang.Integer value) {
		this.typeId = value;
	}
	
	public java.lang.Integer getTypeId() {
		return this.typeId;
	}
	public void setCreatTime(java.sql.Timestamp value) {
		this.creatTime = value;
	}
	
	public java.sql.Timestamp getCreatTime() {
		return this.creatTime;
	}
	public void setEditTime(java.sql.Timestamp value) {
		this.editTime = value;
	}
	
	public java.sql.Timestamp getEditTime() {
		return this.editTime;
	}
	public void setEditor(java.lang.String value) {
		this.editor = value;
	}
	
	public java.lang.String getEditor() {
		return this.editor;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("ShopId",getShopId())
			.append("ShopCode",getShopCode())
			.append("ShopKey",getShopKey())
			.append("ShopName",getShopName())
			.append("ShopImg",getShopImg())
			.append("ShopDesc",getShopDesc())
			.append("ShopAddr",getShopAddr())
			.append("ShopUrl",getShopUrl())
			.append("TypeId",getTypeId())
			.append("TypeName",getTypeName())
			.append("CreatTime",getCreatTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getShopId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessShop == false) return false;
		if(this == obj) return true;
		BusinessShop other = (BusinessShop)obj;
		return new EqualsBuilder()
			.append(getShopId(),other.getShopId())
			.isEquals();
	}
	
	public java.lang.String getTypeName() {
		return typeName;
	}

	public void setTypeName(java.lang.String typeName) {
		this.typeName = typeName;
	}
}

