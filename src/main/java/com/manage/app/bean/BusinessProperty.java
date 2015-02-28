package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessProperty implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessProperty";

	private java.lang.Integer proId;
	private java.lang.Integer orgId;
	private java.lang.String proName;
	private java.lang.String proBrief;
	private java.lang.String proService;
	private java.lang.String proTel;
	private java.lang.String proEmail;
	private java.lang.String proWeixin;
	private java.lang.String proIcon;
	private java.lang.Double proLongitude;
	private java.lang.Double proLatitude;
	private java.sql.Timestamp crateTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.String orgName;
	private java.lang.String proCode;

	public java.lang.String getOrgName() {
		return orgName;
	}

	public void setOrgName(java.lang.String orgName) {
		this.orgName = orgName;
	}

	public BusinessProperty(){
	}

	public BusinessProperty(
		java.lang.Integer proId
	){
		this.proId = proId;
	}

	public void setProId(java.lang.Integer value) {
		this.proId = value;
	}
	
	public java.lang.Integer getProId() {
		return this.proId;
	}
	public void setOrgId(java.lang.Integer value) {
		this.orgId = value;
	}
	
	public java.lang.Integer getOrgId() {
		return this.orgId;
	}
	public void setProName(java.lang.String value) {
		this.proName = value;
	}
	
	public java.lang.String getProName() {
		return this.proName;
	}
	public void setProBrief(java.lang.String value) {
		this.proBrief = value;
	}
	
	public java.lang.String getProBrief() {
		return this.proBrief;
	}
	public void setProService(java.lang.String value) {
		this.proService = value;
	}
	
	public java.lang.String getProService() {
		return this.proService;
	}
	public void setProTel(java.lang.String value) {
		this.proTel = value;
	}
	
	public java.lang.String getProTel() {
		return this.proTel;
	}
	public void setProEmail(java.lang.String value) {
		this.proEmail = value;
	}
	
	public java.lang.String getProEmail() {
		return this.proEmail;
	}
	public void setProWeixin(java.lang.String value) {
		this.proWeixin = value;
	}
	
	public java.lang.String getProWeixin() {
		return this.proWeixin;
	}
	public void setProIcon(java.lang.String value) {
		this.proIcon = value;
	}
	
	public java.lang.String getProIcon() {
		return this.proIcon;
	}
	public void setProLongitude(java.lang.Double value) {
		this.proLongitude = value;
	}
	
	public java.lang.Double getProLongitude() {
		return this.proLongitude;
	}
	public void setProLatitude(java.lang.Double value) {
		this.proLatitude = value;
	}
	
	public java.lang.Double getProLatitude() {
		return this.proLatitude;
	}
	public void setCrateTime(java.sql.Timestamp value) {
		this.crateTime = value;
	}
	
	public java.sql.Timestamp getCrateTime() {
		return this.crateTime;
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
			.append("ProId",getProId())
			.append("OrgId",getOrgId())
			.append("ProName",getProName())
			.append("ProBrief",getProBrief())
			.append("ProService",getProService())
			.append("ProTel",getProTel())
			.append("ProEmail",getProEmail())
			.append("ProWeixin",getProWeixin())
			.append("ProIcon",getProIcon())
			.append("ProLongitude",getProLongitude())
			.append("ProLatitude",getProLatitude())
			.append("CrateTime",getCrateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getProId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessProperty == false) return false;
		if(this == obj) return true;
		BusinessProperty other = (BusinessProperty)obj;
		return new EqualsBuilder()
			.append(getProId(),other.getProId())
			.isEquals();
	}

	public java.lang.String getProCode() {
		return proCode;
	}

	public void setProCode(java.lang.String proCode) {
		this.proCode = proCode;
	}
	
}

