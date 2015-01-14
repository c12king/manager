package com.manage.app.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.manage.app.bean.BusinessShop;

public class BusinessShopQuery extends BaseBean {
	

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

	public BusinessShopQuery(BusinessShop businessShop) {
		this.shopId = businessShop.getShopId();
		this.shopCode = businessShop.getShopCode();
		this.shopKey = businessShop.getShopKey();
		this.shopName = businessShop.getShopName();
		this.shopImg = businessShop.getShopImg();
		this.shopDesc = businessShop.getShopDesc();
		this.shopAddr = businessShop.getShopAddr();
		this.shopUrl = businessShop.getShopUrl();
		this.typeId = businessShop.getTypeId();
		this.creatTime = businessShop.getCreatTime();
		this.editTime = businessShop.getEditTime();
		this.editor = businessShop.getEditor();
	}
	
	public BusinessShopQuery() {
		
	}	
	
	public java.lang.Integer getShopId() {
		return this.shopId;
	}
	
	public void setShopId(java.lang.Integer value) {
		this.shopId = value;
	}
		
	public java.lang.String getShopCode() {
		return this.shopCode;
	}
	
	public void setShopCode(java.lang.String value) {
		this.shopCode = value;
	}
		
	public java.lang.String getShopKey() {
		return this.shopKey;
	}
	
	public void setShopKey(java.lang.String value) {
		this.shopKey = value;
	}
		
	public java.lang.String getShopName() {
		return this.shopName;
	}
	
	public void setShopName(java.lang.String value) {
		this.shopName = value;
	}
		
	public java.lang.String getShopImg() {
		return this.shopImg;
	}
	
	public void setShopImg(java.lang.String value) {
		this.shopImg = value;
	}
		
	public java.lang.String getShopDesc() {
		return this.shopDesc;
	}
	
	public void setShopDesc(java.lang.String value) {
		this.shopDesc = value;
	}
		
	public java.lang.String getShopAddr() {
		return this.shopAddr;
	}
	
	public void setShopAddr(java.lang.String value) {
		this.shopAddr = value;
	}
		
	public java.lang.String getShopUrl() {
		return this.shopUrl;
	}
	
	public void setShopUrl(java.lang.String value) {
		this.shopUrl = value;
	}
		
	public java.lang.Integer getTypeId() {
		return this.typeId;
	}
	
	public void setTypeId(java.lang.Integer value) {
		this.typeId = value;
	}
		
	public java.sql.Timestamp getCreatTime() {
		return this.creatTime;
	}
	
	public void setCreatTime(java.sql.Timestamp value) {
		this.creatTime = value;
	}
		
	public java.sql.Timestamp getEditTime() {
		return this.editTime;
	}
	
	public void setEditTime(java.sql.Timestamp value) {
		this.editTime = value;
	}
		
	public java.lang.String getEditor() {
		return this.editor;
	}
	
	public void setEditor(java.lang.String value) {
		this.editor = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

