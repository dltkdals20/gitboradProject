package kr.co.greenart.Service;

import javax.servlet.http.HttpSession;

import kr.co.greenart.model.JoinInfo;
import kr.co.greenart.model.LoginInfo;

public interface IJoinAndLoginService {
	
	
	
	//회원 추가
	int add(JoinInfo user);
	//아이디 중복 체크
	int Idcheck(String user);
	
	//로그인
	int login(LoginInfo loginInfo);
	//아이디 중복찾기
	boolean	loginCheck(LoginInfo user, HttpSession session);
	//회원 로그인 정보
	LoginInfo viewMember(LoginInfo vo);
	
	//닉네임 중복찾기
	int NickCheck(String nickname);
	//아이디 찾기
	// 아이디 찾기 버튼을 눌리면 창이 뜨고 사용자의 이름과 폰넘버를 넣어서 해당하는 아이디 값을 디비에서 조회를 한뒤에 사용자한테 
	// 해당 아이디를 알려준다.
	//창을 띄우게 하는 방법, 페이지로 이동시키는 방법
	int userIdLook(String name, String phone);
	
	//비밀번호 찾기
	int passwordLook(String userid, String phone);
	
	//로그아웃
	
	public void logout(HttpSession session);
	
	//아이디 찾기
	String idFind(String name, String phone);
	
	// 비번 찾기
	String passwordFind(String id, String phone);
}
