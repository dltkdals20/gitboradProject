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

import jakarta.validation.Valid;
import kr.co.greenart.Service.JoinAndLoginService;
import kr.co.greenart.Service.lWriteService;
import kr.co.greenart.model.ListInfo;
import kr.co.greenart.model.LoginInfo;
import kr.co.greenart.model.WritInfo;
import kr.co.greenart.vlidator.WriteVlidator;

@Controller
@RequestMapping("/write")
public class WriteController {
	private Logger logger = LoggerFactory.getLogger(WriteController.class);

	@Autowired
	private WriteVlidator validators;

	@Autowired
	private JoinAndLoginService services;
	
	@Autowired
	private lWriteService service;

	@GetMapping(value = "/writeView")
	public String Write(Model model) {
		model.addAttribute("writeInfo", new WritInfo());
		return "write";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.setValidator(validators);
	}
	
	/*
	 * @ModelAttribute public LoginInfo LoginInfo() { LoginInfo u = new LoginInfo();
	 * System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"); return
	 * u; }
	 */
	
	
	@PostMapping("/writeView")
	public String add(@ModelAttribute(name = "writeInfo") @Valid WritInfo writeInfo, BindingResult result,  Model model) {
		//로그인 부분에서 이용했던 세션 부분에서 닉네임을 static으로 만들어서 해당 컨트롤에서 이용을 하였습니다.
		//pinckNickName을 활용하기 위해서 위에 보시면 AutoWired로 JoinAndLoginService를 등록을 하였습니다.
		//닉네임을 가져와서 String nickName에 담아줍니다.
		String nickName = services.pnickNickName;
		System.out.println("이게 맞을 까!!!!!!!!!!!!!!!!!!" + nickName);
		logger.info(writeInfo.toString());
		//사용자가 제목,여행날짜,여행지역,내용을 입력을 하였는지를 확인하는 부분입니다.
		//이중에 하나라도 입력하지 않으면 입력하라는 내용이 나오며 write.jsp로 리턴을 하여 계속 해당페이지에 머물게 합니다.
		if(result.hasErrors()) {
			return "write";
		}
		
		//ModelAttribute를 이용하여 사용자가 입력한 양식을 wirteInfo에 담아 객체를 만든다음 게시글을 등록해주는 쿼리에
		//writeInfo와 닉네임을 함께 넘겨줍니다.
		int results = service.add(writeInfo, nickName);
		
		//페이징을 하는 부분입니다.
		//0~10번 게시글을 보여주기 사용함
		int a = 1;
		//service.look 서비스를 통해 DB에서 게시글 번호,타이틀,작성자,작성일,조회수를 보여줍니다.
		List<ListInfo> list = service.look(a);
		//list에 정보를 담아 model을 통해 뷰로 전달을 합니다.
		model.addAttribute("list", list);
		
		//총 게시글 숫자를 알려주는 역할을 수행합니다.
		int resultd = service.total();
		//총 게시글 숫자에서 나누기 10을 해줍니다.
		//나누기 10을 해주는 이유는 페이지당 게시글 10개를 보여주기 때문입니다.
		int totalpage = (int)Math.ceil(resultd/10.0);
		
		System.out.println("해당하는 숫자값 알렺쉐요!!!!!!!!!!!!!!!!!!!" +totalpage);
		
		//게시글이 10개이면 나누기 10을 하여 bbs.jsp에 1을 보내줍니다.
		model.addAttribute("totalpage",totalpage );
				
		return "bbs";
		
	}
	
		
		

	}
	


