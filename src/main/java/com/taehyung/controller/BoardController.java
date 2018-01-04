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


// Board�� ��� �����θ� /board/�� �ν��ϰ� �Ѵ�.
@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public void registerGET() throws Exception{
		logger.info("register get......");
		//���� Ÿ���� void������ ���� ��ο� �ش��ϴ� JSP ������ ã�Եȴ�.
	}
	
	@RequestMapping(value="/register", method =RequestMethod.POST)
	public String registPOST(BoardVO board, RedirectAttributes rttr)  throws Exception{
		logger.info("regist post");
		logger.info(board.toString());
		//�Էµ� ������ board ��ü�� �ڵ����� ���� ���� �� �� �ִ�.
		service.regist(board);
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception{
		logger.info("show all list..................");
		//model�� �̿��ؼ� ��� �Խù��� JSP�� �����ϴ� �۾��� ����. ��, model.addAttribute.
		model.addAttribute("list",service.listAll());
	}
	
	// RequestParam�� �̿��ϸ� �޴� ���� �� �� ��Ȯ�ϰ� �� �� �ִ�.
	// ��ȸ�� ������� JSP�� �����ϱ� ���ؼ� Model ��ü�� ����Ѵ�.
	@RequestMapping(value="/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception{
		model.addAttribute(service.read(bno));   //�ƹ��� �̸� ���� �����͸� �־������� Ŭ������ �̸��� �ҹ��ڷ� �����ؼ� ����ϰ� �ȴ�. ���⼭�� service.read�� ��ȯ ��ü boardVO
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
