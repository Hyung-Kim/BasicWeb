package com.taehyung.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.taehyung.domain.BoardVO;
import com.taehyung.service.BoardService;


// Board의 모든 공통경로를 /board/로 인식하게 한다.
@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public void registerGET() throws Exception{
		logger.info("register get......");
		//리턴 타입이 void임으로 현재 경로에 해당하는 JSP 파일을 찾게된다.
	}
	
	@RequestMapping(value="/register", method =RequestMethod.POST)
	public String registPOST(BoardVO board, RedirectAttributes rttr)  throws Exception{
		logger.info("regist post");
		logger.info(board.toString());
		//입력된 정보가 board 객체에 자동으로 들어가는 것을 알 수 있다.
		service.regist(board);
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception{
		logger.info("show all list..................");
		//model을 이용해서 모든 게시물을 JSP로 전송하는 작업을 진행. 즉, model.addAttribute.
		model.addAttribute("list",service.listAll());
	}
	
	// RequestParam을 이용하면 받는 값을 좀 더 명확하게 알 수 있다.
	// 조회된 결과물을 JSP로 전달하기 위해서 Model 객체를 사용한다.
	@RequestMapping(value="/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception{
		model.addAttribute(service.read(bno));   //아무런 이름 없이 데이터를 넣었음으로 클래스의 이름을 소문자로 시작해서 사용하게 된다. 여기서는 service.read의 반환 객체 boardVO
	}
	
	@RequestMapping(value="/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("bno")int bno, RedirectAttributes rttr) throws Exception{
		service.remove(bno);
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modifyGET(int bno, Model model) throws Exception{
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPOST(BoardVO board, RedirectAttributes rttr) throws Exception{
		logger.info("mod post..........."+board.toString());
		service.modify(board);
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/board/listAll";
	}
}
