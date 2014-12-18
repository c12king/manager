package com.manage.app.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.manage.app.bean.BusinessProperty;
import com.manage.app.vo.BaseBean;

public class BusinessPropertyQuery extends BaseBean {
	

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

	public BusinessPropertyQuery(BusinessProperty businessProperty) {
		this.proId = businessProperty.getProId();
		this.orgId = businessProperty.getOrgId();
		this.proName = businessProperty.getProName();
		this.proBrief = businessProperty.getProBrief();
		this.proService = businessProperty.getProService();
		this.proTel = businessProperty.getProTel();
		this.proEmail = businessProperty.getProEmail();
		this.proWeixin = businessProperty.getProWeixin();
		this.proIcon = businessProperty.getProIcon();
		this.proLongitude = businessProperty.getProLongitude();
		this.proLatitude = businessProperty.getProLatitude();
		this.crateTime = businessProperty.getCrateTime();
		this.editTime = businessProperty.getEditTime();
		this.editor = businessProperty.getEditor();
	}
	
	public BusinessPropertyQuery() {
		
	}	
	
	public java.lang.Integer getProId() {
		return this.proId;
	}
	
	public void setProId(java.lang.Integer value) {
		this.proId = value;
	}
		
	public java.lang.Integer getOrgId() {
		return this.orgId;
	}
	
	public void setOrgId(java.lang.Integer value) {
		this.orgId = value;
	}
		
	public java.lang.String getProName() {
		return this.proName;
	}
	
	public void setProName(java.lang.String value) {
		this.proName = value;
	}
		
	public java.lang.String getProBrief() {
		return this.proBrief;
	}
	
	public void setProBrief(java.lang.String value) {
		this.proBrief = value;
	}
		
	public java.lang.String getProService() {
		return this.proService;
	}
	
	public void setProService(java.lang.String value) {
		this.proService = value;
	}
		
	public java.lang.String getProTel() {
		return this.proTel;
	}
	
	public void setProTel(java.lang.String value) {
		this.proTel = value;
	}
		
	public java.lang.String getProEmail() {
		return this.proEmail;
	}
	
	public void setProEmail(java.lang.String value) {
		this.proEmail = value;
	}
		
	public java.lang.String getProWeixin() {
		return this.proWeixin;
	}
	
	public void setProWeixin(java.lang.String value) {
		this.proWeixin = value;
	}
		
	public java.lang.String getProIcon() {
		return this.proIcon;
	}
	
	public void setProIcon(java.lang.String value) {
		this.proIcon = value;
	}
		
	public java.lang.Double getProLongitude() {
		return this.proLongitude;
	}
	
	public void setProLongitude(java.lang.Double value) {
		this.proLongitude = value;
	}
		
	public java.lang.Double getProLatitude() {
		return this.proLatitude;
	}
	
	public void setProLatitude(java.lang.Double value) {
		this.proLatitude = value;
	}
		
	public java.sql.Timestamp getCrateTime() {
		return this.crateTime;
	}
	
	public void setCrateTime(java.sql.Timestamp value) {
		this.crateTime = value;
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

