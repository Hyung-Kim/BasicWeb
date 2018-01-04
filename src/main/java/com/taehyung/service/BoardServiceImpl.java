package com.taehyung.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.taehyung.domain.BoardVO;
import com.taehyung.persistence.BoardDAO;

//스프링의 빈으로 인식되기 위해서 @Service 애노테이션이 사용된다.
@Service 
public class BoardServiceImpl implements BoardService{
	@Inject
	private BoardDAO dao;
	
	@Override
	public void regist(BoardVO board) throws Exception{
		dao.create(board);
	}
	
	@Override
	public BoardVO read(Integer bno) throws Exception{
		return dao.read(bno);
	}
	@Override
	public void modify(BoardVO board) throws Exception{
		dao.update(board);
	}
	@Override
	public void remove(Integer bno) throws Exception{
		dao.delete(bno);
	}
	@Override
	public List<BoardVO> listAll() throws Exception{
		return dao.listAll();
	}
}
