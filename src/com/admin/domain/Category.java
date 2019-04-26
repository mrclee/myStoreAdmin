package com.admin.domain;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Category {
	private Integer cid;
	private String cname;
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + "]";
	}
}
