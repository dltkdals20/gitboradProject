package kr.co.greenart.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import kr.co.greenart.Service.IJoinAndLoginService;
import kr.co.greenart.model.LoginInfo;


@Controller
@RequestMapping("/mapping")
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private IJoinAndLoginService service;

	@GetMapping(value = "/login")
	public String join() {
		return "login";
	}

	
	@ModelAttribute
	public LoginInfo loginInfo() {
		LoginInfo user = new LoginInfo();
		return user;
	}
	//로그인 처리
	@PostMapping("/login")
	public ModelAndView add(@ModelAttribute LoginInfo user, HttpSession session) {
		boolean results = service.loginCheck(user, session);
		System.out.println("정말 투르가 나올까? " + results);
		ModelAndView mav = new ModelAndView();
		logger.info(user.toString());
	
		if(results == true) {
			mav.setViewName("main");
			mav.addObject("msg", "success");
		}else {
			mav.setViewName("login");
			mav.addObject("msg", "failure");
		}
		
		return mav;
		
		
		
		

	}
	
	
	//아이디 찾기 주소
		@GetMapping("/idlook")
		public String id() {
			return "ID";
		}
		//비밀번호 찾기 주소
		@GetMapping("/password")
		public String password() {
			return "Password";
		}
	

}
