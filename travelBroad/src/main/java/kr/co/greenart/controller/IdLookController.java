package kr.co.greenart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.Valid;
import kr.co.greenart.Service.IJoinAndLoginService;



import kr.co.greenart.vlidator.JoinVlidator;

@Controller
@RequestMapping("/Id")
public class IdLookController {
	private Logger logger = LoggerFactory.getLogger(IdLookController.class);
   
   @Autowired
   private IJoinAndLoginService service;
  
	
	
   //아이디 찾기 컨트롤
   @PostMapping("/IdLook")
   public @ResponseBody String ID_Check( @RequestParam String name ,String phoneNumber) {
      //public 앞에 @ResponseBody 적은 이유는 @ResponseBody 를 적지않으면 
      //return "-1"을 경로로 인식을 하고 -1 view를 찾기 때문에 꼭 @ResponseBody 적어줘서 값을 넘겨줘야 함.
	   
	  if(!(name == ""||name == null ||phoneNumber == "")) {
		  
		  String names = name.trim();
		  System.out.println(names);
		  
		  String phones = phoneNumber.trim();
		  System.out.println(phones);
		  		  	  
		  String phoneNumbers = rephone(phones);
		  //이름과 핸드폰 번호를 넣어서 찾는 서비스
		  //이름과 핸드폰이 일치하지 않으면 결과값이 "fail"이 나오게되어 있습니다.
		  //이름과 핸드폰이 일치를 하면 유저의 아이디값을 "dto"에 담았습니다.
		  String dto = service.idFind(names, phoneNumbers);
		 System.out.println("dot값은 무엇인가요?" + dto);
		  //다오에서 fail이 나오게 되면 return "fail"을해주고
		  if(dto == "fail") {
			  return "fail";
			  
		  }else {
		  //다오에서 유저의 아이디 값이 나오게 되면 그대로 아이디값을 전달함.
			  return dto;
		  }
	  }
	return "0"; 
      
      // 비번
      
      
   }
   
   
   //비밀번호 찾기 컨트롤
   @PostMapping("/PasCheck")
   public @ResponseBody String Pass_check(@RequestParam String userID ,String phoneNumber) {
      //public 앞에 @ResponseBody 적은 이유는 @ResponseBody 를 적지않으면 
      //return "-1"을 경로로 인식을 하고 -1 view를 찾기 때문에 꼭 @ResponseBody 적어줘서 값을 넘겨줘야 함.
      
	   String userIds = userID.trim();
		  System.out.println(userIds);
	   
	  if(!(userID == ""||phoneNumber == "")) {
		  
		  String userId = userID.trim();
		  System.out.println(userId);
		  
		  String phones = phoneNumber.trim();
		  System.out.println(phones);
		 		 		  
		  String phoneNumbers = rephone(phones);
		  
		  //비밀번호 찾기 서비스
		  String dto = service.passwordFind(userId, phoneNumbers);
		  System.out.println("&&&&&&&&&&&&&&&& " + dto);
		  		    
		  // 비번
		  
		  if(dto == "fail") {
			  return "fail";
			  
		  }else {
			  return dto;
		  }
	  }
	return "0";
      
   }
   
   
   
   

   private String rephone(String phoned) {
	
	   String frist = phoned.substring(0,3);
	   System.out.println("퍼스트의 값은 무엇인가요?" + frist ); 
	   String seconed = phoned.substring(3,7);
	   System.out.println("두번째 값은 무엇인가요?" + seconed ); 
	   String third = phoned.substring(7,11);
	   System.out.println("세번째 값은 무엇인가요?" + third ); 
	   
	   String phoneNumber = frist+"-"+seconed+"-"+third;
	   	     
	   return phoneNumber;
	   
   }
   
   
}