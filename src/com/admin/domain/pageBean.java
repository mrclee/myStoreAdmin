package com.admin.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 商品信息分页显示实体类
 * @author tq
 */
@Setter@Getter
public class pageBean {
	
	//保存当前页商品信息的集合
	private List<Goods> goodsList = new ArrayList<Goods>();
	//保存当前页编号的变量
	private Integer currentPage;
	//保存总页数的变量
	private Integer totalPage;
	//保存总记录数的变量
	private Integer totalCount;
	
	@Override
	public String toString() {
		return "pageBean [goodsList=" + goodsList + ", currentPage=" + currentPage + ", totalPage=" + totalPage
				+ ", totalCount=" + totalCount + "]";
	}
}
