package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class ManageTagType implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	//别名
	public static final String TABLE_ALIAS = "ManageTagType";

	private java.lang.Integer typeId;
	private java.lang.String tagTypeName;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public ManageTagType(){
	}

	public ManageTagType(
		java.lang.Integer typeId
	){
		this.typeId = typeId;
	}

	public void setTypeId(java.lang.Integer value) {
		this.typeId = value;
	}
	
	public java.lang.Integer getTypeId() {
		return this.typeId;
	}
	public void setTagTypeName(java.lang.String value) {
		this.tagTypeName = value;
	}
	
	public java.lang.String getTagTypeName() {
		return this.tagTypeName;
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
			.append("TypeId",getTypeId())
			.append("TagTypeName",getTagTypeName())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getTypeId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ManageTagType == false) return false;
		if(this == obj) return true;
		ManageTagType other = (ManageTagType)obj;
		return new EqualsBuilder()
			.append(getTypeId(),other.getTypeId())
			.isEquals();
	}
}

