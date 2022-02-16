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

import kr.co.greenart.model.ListInfo;
import kr.co.greenart.repository.lWriteDao;


@Controller
@RequestMapping("/BBS")
public class BbsController {
	private Logger logger = LoggerFactory.getLogger(BbsController.class);
	
	
	@Autowired
	private lWriteDao service;

	@GetMapping(value = "/bbsView")
	public String list(Model model) {
		
				
		int a = 1;

		List<ListInfo> list = service.look(a);
		model.addAttribute("list", list);
		
		int result = service.total();
		int totalpage = (int)Math.ceil(result/10.0);
		
		System.out.println("이 숫자를 알려주세요!!!!!!!!!!!!!!!!!!" +totalpage);
		
		model.addAttribute("totalpage",totalpage );
		
		
		return "bbs";
	}

	@GetMapping(value = "/view")
	public String view(@RequestParam int viewpage ,@RequestParam int number, Model model) {
		int a = viewpage;
		int d = number;
		System.out.println("디의 값이 궁금해요!!!!!!!!!!!!!!!! " + d);
		System.out.println("a의 값이 무없인지 알고 싶어요!!!!!!!!!!!!!" + a);
		List<ListInfo> list = service.look(a);
		model.addAttribute("list", list);
		
		int result = service.total();
		int totalpage = (int)Math.ceil(result/10.0);
		
		System.out.println("이 숫자를 알려주세요!!!!!!!!!!!!!!!!!!" +totalpage);
		
		model.addAttribute("totalpage",totalpage );
		model.addAttribute("a",d);			
		
		return "bbs";
	}
		
	@GetMapping(value = "/coutView")
	public String list(@RequestParam int page ,Model model) {
		int a = page; 
		//넘어오는 page넘버에 +1을 하여 look 서비스에 넘겨줍니다.
		List<ListInfo> list = service.look(a+1);
		model.addAttribute("list", list);
		
		//다시 토탈페이지의 정보를 넘겨줍니다.
		int result = service.total();
		int totalpage = (int)Math.ceil(result/10.0);
		
		System.out.println("이 숫자를 알려주세요!!!!!!!!!!!!!!!!!!" +totalpage);
		
		model.addAttribute("totalpage",totalpage );
			
		int b = a+1;
		System.out.println("이값이 맞을까요 !!!!!!!!!!!!!!!!!!!!!!!" + b);
		model.addAttribute("a", b);
		
		return "bbs";
		
	}
	
	@GetMapping(value = "/maius")
	public String mius(@RequestParam int maius ,Model model) {
		
		int a = maius;

		List<ListInfo> list = service.look(a+2);
		model.addAttribute("list", list);
		
		int result = service.total();
		int totalpage = (int)Math.ceil(result/10.0);
		
		System.out.println("이 숫자를 알려주세요!!!!!!!!!!!!!!!!!!" +totalpage);
		
		model.addAttribute("totalpage",totalpage );
			
		
		System.out.println("이값이 맞을까요 !!!!!!!!!!!!!!!!!!!!!!!" + a);
		model.addAttribute("a", a);
		
		return "bbs";
		
	}
		
	
}
	


