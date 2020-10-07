package com.mycom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.domain.ReplyVO;
import com.mycom.service.ReplyService;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/replies/")
public class ReplyController {

	@Autowired
	private ReplyService service;
	
	@PostMapping(value = "/new", consumes = "application/json",
			produces = "application/text; charset=utf-8")
	public ResponseEntity<String> register(@RequestBody ReplyVO vo) {
		log.info("register : " + vo);
		
		return service.register(vo) == 1
				? new ResponseEntity<>("댓글 작성 완료", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/pages/{bno}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable("bno") long bno) {
		log.info("reply list : " + bno);
		
		return new ResponseEntity<>(service.getList(bno), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{rno}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") long rno) {
		log.info("get reply : " + rno);
		
		return new ResponseEntity<>(service.get(rno), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{rno}", produces = "application/text; charset=utf-8")
	public ResponseEntity<String> remove(@PathVariable("rno") long rno) {
		log.info("remove reply : " + rno);
		
		return service.remove(rno) == 1
				? new ResponseEntity<>("댓글이 삭제되었습니다.", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);		
	}
	
	@RequestMapping(value = "/{rno}", method = {RequestMethod.PUT, RequestMethod.PATCH},
			consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo, @PathVariable("rno") long rno) {
		vo.setRno(rno);
		
		return service.modify(vo) == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);		
	}
	
}
