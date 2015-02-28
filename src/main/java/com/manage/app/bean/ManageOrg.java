package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class ManageOrg implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "ManageOrg";

	private java.lang.Integer orgId;
	private java.lang.String orgName;
	private java.lang.String orgDesc;
	private java.lang.Integer parentId;
	private java.lang.String orgCode;
	private Integer orgState;
	private java.lang.String orgTypeCode;
	private java.lang.Double orgLongitude;
	private java.lang.Double orgLatitude;
	private java.lang.String orgIcon;
	private java.lang.String orgTel;
	private java.lang.String orgEmail;
	private java.lang.String orgWeixin;
	private java.lang.String orgSubType;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.Integer leaf;
	private java.lang.Integer ord;
	private java.lang.Integer countyId;

	public ManageOrg(){
	}

	public ManageOrg(
		java.lang.Integer orgId
	){
		this.orgId = orgId;
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
	public void setOrgDesc(java.lang.String value) {
		this.orgDesc = value;
	}
	
	public java.lang.String getOrgDesc() {
		return this.orgDesc;
	}
	public void setParentId(java.lang.Integer value) {
		this.parentId = value;
	}
	
	public java.lang.Integer getParentId() {
		return this.parentId;
	}
	public void setOrgCode(java.lang.String value) {
		this.orgCode = value;
	}
	
	public java.lang.String getOrgCode() {
		return this.orgCode;
	}
	public void setOrgState(Integer value) {
		this.orgState = value;
	}
	
	public Integer getOrgState() {
		return this.orgState;
	}
	public void setOrgTypeCode(java.lang.String value) {
		this.orgTypeCode = value;
	}
	
	public java.lang.String getOrgTypeCode() {
		return this.orgTypeCode;
	}
	public void setOrgLongitude(java.lang.Double value) {
		this.orgLongitude = value;
	}
	
	public java.lang.Double getOrgLongitude() {
		return this.orgLongitude;
	}
	public void setOrgLatitude(java.lang.Double value) {
		this.orgLatitude = value;
	}
	
	public java.lang.Double getOrgLatitude() {
		return this.orgLatitude;
	}
	public void setOrgIcon(java.lang.String value) {
		this.orgIcon = value;
	}
	
	public java.lang.String getOrgIcon() {
		return this.orgIcon;
	}
	public void setOrgTel(java.lang.String value) {
		this.orgTel = value;
	}
	
	public java.lang.String getOrgTel() {
		return this.orgTel;
	}
	public void setOrgEmail(java.lang.String value) {
		this.orgEmail = value;
	}
	
	public java.lang.String getOrgEmail() {
		return this.orgEmail;
	}
	public void setOrgWeixin(java.lang.String value) {
		this.orgWeixin = value;
	}
	
	public java.lang.String getOrgWeixin() {
		return this.orgWeixin;
	}
	public void setOrgSubType(java.lang.String value) {
		this.orgSubType = value;
	}
	
	public java.lang.String getOrgSubType() {
		return this.orgSubType;
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
	public void setLeaf(java.lang.Integer value) {
		this.leaf = value;
	}
	
	public java.lang.Integer getLeaf() {
		return this.leaf;
	}
	public void setOrd(java.lang.Integer value) {
		this.ord = value;
	}
	
	public java.lang.Integer getOrd() {
		return this.ord;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("OrgId",getOrgId())
			.append("OrgName",getOrgName())
			.append("OrgDesc",getOrgDesc())
			.append("ParentId",getParentId())
			.append("OrgCode",getOrgCode())
			.append("OrgState",getOrgState())
			.append("OrgTypeCode",getOrgTypeCode())
			.append("OrgLongitude",getOrgLongitude())
			.append("OrgLatitude",getOrgLatitude())
			.append("OrgIcon",getOrgIcon())
			.append("OrgTel",getOrgTel())
			.append("OrgEmail",getOrgEmail())
			.append("OrgWeixin",getOrgWeixin())
			.append("OrgSubType",getOrgSubType())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.append("Leaf",getLeaf())
			.append("Ord",getOrd())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getOrgId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ManageOrg == false) return false;
		if(this == obj) return true;
		ManageOrg other = (ManageOrg)obj;
		return new EqualsBuilder()
			.append(getOrgId(),other.getOrgId())
			.isEquals();
	}

	public java.lang.Integer getCountyId() {
		return countyId;
	}

	public void setCountyId(java.lang.Integer countyId) {
		this.countyId = countyId;
	}
	
}

