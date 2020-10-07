package com.mycom.mapper;

import java.util.List;

import com.mycom.domain.ReplyVO;

public interface ReplyMapper {
	
	public int insert(ReplyVO vo);
	
	public ReplyVO read(long rno);
	
	public int update(ReplyVO vo);
	
	public int delete(long rno);
	
	public List<ReplyVO> getList(long bno);
}
