package kr.co.greenart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.greenart.Service.IJoinAndLoginService;

@Controller
@RequestMapping("/out")
public class LogoutController {

	@Autowired
	private IJoinAndLoginService service;
	
	@GetMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
		
		service.logout(session);
		redirectAttributes.addFlashAttribute("msg", "logout");
		return "redirect:/mapping/login";
		
	}
	
}
