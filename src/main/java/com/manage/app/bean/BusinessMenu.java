package com.manage.app.bean;



import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class BusinessMenu implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessMenu";

	private java.lang.Integer menuId;
	private java.lang.String name;
	private java.lang.String url;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp modifyTime;
	private java.lang.String editor;
	private java.lang.Integer parentId;
	private java.lang.Integer ord;
	private java.lang.Integer leaf;
	private java.lang.String selectedIcon;
	private java.lang.String unSelectedIcon;
	private String code;

	public BusinessMenu(){
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BusinessMenu(
		java.lang.Integer menuId
	){
		this.menuId = menuId;
	}

	public void setMenuId(java.lang.Integer value) {
		this.menuId = value;
	}
	
	public java.lang.Integer getMenuId() {
		return this.menuId;
	}
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	public void setUrl(java.lang.String value) {
		this.url = value;
	}
	
	public java.lang.String getUrl() {
		return this.url;
	}
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
	
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	public void setModifyTime(java.sql.Timestamp value) {
		this.modifyTime = value;
	}
	
	public java.sql.Timestamp getModifyTime() {
		return this.modifyTime;
	}
	public void setEditor(java.lang.String value) {
		this.editor = value;
	}
	
	public java.lang.String getEditor() {
		return this.editor;
	}
	public void setParentId(java.lang.Integer value) {
		this.parentId = value;
	}
	
	public java.lang.Integer getParentId() {
		return this.parentId;
	}
	public void setOrd(java.lang.Integer value) {
		this.ord = value;
	}
	
	public java.lang.Integer getOrd() {
		return this.ord;
	}
	public void setLeaf(java.lang.Integer value) {
		this.leaf = value;
	}
	
	public java.lang.Integer getLeaf() {
		return this.leaf;
	}
	

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("MenuId",getMenuId())
			.append("Name",getName())
			.append("Url",getUrl())
			.append("CreateTime",getCreateTime())
			.append("ModifyTime",getModifyTime())
			.append("Editor",getEditor())
			.append("ParentId",getParentId())
			.append("Ord",getOrd())
			.append("Leaf",getLeaf())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getMenuId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessMenu == false) return false;
		if(this == obj) return true;
		BusinessMenu other = (BusinessMenu)obj;
		return new EqualsBuilder()
			.append(getMenuId(),other.getMenuId())
			.isEquals();
	}

	public java.lang.String getSelectedIcon() {
		return selectedIcon;
	}

	public void setSelectedIcon(java.lang.String selectedIcon) {
		this.selectedIcon = selectedIcon;
	}

	public java.lang.String getUnSelectedIcon() {
		return unSelectedIcon;
	}

	public void setUnSelectedIcon(java.lang.String unSelectedIcon) {
		this.unSelectedIcon = unSelectedIcon;
	}
	
}

