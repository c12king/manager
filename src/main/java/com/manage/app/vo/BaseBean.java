package com.manage.app.vo;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.manage.framework.utils.Pager;
import com.manage.framework.utils.StringUtil;

public class BaseBean {

	private Integer page = 1;
	
	private Integer rows = 6;
	
	private Integer count;
	
	private String sort;
	
	private String order;
	
	private List list;

	/**
	 * 分页导航
	 */
	private Pager pager = new Pager();
	
	public Pager getPager() {
		pager.setPageId(getPage());
		pager.setPageSize(getRows());
		String orderField="";
		if(StringUtils.isNotBlank(sort)){
			pager.setOrderField(getSort());
		}
		boolean isAsc = true;
		if(StringUtils.isNotBlank(order)){
			if(!"asc".equals(order)) {
				isAsc = false;
			}
			pager.setOrderDirection(isAsc);
		}
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}
	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	
	public Integer getPage() {
		/*if(this.page == null) {
			page = 1;
		}*/
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		/*if(this.rows == null) {
			rows = 10;
		}*/
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	
}
