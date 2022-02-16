package kr.co.greenart.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class ImageUploadController {
	
	//이미지 업로드를 하는 메소드 입니다.
	@CrossOrigin("*")
	@RequestMapping(value="/mine/imageUpload.do",method = RequestMethod.POST)
	public void imageUpload(HttpServletRequest request, HttpServletResponse response, MultipartHttpServletRequest meultFile,@RequestParam MultipartFile upload) {
		//랜덤 문자 생성을 하여 그림 파일에 대한 고유한 이름 주는 역할을 함.
		UUID uid = UUID.randomUUID();
		
		OutputStream out = null;
		PrintWriter printWriter = null;
		
		//인코딩
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	
	
		try {
			
			String fileName = upload.getOriginalFilename();
			byte[]bytes =upload.getBytes();
			
			//이미지 저장소
			String path = "d:\\resources\\ckImage\\";
			String ckUploadpath = path + uid +"_"+fileName;
			File folder = new File(path);
			
			System.out.println(folder.getCanonicalPath());
			//폴더가 없으면 폴더를 생성해줍니다.
			if(!folder.exists()) {
				try {
					folder.mkdirs();
				}catch(Exception e) {
					e.getStackTrace();
				}
			}
			//이미지를 파일에 저장을 해줍니다.
			out = new FileOutputStream(new File(ckUploadpath));
			out.write(bytes);
			out.flush();
			
			String callback = request.getParameter("CKEditorFuncNum");
			printWriter = response.getWriter();
			String fileUrl = "/mine/ckImgSubmit.do?uid=" + uid +"&fileName="+fileName;
			
			printWriter.println("{\"filename\":\""+fileName+"\",\"uploaded\":1,\"url\":\""+fileUrl+"\"}");
			printWriter.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(out !=null) {out.close();}
				if(printWriter !=null) {printWriter.close();}
			}catch(IOException e) {e.printStackTrace();}
		}	
		return;
	}

	
	//업로드된 이미지를 textaraea에 그림을 붙여주는 역할을 합니다.
	@RequestMapping(value="/mine/ckImgSubmit.do")
	public void ckSubmit(@RequestParam(value="uid") String uid,@RequestParam(value="fileName")String fileName
							,HttpServletRequest request, HttpServletResponse response) throws IOException {
		//이미지 파일이 저장된 경로를 적어줍니다.
		String path = "d:\\resources\\ckImage\\";
		String sDirPath = path +uid+"_"+fileName;
		//이미지 파일을 생성을 해줍니다.
		File imgFile = new File(sDirPath);
		System.out.println("이미지 파일을 읽어와주세요!!!!!!!!!!" +fileName);
		
		//이미지 파일을 읽어줍니다.
		if(imgFile.isFile()) {
			byte[]buf= new byte[10000000]; //jpg 파일 크기를 잡음.
			int readByte =0;
			int length = 0;
			byte[]imgBuf= null;
			
			FileInputStream fileInputStream = null;
			ByteArrayOutputStream outputSteam = null;
			ServletOutputStream out = null;
			
			try {
				fileInputStream = new FileInputStream(imgFile);
				outputSteam = new ByteArrayOutputStream();
				out = response.getOutputStream();
				
				while((readByte = fileInputStream.read(buf))!=-1) {
					outputSteam.write(buf,0,readByte);
				}
			
				imgBuf = outputSteam.toByteArray();
				length = imgBuf.length;
				out.write(imgBuf,0,length);
				out.flush();
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
				outputSteam.close();
				fileInputStream.close();
				out.close();
			}
			
		}
	}
	
	
}
