package com.utis;




import java.util.List;







/**
 * 分页标签工具类
 */
public class Page{
	private int start;  //启始位置
	private int end;    //结束页
	private int totalPage;  //总页数
	private int cpage=1;     //当前页
	private int totalRow;    //总信息数
	private int pageSize=5;    //分页单位
    private String link;     //参数
    private String id;     //参数
    private  List list;  
    
    public Page(int cpage,int pageSize,String like) {
    	this.link=like;
    	this.cpage=cpage;
    	this.pageSize=pageSize;
    	this.start=(cpage-1)*pageSize;
    	this.end=cpage*pageSize;
	}
    public Page(int cpage,int pageSize,String like,String id) {
    	this.link=like;
    	this.id=id;
    	this.cpage=cpage;
    	this.pageSize=pageSize;
    	this.start=(cpage-1)*pageSize;
    	this.end=cpage*pageSize;
	}
//		this.start = (this.cpage - 1) * pageSize;
//		this.end = this.start + pageSize;
	

	public int getStart() {
		return start;
	}
	public int getEnd() {
		return end;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public int getCpage() {
		return cpage;
	}
	public int getTotalRow() {
		return totalRow;
	}
	public int getPageSize() {
		return pageSize;
	}
    
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}


	public List getList() {
		return list;
	}


	public void setList(List list) {
		this.list = list;
	}


	public void setStart(int start) {
		this.start = start;
	}


	public void setEnd(int end) {
		this.end = end;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public void setCpage(int cpage) {
		this.cpage = cpage;
	}


	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	
	
}
