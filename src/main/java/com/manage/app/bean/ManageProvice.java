package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class ManageProvice implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "ManageProvice";

	private java.lang.Integer proviceId;
	private java.lang.String provinceName;
	private java.lang.String provinceCode;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public ManageProvice(){
	}

	public ManageProvice(
		java.lang.Integer proviceId
	){
		this.proviceId = proviceId;
	}

	public void setProviceId(java.lang.Integer value) {
		this.proviceId = value;
	}
	
	public java.lang.Integer getProviceId() {
		return this.proviceId;
	}
	public void setProvinceName(java.lang.String value) {
		this.provinceName = value;
	}
	
	public java.lang.String getProvinceName() {
		return this.provinceName;
	}
	public void setProvinceCode(java.lang.String value) {
		this.provinceCode = value;
	}
	
	public java.lang.String getProvinceCode() {
		return this.provinceCode;
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
			.append("ProviceId",getProviceId())
			.append("ProvinceName",getProvinceName())
			.append("ProvinceCode",getProvinceCode())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getProviceId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ManageProvice == false) return false;
		if(this == obj) return true;
		ManageProvice other = (ManageProvice)obj;
		return new EqualsBuilder()
			.append(getProviceId(),other.getProviceId())
			.isEquals();
	}
}

