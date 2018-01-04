package com.taehyung.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//�� Ŭ������ ��ü�� ��Ʈ�ѷ����� �߻��ϴ� Exception�� ���������� ó���ϴ� Ŭ������� ���� ����Ѵ�.
@ControllerAdvice
public class CommonExceptionAdvice {
	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	//common �޼ҵ带 ���� Exception Ÿ������ ó���Ǵ� ��� ���ܸ� ó���ϵ��� �Ѵ�.
	@ExceptionHandler(Exception.class)
	public ModelAndView errorModelAndView(Exception e) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error_common");
		modelAndView.addObject("exception",e);
		return modelAndView;
	}
}
