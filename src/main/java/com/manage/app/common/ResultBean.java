package com.manage.app.common;

import java.io.Serializable;

public class ResultBean implements Serializable {

	private String timeField;//时间
	private String weekField;//周号  周直接用数值表达，比较特殊
	private String timeValue;//统计值
	private String timePercent;//占比
	private String title;//标题
	
	private String field1;
	private String field2;
	private String field3;
	private String field4;
	private String field5;
	private String field6;
	private String field7;
	private String field8;
	private String field9;
	private String field10;
	
	public String getWeekField() {
		return weekField;
	}
	public void setWeekField(String weekField) {
		this.weekField = weekField;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTimeField() {
		return timeField;
	}
	public void setTimeField(String timeField) {
		this.timeField = timeField;
	}
	public String getTimeValue() {
		return timeValue;
	}
	public void setTimeValue(String timeValue) {
		this.timeValue = timeValue;
	}
	public String getTimePercent() {
		return timePercent;
	}
	public void setTimePercent(String timePercent) {
		this.timePercent = timePercent;
	}
	
}
