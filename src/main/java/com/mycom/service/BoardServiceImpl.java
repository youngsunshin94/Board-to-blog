package com.mycom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.domain.BoardVO;
import com.mycom.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {

		mapper.insert(board);
	}

	@Override
	public BoardVO get(long bno) {

		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {

		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(long bno) {

		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		
		return mapper.getList();
	}
	
	
}
