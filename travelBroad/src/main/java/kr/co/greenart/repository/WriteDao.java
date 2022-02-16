package kr.co.greenart.repository;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import kr.co.greenart.model.JoinInfo;
import kr.co.greenart.model.ListInfo;
import kr.co.greenart.model.WritInfo;

@Repository
public class WriteDao implements lWriteDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//사용자가 여행 후기를 입력한 내용을 저장하는 쿼리문
	@Override
	public int add(WritInfo w, String nickname) {
		//사용자가 입력한 제목,여행지역,여행날짜,내용,별점,닉네임과
		//오늘날짜를 생성해주는 Date클래스를 사용하여 작성날짜 까지 함께 저장을 해줍니다.
		Date date = new Date();
		String query = "INSERT INTO writetable(nickName,title,location,date,writeDate,text,star)"
				+"VALUES(?,?,?,?,?,?,?)";
		return jdbcTemplate.update(query, nickname, w.getTitle(),w.getLocation(),date,w.getDate()
				,w.getText(),w.getStar());
		
		
	}
	
//	public List<ListInfo> look() {		
//		return jdbcTemplate.query("SELECT id,nickName,title, date FROM writetable limit 10 ",new ListInfoRowMapper()); 
//	}																												   
	
	//bbs.jsp에 게시글 번호,닉네임,타이틀,작성날짜,조회 수 를 보여주는 쿼리문입니다.
	//해당쿼리문을 살펴보면 1) select id,nickName,title,date,count from writetable 까지와
	//2)order by id desc limit 10 offset ?
	//3)as a left join view as b on a id = b.id 
	//로하여 총 3가지 쿼리문으로 나눌 수 있습니다.
	//1) DB에 저장되어 있는 id, nickname,title,date,count를 bbs.jsp에 보여주는 역할을 수행합니다.
	//2) 페이징을 할때 사용하는 쿼리 문입니다.
	//3) left join을 사용하여 조회 수 테이블인 views 테이블을 활용하여 bbs.jsp에 조회 수를 보여주는 역할을 수행합니다.
	//결론- 하나의 쿼리문에 데이터 보여주는 역할,페이징역할,views 테이블의 조회수를 보여주는 3가지 역할을 수행한다고 보시면 됩니다.
	@Override
	public List<ListInfo> look(int page) {
		int a  = (page-1)*10;
		return jdbcTemplate.query("SELECT a.id,a.nickName,a.title, a.writedate, b.count FROM writetable as a left join views as b on a.id = b.id "
				+ "ORDER BY a.ID DESC limit 10 offset ? ",new ListInfoRowMapper(), a); 
		
	}

	
	private class ListInfoRowMapper implements RowMapper<ListInfo>{		
		@Override
		public ListInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			int id = rs.getInt("id");
			String name = rs.getString("nickName");
			String title = rs.getString("title");
			String writedate = rs.getString("writedate");
			int count = rs.getInt("count");
			return new ListInfo(id,name,title,writedate,count);
		}
	}


	@Override
	public List<ListInfo> lookMypage(int page) {
		int a  = (page-1)*5;
		return jdbcTemplate.query("SELECT id,title, date FROM writetable ORDER BY ID DESC limit 5 offset ? ",new ListInfoRowMappers(), a); 
		
		//ListInfoRowMapper를 Autowired 로 쓰는것도 고려해봅시당
	}

	
	private class ListInfoRowMappers implements RowMapper<ListInfo>{		
		@Override
		public ListInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String date = rs.getString("date");
			return new ListInfo(id,title,date);
		}
	}

	

	@Override
	public ListInfo lookId(int name) {
		
		return jdbcTemplate.queryForObject("select id, nickName,title,location,date,writeDate,text,star from writetable where id = ?"
				, new RowMapper<ListInfo>() {
			@Override
			public ListInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return new ListInfo(rs.getInt("id"), rs.getString("nickName"),rs.getString("title"),rs.getString("location"),rs.getString("date")
						,rs.getString("writeDate"),rs.getString("text"),rs.getInt("star")); 
			}}, name);
		
	}

	
	@Override
	public JoinInfo lookIds(String name) {

		return jdbcTemplate.queryForObject("select userid, name,phone,nickname,gender from jointable where name = ?"
				, new RowMapper<JoinInfo>() {
			@Override
			public JoinInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return new JoinInfo(rs.getString("userid"),rs.getString("name"),rs.getString("phone"),rs.getString("nickname"),rs.getString("gender")); 
			}}, name);
		
	}
	
	
	@Override
	public JoinInfo boradlookIds(String id) {
		
		return jdbcTemplate.queryForObject("select userid, name,phone,nickname,gender from jointable where nickName = ?"
				, new RowMapper<JoinInfo>() {
			@Override
			public JoinInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return new JoinInfo(rs.getString("userid"),rs.getString("name"),rs.getString("phone"),rs.getString("nickname"),rs.getString("gender")); 
			}}, id);
		
	}
	
	@Override
	public int Update(ListInfo l) {
		Date date = new Date();
		String query = "update writetable set title = ?, location = ?, date =? ,writedate = ? ,text = ?,star =?  where id = ?";
		return jdbcTemplate.update(query, l.getTitle(),l.getLocation(),l.getDate(),date,l.getText(),l.getStar(),l.getId());
	}

	
	//핸드폰 수정 마이페이지에서
	
	@Override
	public int UpdatePhone(String name, String phone) {
		String query = "update jointable set phone = ? where name = ?";
		return jdbcTemplate.update(query, phone, name);
	}
	
	//삭제 다오문
	@Override
	public int delete(int list) {
		String query = "delete from writetable where id = ?";
		return jdbcTemplate.update(query, list);
	}

	@Override
	public int total() {
		return jdbcTemplate.queryForObject("select count(*) from writetable", int.class);
	}

	//image 테이블에 파일이 있는지 체크
	@Override
	public int filecheck(String nickname) {
		
		return jdbcTemplate.queryForObject("select count(*) from image where nickname = ?"
				, int.class, nickname);
	}

	//image 테이블에 파일이 없으면 추가하는 다오.
	@Override
	public int fileAdd(byte[] bytes,String fileName, String nickName) {
		String query = "INSERT INTO image(nickname,filename,file)VALUES(?,?,?)";
		try {
			return jdbcTemplate.update(query,nickName,fileName,bytes);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//image 테이블에 파일이 있으면 이미지를 변경해주는 다오.
	@Override
	public int fileUpdate(MultipartFile file, String nickName) {
		String query = "update image set filename = ?, file = ?  where nickname = ?";
		try {
			return jdbcTemplate.update(query,file.getOriginalFilename(),file.getBytes(),nickName);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	//마이페이지 이미지 파일 불러오기.
	@Override
	public byte [] fileRead(String nickName) {
		return jdbcTemplate.queryForObject("SELECT file FROM image where nickname = ? ",byte [].class,nickName);
	}

	@Override
	public int fileout(byte[] bytes, String nickName) {
		String query = "update image set file = ?  where nickname = ?";
		return jdbcTemplate.update(query,bytes,nickName);
	}

	@Override
	public int viewsAdd(int tabel, int count) {
		String query = "INSERT INTO views(id,count)VALUES(?,?)";
		return jdbcTemplate.update(query,tabel,count);
	}

	@Override
	public int lookviews(int table) {
		try {
			return jdbcTemplate.queryForObject("select count from views where id = ? "
					, int.class, table);
			
		}catch(DataAccessException e) {
			
		}
		return 0;
	}

	@Override
	public int viewUpdate(int bbs ,int count) {
		String query = "update views set count = ? where id = ?";
		return jdbcTemplate.update(query,count,bbs);
	}

	
	

	}


