package kr.co.greenart.repository;

import kr.co.greenart.model.JoinInfo;
import kr.co.greenart.model.LoginInfo;

public interface IJoinAndLoginDao {
	//회원 추가
	int add(JoinInfo user);
	//로그인 체크
	int IdCheck(String user);

	boolean loginCheck(LoginInfo user);
	//로그인 정보
	LoginInfo viewMember(LoginInfo user);
	
	int login(LoginInfo login);
	//아이디 찾기
	
	//닉네임 중복찾기
	int NickCheck(String nickname);
	//로그인
	int userIdLook(String name, String phone);
	
	//아이디 찾기
	String idFind(String name, String phone);
		
	// 비번 찾기
	String passwordFind(String id, String phone);
	
	
	
}
