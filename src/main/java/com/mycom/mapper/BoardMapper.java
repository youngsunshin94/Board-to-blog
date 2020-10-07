package com.mycom.mapper;

import java.util.List;

import com.mycom.domain.BoardVO;
import com.mycom.domain.Criteria;

public interface BoardMapper {
	
	public void insert(BoardVO board);
	
	public BoardVO read(long bno);
	
	public int update(BoardVO board);
	
	public int delete(long bno);
	
	public List<BoardVO> getList(Criteria cri);

	public int getTotal(Criteria cri);

	public void hitUp(long bno);
	
}
