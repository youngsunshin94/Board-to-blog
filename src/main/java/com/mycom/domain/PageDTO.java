package com.mycom.domain;

import lombok.Data;

@Data
public class PageDTO {
	
	private int startNum, endNum;
	private boolean prev, next;
	
	private int total;
	private Criteria cri;
	
	public PageDTO(int total, Criteria cri) {
		this.total = total;
		this.cri = cri;
		
		this.endNum = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
		this.startNum = this.endNum -9;
		
		int realEnd = (int)(Math.ceil((total * 1.0) / cri.getAmount()));
		
		if(this.endNum > realEnd) {
			this.endNum = realEnd;
		}
		
		this.prev = startNum != 1;
		this.next = this.endNum < realEnd;
	}
}	
