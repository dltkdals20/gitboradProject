package kr.co.greenart.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.greenart.Service.lWriteService;
@Controller
public class ImageviewController {
		
	@Autowired
	private lWriteService service;
	
	@GetMapping(value="/mine/ckImgSubmits.do")
	public ResponseEntity<Resource>	ckSubmit(@RequestParam String nickName) throws IOException {
		System.out.println("닉네임이 받아와 지나요 알려주세요!!!!!!!!!!!!!!!!!" + nickName);
		
		Resource resource = new ByteArrayResource(service.fileRead(nickName));
		return ResponseEntity.ok().header("content-type", "image/jpeg").body(resource);
	}

}
