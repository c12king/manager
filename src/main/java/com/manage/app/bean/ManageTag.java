package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class ManageTag implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "ManageTag";

	private java.lang.Integer tagId;
	private java.lang.String title;
	private java.lang.String tagDesc;
	private java.lang.String tagPic;
	private java.lang.Integer typeId;
	private java.lang.Integer tagType;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public ManageTag(){
	}

	public ManageTag(
		java.lang.Integer tagId
	){
		this.tagId = tagId;
	}

	public void setTagId(java.lang.Integer value) {
		this.tagId = value;
	}
	
	public java.lang.Integer getTagId() {
		return this.tagId;
	}
	public void setTitle(java.lang.String value) {
		this.title = value;
	}
	
	public java.lang.String getTitle() {
		return this.title;
	}
	public void setTagDesc(java.lang.String value) {
		this.tagDesc = value;
	}
	
	public java.lang.String getTagDesc() {
		return this.tagDesc;
	}
	public void setTagPic(java.lang.String value) {
		this.tagPic = value;
	}
	
	public java.lang.String getTagPic() {
		return this.tagPic;
	}
	public void setTypeId(java.lang.Integer value) {
		this.typeId = value;
	}
	
	public java.lang.Integer getTypeId() {
		return this.typeId;
	}
	public void setTagType(java.lang.Integer value) {
		this.tagType = value;
	}
	
	public java.lang.Integer getTagType() {
		return this.tagType;
	}
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
	
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
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
			.append("TagId",getTagId())
			.append("Title",getTitle())
			.append("TagDesc",getTagDesc())
			.append("TagPic",getTagPic())
			.append("TypeId",getTypeId())
			.append("TagType",getTagType())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getTagId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ManageTag == false) return false;
		if(this == obj) return true;
		ManageTag other = (ManageTag)obj;
		return new EqualsBuilder()
			.append(getTagId(),other.getTagId())
			.isEquals();
	}
}

