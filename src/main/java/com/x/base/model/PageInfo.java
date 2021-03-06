package com.x.base.model;

import com.x.utils.NumUtils;

/**
 * <p>
 * Description:分页信息类
 * </p>
 * 
 * @Author Chenkangming @Date 2014-09-26
 * @version 1.0
 */
public class PageInfo extends XObject {

	private static final long serialVersionUID = 9062424237155032880L;

	/**
	 * 当前第几页
	 */
	private int page = 1;

	/**
	 * 每页查询页数 默认查询30条
	 */
	private int rows = 30;

	/**
	 * 查询页数
	 */
	private int selectPageRows = (this.page - 1) * this.rows;

	/**
	 * 总记录数
	 */
	private int allRows;

	/**
	 * 总页数
	 */
	private int allPages;

	/**
	 * @param page
	 *            当前第几页
	 * @param rows
	 *            总记录数
	 */
	public PageInfo(String page, String rows, int allRows) {
		setRows(NumUtils.toInt(rows));
		setAllRows(allRows);
		setAllPages();
		setPage(NumUtils.toInt(page));
		setSelectPageRows();
	}

	public PageInfo(int allRows) {
		setAllRows(allRows);
		setRows(rows);
		setAllPages();
		setPage(1);
		setSelectPageRows();
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page - 1 < 0) {
			page = 1;
		}
		if (page >= this.allPages) {
			page = this.allPages;
		}
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		if (rows == 0 || rows == 1) {
			rows = 30;
		}
		this.rows = rows;
	}

	public int getAllRows() {
		return allRows;
	}

	public void setAllRows(int allRows) {
		this.allRows = allRows;
	}

	public int getAllPages() {
		return allPages;
	}

	public void setAllPages() {
		this.allPages = (this.allRows % this.rows == 0) ? (this.allRows / this.rows) : (this.allRows / this.rows + 1);
	}

	public int getSelectPageRows() {
		return selectPageRows;
	}

	public void setSelectPageRows() {
		if (page == 0) {
			page = 1;
		}
		this.selectPageRows = (page - 1) * rows;
	}
}
