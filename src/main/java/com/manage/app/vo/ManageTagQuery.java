package com.manage.app.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.manage.app.bean.ManageTag;

public class ManageTagQuery extends BaseBean {
	

	private java.lang.Integer tagId;
	private java.lang.String title;
	private java.lang.String tagDesc;
	private java.lang.String tagPic;
	private java.lang.Integer typeId;
	private java.lang.Integer tagType;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public ManageTagQuery(ManageTag manageTag) {
		this.tagId = manageTag.getTagId();
		this.title = manageTag.getTitle();
		this.tagDesc = manageTag.getTagDesc();
		this.tagPic = manageTag.getTagPic();
		this.typeId = manageTag.getTypeId();
		this.tagType = manageTag.getTagType();
		this.createTime = manageTag.getCreateTime();
		this.editTime = manageTag.getEditTime();
		this.editor = manageTag.getEditor();
	}
	
	public ManageTagQuery() {
		
	}	
	
	public java.lang.Integer getTagId() {
		return this.tagId;
	}
	
	public void setTagId(java.lang.Integer value) {
		this.tagId = value;
	}
		
	public java.lang.String getTitle() {
		return this.title;
	}
	
	public void setTitle(java.lang.String value) {
		this.title = value;
	}
		
	public java.lang.String getTagDesc() {
		return this.tagDesc;
	}
	
	public void setTagDesc(java.lang.String value) {
		this.tagDesc = value;
	}
		
	public java.lang.String getTagPic() {
		return this.tagPic;
	}
	
	public void setTagPic(java.lang.String value) {
		this.tagPic = value;
	}
		
	public java.lang.Integer getTypeId() {
		return this.typeId;
	}
	
	public void setTypeId(java.lang.Integer value) {
		this.typeId = value;
	}
		
	public java.lang.Integer getTagType() {
		return this.tagType;
	}
	
	public void setTagType(java.lang.Integer value) {
		this.tagType = value;
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

