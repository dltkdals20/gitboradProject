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

import kr.co.greenart.Service.lWriteService;
import kr.co.greenart.model.JoinInfo;
import kr.co.greenart.model.ListInfo;
import kr.co.greenart.repository.lWriteDao;

@Controller
@RequestMapping("/list")
public class ListController {
	private Logger logger = LoggerFactory.getLogger(ListController.class);

	@Autowired
	private lWriteService service;
	
	@Autowired
	private lWriteDao services;

	@GetMapping(value = "/updating")
	public String join(@RequestParam int bbsID, Model model) {

		ListInfo list = service.lookId(bbsID);
		System.out.println("이 리스트 값은 20202020202020" + list);

		model.addAttribute("list", list);

		return "ListAtion";

	}

	@ModelAttribute
	public ListInfo listInfo() {
		ListInfo user = new ListInfo();
		return user;
	}

	@PostMapping("/Listupdating")
	public String add(@ModelAttribute ListInfo listInfo, Model model) {

	
		System.out.println("리스트 인포 내용을 알려주세요" + listInfo );
		//마이페이지 게시판 업데이트 수정되고 나서 결과를 1로 알려주는거
		int result = service.Update(listInfo);
//		System.out.println("업데이트 구문 이다!!!!!!!!!!!!!!!!!!!" + result);
		
		//마이페이지 사진 밑에 잇는 아이디,네임,핸드폰번호, 닉네임 보여주는 곳.
		
		System.out.println("닉넴임을 알려주세요" + listInfo.getNicName());
		
		JoinInfo list = service.boradlookIds(listInfo.getNicName());
		System.out.println("리스트값 알려주세요!!!!!!!!!!!!!!!!!!!!!!!!!!!!!? " + list);

		model.addAttribute("list", list);
		
		
		///마이페이지 사진 옆에 있는 게시판.
		int a = 1;

		List<ListInfo> borad = service.lookMypage(a);
		model.addAttribute("borad", borad);
		System.out.println("리스트값 구문 이다!!!!!!!!!!!!!!!!!!!" + borad);
		
		//토탈페이지값
		int results = service.total();
		int totalpage = (int)Math.ceil(results/5.0);
		
		System.out.println("이 숫자를 알려주세요!!!!!!!!!!!!!!!!!!" +totalpage);
		
		model.addAttribute("totalpage",totalpage );

		return "my";
	}

	//1~3페이지 보여주는 메소드?...
	//1페이지를 눌리면 viewpage값을 가져와서 
	@GetMapping(value = "/ListVeiw")
	public String view(@RequestParam int viewpage ,@RequestParam int number,String nick, Model model) {
		System.out.println("닉네임 값을 알려줘!!!!!!!!!!!!!!!!!!!!!!" + nick);
		int a = viewpage;
		int d = number;
		System.out.println("디의 값이 궁금해요!!!!!!!!!!!!!!!! " + d);
		System.out.println("a의 값이 무없인지 알고 싶어요!!!!!!!!!!!!!" + a);
		
		//마이페이지 회원정보 보여주는 곳
		
		JoinInfo list = service.boradlookIds(nick);
		System.out.println("리스트값 알려주세요!!!!!!!!!!!!!!!!!!!!!!!!!!!!!? " + list);

		model.addAttribute("list", list);
		
		//마이페이지 게시판 보여주는 곳
		List<ListInfo> borad = service.lookMypage(a);
		model.addAttribute("borad", borad);
		
		//토탈페이지 보내주기.
		int result = service.total();
		int totalpage = (int)Math.ceil(result/5.0);
		
		System.out.println("이 숫자를 알려주세요!!!!!!!!!!!!!!!!!!" +totalpage);
		
		model.addAttribute("totalpage",totalpage );
		model.addAttribute("a",d);			
		
		return "my";
	}

	//1~2페이까지 보여주는 곳
	//1페이지를 눌리면 viewpage값을 가져와서 
	
	@GetMapping(value = "/coutList")
	public String list(@RequestParam int page ,Model model, String nick) {
		int a = page; 
		
		//회원정보 보여주는 곳 
		
		JoinInfo list = service.boradlookIds(nick);
		System.out.println("리스트값 알려주세요!!!!!!!!!!!!!!!!!!!!!!!!!!!!!? " + list);
		model.addAttribute("list", list);

		//마이페이지 게시판 보여주는 곳
		List<ListInfo> borad = service.lookMypage(a+1);
		model.addAttribute("borad", borad);
		
		//토탈페이지 보내주는 곳
		int result = service.total();
		int totalpage = (int)Math.ceil(result/5.0);
		
		System.out.println("이 숫자를 알려주세요!!!!!!!!!!!!!!!!!!" +totalpage);
		
		model.addAttribute("totalpage",totalpage );
		
		//a값 전달 하는 곳.
		int b = a+1;
		System.out.println("이값이 맞을까요 !!!!!!!!!!!!!!!!!!!!!!!" + b);
		model.addAttribute("a", b);
		
		return "my";
		
	}
	//4~6페이징 하는 곳.
	@GetMapping(value = "/viewMy")
	public String view(@RequestParam int viewpage ,String nick, @RequestParam int number, Model model) {
		int a = viewpage;
		int d = number;
		System.out.println("디의 값이 궁금해요!!!!!!!!!!!!!!!! " + d);
		System.out.println("a의 값이 무없인지 알고 싶어요!!!!!!!!!!!!!" + a);
		
		//회원정보 보여주는 곳

		JoinInfo list = service.boradlookIds(nick);
		System.out.println("리스트값 알려주세요!!!!!!!!!!!!!!!!!!!!!!!!!!!!!? " + list);
		model.addAttribute("list", list);
		
		//마이페이지 게시판 보여주는 곳
		List<ListInfo> borad = service.lookMypage(a);
		model.addAttribute("borad", borad);
		
		//토탈페이지 보내주는 곳
		int result = service.total();
		int totalpage = (int)Math.ceil(result/5.0);
		
		System.out.println("이 숫자를 알려주세요!!!!!!!!!!!!!!!!!!" +totalpage);
		
		model.addAttribute("totalpage",totalpage );
		model.addAttribute("a",d);			
		
		return "my";
	}
	//페이징 이전.
	@GetMapping(value = "/maiuslist")
	public String mius(@RequestParam int maius, String nick ,Model model) {
		
		int a = maius;
		
		//회원정보 보여주는 곳

		JoinInfo list = service.boradlookIds(nick);
		System.out.println("리스트값 알려주세요!!!!!!!!!!!!!!!!!!!!!!!!!!!!!? " + list);
		model.addAttribute("list", list);

		//마이페이지 게시판 보여주는 곳
		List<ListInfo> borad = service.lookMypage(a+2);
		model.addAttribute("borad", borad);
		
		//토탈페이지 보내주는 곳
		int result = service.total();
		int totalpage = (int)Math.ceil(result/5.0);
		
		System.out.println("이 숫자를 알려주세요!!!!!!!!!!!!!!!!!!" +totalpage);
		
		model.addAttribute("totalpage",totalpage );
			
		
		System.out.println("이값이 맞을까요 !!!!!!!!!!!!!!!!!!!!!!!" + a);
		model.addAttribute("a", a);
		
		return "my";
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int bbsID, Model model) {

		System.out.println("bbsID는 무엇인가" + bbsID);
		int result = service.delete(bbsID);
		System.out.println("삭제 구문이다 이다!!!!!!!!!!!!!!!!!!!" + result);
		int a = 1;
		List<ListInfo> list = service.look(a);
		model.addAttribute("list", list);

		return "my";

	}

}
