package kr.co.greenart.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.co.greenart.model.JoinInfo;
import kr.co.greenart.model.LoginInfo;

@Repository
public class JoinAndLoginDao implements IJoinAndLoginDao  {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	@Override
	public int add(JoinInfo u) {
		String query = "INSERT INTO jointable(userid,password,name,phone,nickname,gender,checkbox,othertravel)"
				+"VALUES(?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(query, u.getUserId(),u.getPassword(),u.getName(),u.getPhone()
				,u.getNickName(),u.getGender(),u.getCheckBox(),u.getOtherTravel());
	}

	//아이디 중복값 찾기
	@Override
	public int IdCheck( String user) {
		
		return jdbcTemplate.queryForObject("select count(*) from jointable where userid = ?"
				, int.class, user);
		
	}
	@Override
	public boolean loginCheck( LoginInfo user) {
		
		return jdbcTemplate.queryForObject("select count(*) from jointable where userid = ? and password =?"
				, boolean.class, user.getUserId(),user.getPassword());
		
	}
	//닉네임 중복값 찾기
	@Override
	public int NickCheck(String nickname) {
		return jdbcTemplate.queryForObject("select count(*) from jointable where nickName = ?"
				, int.class, nickname);
	}


	//로그인 정보값
	@Override
	public LoginInfo viewMember(LoginInfo user) {
		return jdbcTemplate.queryForObject("select userId, name,nickname from jointable where userid = ? and password =?"
				, new RowMapper<LoginInfo>() {
					@Override
					public LoginInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						return new LoginInfo(rs.getString("userId"), rs.getString("name"),rs.getString("nickname"));
					}}, user.getUserId(),user.getPassword());
	}

	
	@Override
	public int userIdLook(String name, String phone) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int login(LoginInfo login) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 아이디 찾기
//	@Override
//	public String idFind(String name, String phone) {
//		return jdbcTemplate.queryForObject("select userid from jointable where name = ? and phone = ?"
//				, String.class, name, phone);
//	}
	
	// 아이디 찾기
	@Override
	public String idFind(String name, String phone) {
		try {
			return jdbcTemplate.queryForObject("select userid from jointable where name = ? and phone = ?"
					, String.class, name, phone);
			
		}catch(DataAccessException e) {
			
		}
		return "fail";
	}

	
//	// 비번 찾기
	@Override
	public String passwordFind(String id, String phone) {
		try {
			return jdbcTemplate.queryForObject("select password from jointable where userId = ? and phone = ?"
					, String.class, id, phone);
			
		}catch(DataAccessException e) {
			
		}
		return "fail";
	}


}
