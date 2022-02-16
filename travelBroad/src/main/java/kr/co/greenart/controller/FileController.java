package kr.co.greenart.controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.greenart.Service.JoinAndLoginService;
import kr.co.greenart.Service.lWriteService;

@Controller
@RequestMapping("/file")
public class FileController {

	@Autowired
	private myController my;
	
	@Autowired
	private lWriteService service;
	
	
	@PostMapping("/file_Check")
	public @ResponseBody String file_Check (@RequestBody MultipartFile userfile) throws IOException {
		String fileName =userfile.getOriginalFilename();
		byte[] filebyte =userfile.getBytes();
		
		String nickName = my.Nickname;
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!" +fileName);
		System.out.println("닉네임을 알려줘" + nickName);
		
		
		
		//다오에서 이미지를 가져오기.
		
				
		Image image;
		int imageWidth;
		int imageHeight;
		//마이페이지 이미지 파일 크기
		int newWidth = 183; 
		int newHeight = 194;
		String imgFormat = "jpg";
		

		
		
		try {
			image = ImageIO.read(new ByteArrayInputStream(filebyte));
			imageWidth = image.getWidth(null);
			imageHeight = image.getHeight(null);
			
			System.out.println("이미지 크기값 알려주세요!" + imageWidth );
			System.out.println("이미지 크기값 알려주세요!" + imageHeight );
			
			Image resizeImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
			BufferedImage newImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
			Graphics g = newImage.getGraphics();
			g.drawImage(resizeImage, 0,0,null);
			g.dispose();
			System.out.println("newImage 는 무엇인가?" + newImage);
			ByteArrayOutputStream  baos = new ByteArrayOutputStream();
			ImageIO.write(newImage, imgFormat, baos);
			byte[] bytes = baos.toByteArray();
												
			// result 값이 0이면 파일이 없어서 add추가를 함
			// result 값이 1이면 파일이 있어서 업데이트로 함.
			int result = service.filecheck(nickName);
			if(result == 0) {
				int results = service.fileAdd(bytes, fileName, nickName);
				System.out.println("파일의 결과값을 아려주세요" +results);
				
				if(results ==1) {
					//성공
					return "1";
				}else {
					return "2";
				}
				
			}else {
				int resultUpdate = service.fileout(bytes, nickName);
				System.out.println("파일의 업데이트 값을 알려주세요" +resultUpdate);
				
				if(resultUpdate ==1) {
					//성공
					return "3";
				}else {
					return "4";
				}
			
			}
					
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "0";
		
		
	
		
	}
	
	
	
		
		
		
	
	
	
}
