package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class BusinessPosition implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "ManagePosition";

	private java.lang.Integer positionId;
	private java.lang.Integer orgId;
	private java.lang.String orgName;
	private java.lang.Integer parentId;
	private java.lang.String parentName;
	private java.lang.String positionCode;
	private Integer positionState;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.Integer ord;
	private Integer leaf;
	private java.lang.String positionName;
	private java.lang.Integer depId;
	private java.lang.String depName;
	private java.lang.String orgType;
	public java.lang.Integer getDepId() {
		return depId;
	}

	public void setDepId(java.lang.Integer depId) {
		this.depId = depId;
	}

	public java.lang.String getDepName() {
		return depName;
	}

	public void setDepName(java.lang.String depName) {
		this.depName = depName;
	}

	public BusinessPosition(){
	}

	public BusinessPosition(
		java.lang.Integer positionId
	){
		this.positionId = positionId;
	}

	public void setPositionId(java.lang.Integer value) {
		this.positionId = value;
	}
	
	public java.lang.Integer getPositionId() {
		return this.positionId;
	}
	public void setOrgId(java.lang.Integer value) {
		this.orgId = value;
	}
	
	public java.lang.Integer getOrgId() {
		return this.orgId;
	}
	public void setOrgName(java.lang.String value) {
		this.orgName = value;
	}
	
	public java.lang.String getOrgName() {
		return this.orgName;
	}
	public void setParentId(java.lang.Integer value) {
		this.parentId = value;
	}
	
	public java.lang.Integer getParentId() {
		return this.parentId;
	}
	public void setParentName(java.lang.String value) {
		this.parentName = value;
	}
	
	public java.lang.String getParentName() {
		return this.parentName;
	}
	public void setPositionCode(java.lang.String value) {
		this.positionCode = value;
	}
	
	public java.lang.String getPositionCode() {
		return this.positionCode;
	}
	public void setPositionState(Integer value) {
		this.positionState = value;
	}
	
	public Integer getPositionState() {
		return this.positionState;
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
	public void setOrd(java.lang.Integer value) {
		this.ord = value;
	}
	
	public java.lang.Integer getOrd() {
		return this.ord;
	}
	public void setLeaf(Integer value) {
		this.leaf = value;
	}
	
	public Integer getLeaf() {
		return this.leaf;
	}
	public void setPositionName(java.lang.String value) {
		this.positionName = value;
	}
	
	public java.lang.String getPositionName() {
		return this.positionName;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("PositionId",getPositionId())
			.append("OrgId",getOrgId())
			.append("OrgName",getOrgName())
			.append("ParentId",getParentId())
			.append("ParentName",getParentName())
			.append("PositionCode",getPositionCode())
			.append("PositionState",getPositionState())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.append("Ord",getOrd())
			.append("Leaf",getLeaf())
			.append("PositionName",getPositionName())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getPositionId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessPosition == false) return false;
		if(this == obj) return true;
		BusinessPosition other = (BusinessPosition)obj;
		return new EqualsBuilder()
			.append(getPositionId(),other.getPositionId())
			.isEquals();
	}

	public java.lang.String getOrgType() {
		return orgType;
	}

	public void setOrgType(java.lang.String orgType) {
		this.orgType = orgType;
	}
}

