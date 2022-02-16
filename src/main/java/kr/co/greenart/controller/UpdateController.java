package kr.co.greenart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import kr.co.greenart.Service.lWriteService;
import kr.co.greenart.model.ListInfo;

import kr.co.greenart.vlidator.WriteVlidator;

@Controller
@RequestMapping("/update")
public class UpdateController {
	private Logger logger = LoggerFactory.getLogger(UpdateController.class);

	@Autowired
	private lWriteService service;
	
	
	//viewWrite.jsp에서 수정 버튼을 누르게 되면 get방식으로 bbsId의 value 값인 list.id가 넘어오게 됩니다.
	//update 메소드에서 @ReqeustParam 으로 list.id 값을 받습니다.
	@GetMapping(value = "/updating")
	public String update(@RequestParam int bbsID, Model model) {
		//list.id 값을 사용자가 작성한 여행 후기 내용을 불러오는 service.looId에 넘겨줍니다.
		//list.id는 게시물의 번호입니다.
		//service.lookId에 담은 값을 ListInfo 객체에 담아 줍니다.
		ListInfo list = service.lookId(bbsID);
		System.out.println("이 리스트 값은 20202020202020" + list);
		//list 값을 model을 통해 writeAtion.jsp에 넘겨줍니다.
		model.addAttribute("list", list);
		//writeAtion.jsp페이지로 이동합니다.
		return "writeAtion";

	}


	
	@ModelAttribute
	public ListInfo listInfo() {
		ListInfo user = new ListInfo();
		return user;
	}
	
	//사용자가 자신의 게시글을 수정을 한 뒤 수정완료 버튼을 누르게 되면 post방식으로 넘어오게 됩니다.
	@PostMapping("/updating")
	public String add(@ModelAttribute ListInfo listInfo, Model model) {
		//수정된 내용을 담은 listInfo를 service.Update 메소드에 넘겨줍니다.
		//수정된 내용을 DB에 저장을 합니다.
		int results = service.Update(listInfo);
		System.out.println("업데이트 구문 이다!!!!!!!!!!!!!!!!!!!" + results);
		
		//페이징을 하는 부분입니다.
		//0~10번 게시글을 보여주기 사용함
		int a = 1;

		//페이지당 게시글 10개를 bbs.jsp에 model를 통해 넘겨줍니다.
		List<ListInfo> list = service.look(a);
		model.addAttribute("list", list);
		//총 게시글 숫자를 알려주는 역할을 수행합니다.
		int resultd = service.total();
		//총 게시글 숫자에서 나누기 10을 해줍니다.
		//나누기 10을 해주는 이유는 페이지당 게시글 10개를 보여주기 때문입니다.
		int totalpage = (int)Math.ceil(resultd/10.0);
		
		System.out.println("이 숫자를 알려주세요!!!!!!!!!!!!!!!!!!" +totalpage);
		//list에 정보를 담아 model을 통해 뷰로 전달을 합니다.
		model.addAttribute("totalpage",totalpage );
		
		return "bbs";

	}
	//ge방식으로 @requestParam 으로 bbsID value 값을 받습니다.
	//bbsID value 값을 게시글을 삭제 서비스를 제공하는 serivce.delete 메서드에 전달을 합니다.
	//DB에서 해당 글번호 row를 삭제를 하고 다시 전체 글 리스트를 가져옵니다.
	//model을 이용하여 bbs.jsp에 다시 전달을 합니다.
	//bbs.jsp에서 삭제된 내용을 빼고 사용자에게 게시글을 보여줍니다.
	@GetMapping("/delete")
	public String delete(@RequestParam int bbsID, Model model) {

		System.out.println("bbsID는 무엇인가" + bbsID);
		//bbsID value 값을 게시글을 삭제 서비스를 제공하는 serivce.delete 메서드에 전달을 합니다.
		int result = service.delete(bbsID);
		System.out.println("삭제 구문이다 이다!!!!!!!!!!!!!!!!!!!" + result);
		int a = 1;
		//DB에서 해당 글번호 row를 삭제를 하고 다시 전체 글 리스트를 가져옵니다.
		List<ListInfo> list = service.look(a);
		model.addAttribute("list", list);

		return "bbs";

	}

}
