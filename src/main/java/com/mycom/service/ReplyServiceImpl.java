package com.mycom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.domain.ReplyVO;
import com.mycom.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyMapper mapper;

	@Override
	public int register(ReplyVO vo) {
		
		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(long rno) {

		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {

		return mapper.update(vo);
	}

	@Override
	public int remove(long rno) {
		
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(long bno) {

		return mapper.getList(bno);
	}
	
	
}
