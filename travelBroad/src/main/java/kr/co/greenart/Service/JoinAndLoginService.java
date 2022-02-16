package kr.co.greenart.Service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.greenart.model.JoinInfo;
import kr.co.greenart.model.LoginInfo;
import kr.co.greenart.repository.JoinAndLoginDao;

@Service
public class JoinAndLoginService implements IJoinAndLoginService {
	public static String pnickname;
	public static String pnickNickName;
	
	@Autowired
	private JoinAndLoginDao dao;
	
	//회원가입 정보 저장 하는 서비스
	@Override
	public int add(JoinInfo user) {
		
		return dao.add(user);
	}

	//아이디값 중복 체크
	
	@Override
	public int Idcheck(String user) {
			return dao.IdCheck(user);
	}

	//로그인 체크
	@Override
	public boolean loginCheck( LoginInfo user , HttpSession session) {
		boolean result = dao.loginCheck(user);
		System.out.println("정말 투르가 나올까?!!!!!!!!!!!!!!!!!!!!!!!!!!!! " + result);
		if(result) {
			System.out.println("++++++++++++++++++++++++++++++");
			LoginInfo vo2 = viewMember(user);
			System.out.println("이거 맞라아라!!!!!!!!!!!!!!!!" + vo2.toString());
			session.setAttribute("userId", vo2.getUserId());
			session.setAttribute("userName", vo2.getName());
			session.setAttribute("nickName", vo2.getNickname());
			pnickNickName = vo2.getNickname();
			pnickname = vo2.getName();
			System.out.println("pnickname 값을 알려주세요" +pnickname);
			
		}
		return result;
	}

	//로그인 정보
	@Override
	public LoginInfo viewMember(LoginInfo vo) {
		System.out.println("찍혀라!!!!!!!!!!!!!!!!!!" + vo.toString());
		return dao.viewMember(vo);
		
	}
	
	//닉네임 중복값 찾기
	@Override
	public int NickCheck(String nickname) {
		return dao.NickCheck(nickname);
	}

	@Override
	public int login(LoginInfo login) {
			return dao.login(login);
	}


	@Override
	public int userIdLook(String name, String phone) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int passwordLook(String userid, String phone) {
		// TODO Auto-generated method stub
		return 0;
	}
	//로그아웃 서비스
	@Override
	public void logout(HttpSession session) {
		session.invalidate();
		
	}
	
	// 아이디 찾기
	@Override
	public String idFind(String name, String phone) {
		return dao.idFind(name, phone);
	}
	
//	// 비번 찾기
	@Override
	public String passwordFind(String id, String phone) {
		return dao.passwordFind(id, phone);
	}




}
