package com.mycom.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mycom.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ReplyMapperTests {
	
	@Autowired
	private ReplyMapper mapper;
	
	@Test
	public void insert() {
		ReplyVO vo = new ReplyVO();
		
		for(int i=0;i<10;i++) {
			vo.setBno(3L);
			vo.setReply("댓글" + i);
			vo.setReplyer("user"+i);
			
			mapper.insert(vo);
			log.info(vo);
		}
	}
	
	@Test
	public void read() {
		
		log.info(mapper.read(1L));
	}
	
	@Test
	public void update() {
		ReplyVO vo = mapper.read(1L);
		
		vo.setReply("댓글 수정");
		log.info(mapper.update(vo));
	}
	
	@Test
	public void getList() {
		mapper.getList(3L).forEach(reply -> log.info(reply));
	}
	
	@Test
	public void delete() {
		log.info(mapper.delete(10L));
	}
	
}