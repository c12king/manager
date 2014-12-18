package com.manage.framework.vo;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PageDataVO<T> implements Serializable{

	/** 过滤类 */
	protected T filter;
	/** 数据集合 */
	protected List<T> result = new ArrayList();
	/** 每页记录 */
	protected int pageSize = 20;
	/** 初始当前页 */
	protected int currentPage = 1;
	/** 排序语句 */
	protected String orderBy = null;
	
	public PageDataVO() {
		this(20,1);
	}

	public PageDataVO(int pageSize, int pageNo) {
		this(null, pageSize, pageNo);
	}
	
	public PageDataVO(T filters, int pageSize, int pageNo) {
		this(filters, pageSize, pageNo, null);
	}
	
	public PageDataVO(int pageSize, int pageNo, String orderBy){
		this(null, pageSize, pageNo, orderBy);
	}
	
	public PageDataVO(T filters, int pageSize, int pageNo, String orderBy) {
		this.pageSize = pageSize;
		this.currentPage = pageNo;
		setOrderBy(orderBy);
	}

	public T getFilter() {
		return filter;
	}

	public void setFilter(T filter) {
		this.filter = filter;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	public List<SortColumnInfo> getSortInfos() {
		return Collections.unmodifiableList(SortColumnInfo.parseSortColumns(this.orderBy));
	}
}
