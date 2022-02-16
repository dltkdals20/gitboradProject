package kr.co.greenart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.greenart.Service.IJoinAndLoginService;

@Controller
@RequestMapping("/paths")
public class NickCheckController {
	
	@Autowired
	private IJoinAndLoginService service;
		
	@PostMapping("/Nick_Check")
	public @ResponseBody String Nick_Check(@RequestBody String nick) {
		
		String userNick = nick.trim();
		System.out.println(userNick);
		int dto = service.NickCheck(userNick);
		System.out.println(userNick);
		
		if(dto == 1) {
			return "-1";
		}else {
			return "0";
		}
		
	}
	
	
	
}
