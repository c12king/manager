package com.manage.app.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.manage.app.bean.ManageTagType;

public class ManageTagTypeQuery extends BaseBean {
	

	private java.lang.Integer typeId;
	private java.lang.String tagTypeName;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public ManageTagTypeQuery(ManageTagType manageTagType) {
		this.typeId = manageTagType.getTypeId();
		this.tagTypeName = manageTagType.getTagTypeName();
		this.createTime = manageTagType.getCreateTime();
		this.editTime = manageTagType.getEditTime();
		this.editor = manageTagType.getEditor();
	}
	
	public ManageTagTypeQuery() {
		
	}	
	
	public java.lang.Integer getTypeId() {
		return this.typeId;
	}
	
	public void setTypeId(java.lang.Integer value) {
		this.typeId = value;
	}
		
	public java.lang.String getTagTypeName() {
		return this.tagTypeName;
	}
	
	public void setTagTypeName(java.lang.String value) {
		this.tagTypeName = value;
	}
		
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
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

