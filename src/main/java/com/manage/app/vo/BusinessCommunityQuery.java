package com.manage.app.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.manage.app.bean.BusinessCommunity;
import com.manage.app.vo.BaseBean;

public class BusinessCommunityQuery extends BaseBean {
	

	private java.lang.Integer comId;
	private java.lang.Integer orgId;
	private java.lang.String comName;
	private java.lang.String comBrief;
	private java.lang.String comService;
	private java.lang.String comTel;
	private java.lang.String comEmail;
	private java.lang.String comWeixin;
	private java.lang.String comIcon;
	private java.lang.Double comLongitude;
	private java.lang.Double comLatitude;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public BusinessCommunityQuery(BusinessCommunity businessCommunity) {
		this.comId = businessCommunity.getComId();
		this.orgId = businessCommunity.getOrgId();
		this.comName = businessCommunity.getComName();
		this.comBrief = businessCommunity.getComBrief();
		this.comService = businessCommunity.getComService();
		this.comTel = businessCommunity.getComTel();
		this.comEmail = businessCommunity.getComEmail();
		this.comWeixin = businessCommunity.getComWeixin();
		this.comIcon = businessCommunity.getComIcon();
		this.comLongitude = businessCommunity.getComLongitude();
		this.comLatitude = businessCommunity.getComLatitude();
		this.createTime = businessCommunity.getCreateTime();
		this.editTime = businessCommunity.getEditTime();
		this.editor = businessCommunity.getEditor();
	}
	
	public BusinessCommunityQuery() {
		
	}	
	
	public java.lang.Integer getComId() {
		return this.comId;
	}
	
	public void setComId(java.lang.Integer value) {
		this.comId = value;
	}
		
	public java.lang.Integer getOrgId() {
		return this.orgId;
	}
	
	public void setOrgId(java.lang.Integer value) {
		this.orgId = value;
	}
		
	public java.lang.String getComName() {
		return this.comName;
	}
	
	public void setComName(java.lang.String value) {
		this.comName = value;
	}
		
	public java.lang.String getComBrief() {
		return this.comBrief;
	}
	
	public void setComBrief(java.lang.String value) {
		this.comBrief = value;
	}
		
	public java.lang.String getComService() {
		return this.comService;
	}
	
	public void setComService(java.lang.String value) {
		this.comService = value;
	}
		
	public java.lang.String getComTel() {
		return this.comTel;
	}
	
	public void setComTel(java.lang.String value) {
		this.comTel = value;
	}
		
	public java.lang.String getComEmail() {
		return this.comEmail;
	}
	
	public void setComEmail(java.lang.String value) {
		this.comEmail = value;
	}
		
	public java.lang.String getComWeixin() {
		return this.comWeixin;
	}
	
	public void setComWeixin(java.lang.String value) {
		this.comWeixin = value;
	}
		
	public java.lang.String getComIcon() {
		return this.comIcon;
	}
	
	public void setComIcon(java.lang.String value) {
		this.comIcon = value;
	}
		
	public java.lang.Double getComLongitude() {
		return this.comLongitude;
	}
	
	public void setComLongitude(java.lang.Double value) {
		this.comLongitude = value;
	}
		
	public java.lang.Double getComLatitude() {
		return this.comLatitude;
	}
	
	public void setComLatitude(java.lang.Double value) {
		this.comLatitude = value;
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

