package kr.co.greenart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.greenart.Service.IJoinAndLoginService;
import kr.co.greenart.Service.JoinAndLoginService;
import kr.co.greenart.Service.lWriteService;

@Controller
@RequestMapping("/myphones")
public class PhoneUpdateController {
	
	@Autowired
	private JoinAndLoginService services;
	
	@Autowired
	private lWriteService service;
	
	@PostMapping("/phonenumber")
	public @ResponseBody String Phone_Check(@RequestBody String phonesed ) {
		
		//@RequestBody phonesed에서 010-3838-4848= 으로 넘어와서 서브스트링으로 잘라 phone 변수에 담음.
		String phone = phonesed.substring(0,13);
		System.out.println(phone);
		//update를 하기 위해 이름과 폰번호를 함께 넘겨줍니다.
		int update = service.UpdatePhone(services.pnickname, phone);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!" + update);
		
		if(update == 1) {
			//핸드폰 번호가 수정이 되었으면 리턴 1을 해줍니다.
			return "1";
					
		}else {
			//핸드폰 번호가 수정되지 않으면 리턴 0을 해줍니다.
			return "0";
		}
				
		
	}


	
	
	
}
