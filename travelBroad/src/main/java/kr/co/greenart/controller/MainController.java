package kr.co.greenart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.greenart.model.ListInfo;
import kr.co.greenart.repository.lWriteDao;


@Controller
@RequestMapping("/main")
public class MainController {
	private Logger logger = LoggerFactory.getLogger(MainController.class);
	
	


	@Autowired
	private lWriteDao service;

	@GetMapping(value = "/mains")
	public ModelAndView list(Model model) {
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		mav.addObject("msg", "success");
		
		
		return mav;
	}

	
		
	
}
	


