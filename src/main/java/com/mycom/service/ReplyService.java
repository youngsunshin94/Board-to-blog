package com.mycom.service;

import java.util.List;

import com.mycom.domain.ReplyVO;

public interface ReplyService {
	
	public int register(ReplyVO vo);
	
	public ReplyVO get(long rno);
	
	public int modify(ReplyVO vo);
	
	public int remove(long rno);
	
	public List<ReplyVO> getList(long bno);
}
