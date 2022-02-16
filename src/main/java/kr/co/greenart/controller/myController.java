package kr.co.greenart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.greenart.Service.JoinAndLoginService;
import kr.co.greenart.Service.lWriteService;
import kr.co.greenart.model.JoinInfo;
import kr.co.greenart.model.ListInfo;
import kr.co.greenart.repository.lWriteDao;


@Controller
@RequestMapping("/my")
public class myController {
	
	public String Nickname;
	private Logger logger = LoggerFactory.getLogger(myController.class);
	
	@Autowired
	private JoinAndLoginService services;
	
	@Autowired
	private lWriteService service;
	
	
	@GetMapping(value = "/mypage")
	public String list(Model model) {
		
		System.out.println("이값은 ㅁ웟인가요" + services.pnickname);
		//이름으로 Jointable에 있는 이름,닉네임,아이디,핸드폰번호,성별 row를 가져옵니다.
		//가져온 row를 JoinInfo에 담아놓습니다.
		JoinInfo list = service.lookIds(services.pnickname);
		System.out.println("리스트의 값을 알려줘" + list);
		//model를 이용하여 my.jsp에 넘겨줍니다.
		model.addAttribute("list", list);
		Nickname = list.getNickName();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" +Nickname);
				
		int a = 1;
		//사용자가 등록한 게시글을 보여주는 서비스
		List<ListInfo> borad = service.lookMypage(a);
		model.addAttribute("borad", borad);
		//페이징을 위해 토탈페이지를 보내줍니다.
		int result = service.total();
		int totalpage = (int)Math.ceil(result/4.0);
		
		System.out.println("이 숫자를 알려주세요!!!!!!!!!!!!!!!!!!" +totalpage);
		
		model.addAttribute("totalpage",totalpage );
		
		
		return "my";
	}
		
	
	@GetMapping(value = "/myList")
	public String broadList(@RequestParam int bbsID ,Model model) {
		
		int ID = bbsID;
		System.out.println("이거 왜 쓴느지는 아올고 링릉ㄹ   " + ID);
		
		ListInfo list = service.lookId(ID);
		
		model.addAttribute("list", list);
		
		return "viewList";
	}
	
}
	


