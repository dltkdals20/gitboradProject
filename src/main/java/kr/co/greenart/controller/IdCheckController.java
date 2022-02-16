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
public class IdCheckController {
	
	@Autowired
	private IJoinAndLoginService service;
	
	@PostMapping("/ID_Check")
	public @ResponseBody String ID_Check(@RequestBody String paramData ) {
		//public 앞에 @ResponseBody 적은 이유는 @ResponseBody 를 적지않으면 
		//return "-1"을 경로로 인식을 하고 -1 view를 찾기 때문에 꼭 @ResponseBody 적어줘서 값을 넘겨줘야 함.
		String ID = paramData.trim();
		System.out.println(ID);
		int dto = service.Idcheck(ID);
		System.out.println(dto);
		
		if(dto == 1) {
			return "-1";
					
		}else {
			return "0";
		}
				
		
	}
	

	
	
	
}
