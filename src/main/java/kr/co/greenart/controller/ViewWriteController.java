package kr.co.greenart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.greenart.Service.lWriteService;
import kr.co.greenart.model.ListInfo;

@Controller
@RequestMapping("/view")
public class ViewWriteController {
	private Logger logger = LoggerFactory.getLogger(ViewWriteController.class);

	
	@Autowired
	private lWriteService service;

	@GetMapping(value = "/viewMapping")
	public String join(@RequestParam int bbsID, int count ,Model model ) {
		//게시판 아이디
		int ID = bbsID;
		//조회수 카운터
		int views = count;
		
		int a = 1;
		System.out.println("카운터 값은 얼마 인가요?" + views );
		//다오에 있는 카운트 값
		int viewlook = service.lookviews(ID);
		if(count == 0) {
			int counts = service.viewsAdd(ID, a);
		}else if (views == viewlook){
			//다오에 있는 카운터 값과 게시판 뷰에 있는 조회수 값이 같으면 +1을 한 뒤 다오를 수정한다.
			int counts = views +1;//게시판에 있는 조회수에 +1을 한다.
			
			int viewCount = service.viewUpdate(ID, counts); //조회수 업데이트 하는 커리문
			System.out.println("알려주세요!!!!!!!!!!!!!!!!?" + viewCount );
				
		}
		//@RequestParam int bbsID에서 받은 value 값인 127을 int ID에 저장을 합니다.\
		//게시글 양식에 작성한 내용을 보여주는 serivce.looId에 ID 값 127을 던져줍니다.
		//DB에서 ID value 값인 127로  Writetable pk인 id를 검색하여 127번 게시물의 내용들을 보여줍니다.
		ListInfo list = service.lookId(ID);
		
		//127번 게시물의 내용들을 model을 통해 뷰로 전달을 합니다.
		model.addAttribute("list", list);
		
		return "viewWrite";
		
		
	}
	
	
	
	
	
	
		
		

	}
	


