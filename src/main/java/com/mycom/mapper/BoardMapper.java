package com.mycom.mapper;

import java.util.List;

import com.mycom.domain.BoardVO;

public interface BoardMapper {
	
	public void insert(BoardVO board);
	
	public BoardVO read(long bno);
	
	public int update(BoardVO board);
	
	public int delete(long bno);
	
	public List<BoardVO> getList();
	
}
