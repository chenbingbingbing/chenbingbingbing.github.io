package com.baidu.util;

public class PageUtil {

	/**
	 * 分页工具类
	 * page counter  pageSize
	 */
	private Integer prevPage;
	private Integer nextPage;
	private Integer lastPage;
	private Integer pageSize;
	private Integer counter;
	private Integer currentPage=0;
	
	public PageUtil(Integer pageSize,Integer counter,String page) {
		
		this.pageSize=pageSize;
		this.counter=counter;
		if(page == null) {
			page="1";
		}
		
		currentPage=Integer.parseInt(page);
		
		//计算尾页
		initLastPage();
		//计算上一页
		initPrevPage();
		//计算下一页
		initnextPage();
		
	}
	
	private void initnextPage() {
		// TODO Auto-generated method stub
		nextPage=currentPage==lastPage?lastPage:currentPage+1;
	}

	private void initPrevPage() {
		
		prevPage=currentPage==1?currentPage:currentPage-1;
	}

	private void  initLastPage() {
		lastPage=counter/pageSize;
		if(counter%pageSize != 0) {
			lastPage+=1;
		}
	}

	public Integer getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(Integer prevPage) {
		this.prevPage = prevPage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public Integer getLastPage() {
		return lastPage;
	}

	public void setLastPage(Integer lastPage) {
		this.lastPage = lastPage;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCounter() {
		return counter;
	}

	public void setCounter(Integer counter) {
		this.counter = counter;
	}		
}
