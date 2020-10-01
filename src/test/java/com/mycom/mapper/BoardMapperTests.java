package com.mycom.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mycom.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void insert() {
		BoardVO board = new BoardVO();
		board.setTitle("제목");
		board.setContent("내용");
		board.setWriter("user0");
		
		for(int i=0;i<10;i++) {
			mapper.insert(board);
		}
		log.info(board);
	}
	
//	@Test
//	public void read() {
//		log.info(mapper.read(1L));
//	}
	
//	@Test
//	public void update() {
//		BoardVO board = mapper.read(1L);
//		
//		board.setTitle("제목");
//		board.setContent("내용");
//		board.setWriter("user0");
//		
//		log.info("update : " + mapper.update(board));
//	}
	
//	@Test
//	public void list() {
//		mapper.getList().forEach(board -> log.info(board));
//	}
	
	@Test
	public void delete() {
		log.info("delete : " + mapper.delete(1L));
	}

}
