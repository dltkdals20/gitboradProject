package kr.co.greenart.repository;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.co.greenart.model.JoinInfo;
import kr.co.greenart.model.ListInfo;
import kr.co.greenart.model.LoginInfo;
import kr.co.greenart.model.WritInfo;

public interface lWriteDao {
	//게시글 등록
	int add(WritInfo write , String nickname);
	
	//게시글 보여주는 것.
	List<ListInfo> look(int count);
	
	//해당하는 아이디에 대한 글 보여주는 곳.
	ListInfo lookId(int name);
		
	//업데이트 다오 문
	int Update(ListInfo list);
	
	//삭제 다오문
	int delete(int  list);
	
	//총페이지 갯수 다오문
	int total();
	
	//마이페이지 핸드폰 수정
	
	int UpdatePhone(String name, String phone);
	
	//마이페이지 수정 다오
	JoinInfo lookIds(String name);
	
	//마이페이지 게시글 보여주는 곳
	List<ListInfo> lookMypage(int count);
	
	//마이페이지 수정 후 닉네임,핸드폰,아이디 값 보여주는
	JoinInfo boradlookIds(String id);
	
	//마이페이지 사진 업로드 했을때 다오에서 이미지와 닉네임이 있는지 확인
	int filecheck(String nickname);
	
	
	//마이페이지 사진 업로드 다오에 추가
	int fileAdd(byte[] bytes,String fileName, String nickName);
	
	//사진 업로드 수정 다오
	int fileUpdate(MultipartFile user, String nickName);
	
	//마이페이지 사진 불러오기
	byte [] fileRead(String nickName);
	//마이페이지 사진 다오에 저장하기
	int fileout(byte[] bytes ,String nickName);
	
	//조회수 입력하는 다오.
	int viewsAdd(int tabel, int count);
	
	//조회수 보여주는 다오
	int lookviews(int table);
	
	//조회수 업데이트 다오
	
	int viewUpdate(int bbs, int count);
	
}
