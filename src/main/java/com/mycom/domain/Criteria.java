package com.mycom.domain;

import lombok.Data;

@Data
public class Criteria {
	
	private int pageNum;
	private int amount;
	
	private String keyword;
	private String type;
	
	public Criteria() {
		this(1, 20);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public int getSkipCount() {
		return (pageNum -1) * 20;
	}
	
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
}
