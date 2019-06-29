package com.admin.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品信息分页显示实体类
 * @author tq
 */

public class pageBean {
	
	//保存当前页商品信息的集合
	private List<Goods> goodsList = new ArrayList<Goods>();
	//保存当前页编号的变量
	private Integer currentPage;
	//保存总页数的变量
	private Integer totalPage;
	//保存总记录数的变量
	private Integer totalCount;

	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "pageBean [goodsList=" + goodsList + ", currentPage=" + currentPage + ", totalPage=" + totalPage
				+ ", totalCount=" + totalCount + "]";
	}
}
