package com.module.domain.homePage;

import java.util.List;

/**
 * esayui dataGrid
 * @author awl
 *
 */
public class EUDataGrid {
	
	private int page = 1;
	private int rows = 5;
	private long total;
	private long totalPage;
	private List<?> list;
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	
}
