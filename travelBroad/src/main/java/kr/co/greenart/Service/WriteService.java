package kr.co.greenart.Service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.greenart.model.JoinInfo;
import kr.co.greenart.model.ListInfo;
import kr.co.greenart.model.WritInfo;
import kr.co.greenart.repository.WriteDao;

@Service
public class WriteService implements lWriteService {

	@Autowired
	private WriteDao dao;
	
	@Override
	public int add(WritInfo write , String user) {
		// TODO Auto-generated method stub
		return dao.add(write, user);
	}

	@Override
	public List<ListInfo> look(int count) {
		// TODO Auto-generated method stub
		return dao.look(count);
	}

	@Override
	public ListInfo lookId(int id) {
		// TODO Auto-generated method stub
		return dao.lookId(id);
	}

	@Override
	public int Update(ListInfo list) {
	
		return dao.Update(list);
	}

	@Override
	public int delete(int list) {
		// TODO Auto-generated method stub
		return dao.delete(list);
	}

	@Override
	public int total() {
	
		return dao.total();
	}

	@Override
	public JoinInfo lookIds(String name) {
		
		return dao.lookIds(name);
	}

	@Override
	public int UpdatePhone(String name, String phone) {
		
		return dao.UpdatePhone(name, phone);
	}

	@Override
	public List<ListInfo> lookMypage(int page) {
		
		return dao.lookMypage(page);
	}

	@Override
	public JoinInfo boradlookIds(String id) {
		// TODO Auto-generated method stub
		return dao.boradlookIds(id);
	}

	@Override
	public int filecheck(String nickname) {
		// TODO Auto-generated method stub
		return dao.filecheck(nickname);
	}


	@Override
	public int fileAdd(byte[] bytes,String fileName, String nickName) {
		// TODO Auto-generated method stub
		return dao.fileAdd(bytes,fileName, nickName);
	}

	@Override
	public int fileUpdate(MultipartFile user, String nickName) {
		// TODO Auto-generated method stub
		return dao.fileUpdate(user, nickName);
	}

	@Override
	public byte [] fileRead(String nickName) {
		// TODO Auto-generated method stub
		return dao.fileRead(nickName);
	}

	@Override
	public int fileout(byte[] bytes, String nickName) {
		// TODO Auto-generated method stub
		return dao.fileout(bytes, nickName);
	}

	@Override
	public int viewsAdd(int tabel, int count) {
		// TODO Auto-generated method stub
		return dao.viewsAdd(tabel, count);
	}
	//조회수 보여주는 다오
	@Override
	public int lookviews(int table) {
		// TODO Auto-generated method stub
		return dao.lookviews(table);
	}

	@Override
	public int viewUpdate(int bbs ,int count) {
		// TODO Auto-generated method stub
		return dao.viewUpdate(bbs, count);
	}

	
	


}
