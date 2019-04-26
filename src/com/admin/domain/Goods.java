package com.admin.domain;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Goods {
	
	private Integer id;
	private String name;
	private Double price;
	private String image;
	private String gdesc;
	private Integer is_hot;
	private Integer cid;
	
	public Goods(String name, Double price, String image) {
		this.name = name;
		this.price = price;
		this.image = image;
	}
	
	
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + ", gdesc=" + gdesc
				+ ", is_hot=" + is_hot + ", cid=" + cid + "]";
	}



	public Goods(Integer id, String name, Double price, String image) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
	}



	public Goods() {
	}


}
