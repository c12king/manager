package com.manage.app.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.manage.app.bean.ManageModule;
import com.manage.app.vo.BaseBean;

public class ManageModuleQuery extends BaseBean {
	

	private java.lang.Integer moduleId;
	private java.lang.String moduleName;
	private java.lang.String moduleDesc;
	private java.lang.String moduleIcon;
	private java.lang.String moduleUrl;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public ManageModuleQuery(ManageModule manageModule) {
		this.moduleId = manageModule.getModuleId();
		this.moduleName = manageModule.getModuleName();
		this.moduleDesc = manageModule.getModuleDesc();
		this.moduleIcon = manageModule.getModuleIcon();
		this.moduleUrl = manageModule.getModuleUrl();
		this.createTime = manageModule.getCreateTime();
		this.editTime = manageModule.getEditTime();
		this.editor = manageModule.getEditor();
	}
	
	public ManageModuleQuery() {
		
	}	
	
	public java.lang.Integer getModuleId() {
		return this.moduleId;
	}
	
	public void setModuleId(java.lang.Integer value) {
		this.moduleId = value;
	}
		
	public java.lang.String getModuleName() {
		return this.moduleName;
	}
	
	public void setModuleName(java.lang.String value) {
		this.moduleName = value;
	}
		
	public java.lang.String getModuleDesc() {
		return this.moduleDesc;
	}
	
	public void setModuleDesc(java.lang.String value) {
		this.moduleDesc = value;
	}
		
	public java.lang.String getModuleIcon() {
		return this.moduleIcon;
	}
	
	public void setModuleIcon(java.lang.String value) {
		this.moduleIcon = value;
	}
		
	public java.lang.String getModuleUrl() {
		return this.moduleUrl;
	}
	
	public void setModuleUrl(java.lang.String value) {
		this.moduleUrl = value;
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

