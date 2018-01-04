package com.taehyung.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.taehyung.domain.BoardVO;
import com.taehyung.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardServiceTest {
	@Inject
	private BoardService service;
	private static Logger logger = LoggerFactory.getLogger(BoardServiceTest.class);
	@Test
	public void testCreate() throws Exception{
		BoardVO board = new BoardVO();
		board.setTitle("새로운 글1");
		board.setContent("새로운 내용1");
		board.setWriter("user02");
		service.regist(board);
	}
	
	@Test
	public void testRead() throws Exception{
		logger.info(service.read(2).toString());
	}
	
	@Test
	public void testUpdate() throws Exception{
		BoardVO board = new BoardVO();
		board.setBno(2);;
		board.setTitle("수정된 글인데???");
		board.setContent("수정 내용입니다.");
		service.modify(board);
	}
	
	@Test
	public void testDelete() throws Exception{
		service.remove(2);
	}
}
