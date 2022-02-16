package kr.co.greenart.Service;


import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.co.greenart.model.JoinInfo;
import kr.co.greenart.model.ListInfo;
import kr.co.greenart.model.WritInfo;

public interface lWriteService {

	
	//글쓰기 내용 추가
	int add(WritInfo user, String nickName);
	
	//게시글 보여주는 곳.
	List<ListInfo> look(int count);
	
	//ID에 값을 가지고 다오를 찾는 곳.
	//수정 데이터 값 가져오기
	ListInfo lookId(int id);
	
	
	//업데이트 다오 서비스
	
	int Update(ListInfo list);
	
	//삭제 다오 서비스
	
	int delete(int list);

	// 총 갯수 가져오는 서비스
	int total();
	
	//마이페이지 수정
	JoinInfo lookIds(String name);
	
	//마이페이지 핸드폰 수정
	
	int UpdatePhone(String name, String phone);
	
	//마이페이지 게시글 보여주는 곳
		List<ListInfo> lookMypage(int count);
	
		//마이페이지 수정 후 닉네임,핸드폰,아이디 값 보여주는
		JoinInfo boradlookIds(String id);
		
	//사진 업로드 체크 다오.
	int filecheck(String nickname);	
	//사진 업로드 다오
	int fileAdd(byte[] bytes,String fileName, String nickName);
	//사진 업로드 수정 다오
	int fileUpdate(MultipartFile user, String nickName);
	
	//사진 불러오기
	byte [] fileRead(String nickName);
	
	//사진 다오에 저장하기
	int fileout(byte[] bytes ,String nickName);
	
	//조회수 입력하는 다오.
	int viewsAdd(int tabel, int count);
	
	//조회수 보여주는 다오
	int lookviews(int table);
	
	//조회수 업데이트 다오
	
	int viewUpdate(int bbs ,int count);
	
}
