package com.manage.app.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class ManageHouse implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "ManageHouse";

	private java.lang.Integer houseId;
	private java.lang.Integer unitId;
	private java.lang.String houseNo;
	private java.lang.Double estateLongitude;
	private java.lang.Double estateLatitude;
	private Integer isBind;
	private java.lang.Integer memberId;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public ManageHouse(){
	}

	public ManageHouse(
		java.lang.Integer houseId
	){
		this.houseId = houseId;
	}

	public void setHouseId(java.lang.Integer value) {
		this.houseId = value;
	}
	
	public java.lang.Integer getHouseId() {
		return this.houseId;
	}
	public void setUnitId(java.lang.Integer value) {
		this.unitId = value;
	}
	
	public java.lang.Integer getUnitId() {
		return this.unitId;
	}
	public void setHouseNo(java.lang.String value) {
		this.houseNo = value;
	}
	
	public java.lang.String getHouseNo() {
		return this.houseNo;
	}
	public void setEstateLongitude(java.lang.Double value) {
		this.estateLongitude = value;
	}
	
	public java.lang.Double getEstateLongitude() {
		return this.estateLongitude;
	}
	public void setEstateLatitude(java.lang.Double value) {
		this.estateLatitude = value;
	}
	
	public java.lang.Double getEstateLatitude() {
		return this.estateLatitude;
	}
	public void setIsBind(Integer value) {
		this.isBind = value;
	}
	
	public Integer getIsBind() {
		return this.isBind;
	}
	public void setMemberId(java.lang.Integer value) {
		this.memberId = value;
	}
	
	public java.lang.Integer getMemberId() {
		return this.memberId;
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
			.append("HouseId",getHouseId())
			.append("UnitId",getUnitId())
			.append("HouseNo",getHouseNo())
			.append("EstateLongitude",getEstateLongitude())
			.append("EstateLatitude",getEstateLatitude())
			.append("IsBind",getIsBind())
			.append("MemberId",getMemberId())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getHouseId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ManageHouse == false) return false;
		if(this == obj) return true;
		ManageHouse other = (ManageHouse)obj;
		return new EqualsBuilder()
			.append(getHouseId(),other.getHouseId())
			.isEquals();
	}
}

