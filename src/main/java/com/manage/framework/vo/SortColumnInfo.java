package com.manage.framework.vo;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SortColumnInfo implements Serializable{

	private String columnName;
	private String sortOrder;
	
	public SortColumnInfo() {
		
	}
	
	public SortColumnInfo(String columnName, String sortOrder) {
		this.columnName = columnName;
		this.sortOrder = sortOrder;
	}
	
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	
	public static List<SortColumnInfo> parseSortColumns(String sortColumns) {
		if (sortColumns == null) {
			return new ArrayList(0);
		}
		List results = new ArrayList();
		String[] sortSegments = sortColumns.trim().split(",");
		for (int i = 0; i < sortSegments.length; ++i) {
			String sortSegment = sortSegments[i];
		    String[] array = sortSegment.split("\\s+");
		    SortColumnInfo sortInfo = new SortColumnInfo();
		    sortInfo.setColumnName(array[0]);
		    sortInfo.setSortOrder((array.length == 2) ? array[1] : null);
		    results.add(sortInfo);
		 }
		 return results;
	}
	
	public String toString() {
		return this.columnName + ((this.sortOrder == null) ? "" : new StringBuilder().append(" ").append(this.sortOrder).toString());
	}
	
}
