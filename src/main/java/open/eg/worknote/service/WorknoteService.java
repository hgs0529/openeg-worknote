package open.eg.worknote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import open.eg.worknote.dao.WorknoteDao;
import open.eg.worknote.dto.UserDto;
import open.eg.worknote.dto.WorknoteDto;

@Service
@Transactional
public class WorknoteService {
	
	@Autowired
	WorknoteDao dao;
	
	public boolean checkUsername(UserDto dto) {
		int n = dao.checkUsername(dto);
		return n > 0 ? true : false;
	}

	public boolean checkUser(UserDto dto) {
		int n = dao.checkUser(dto);
		return n > 0 ? true : false;
	}
	
	public String getUserId(UserDto dto) {
		return dao.getUserId(dto);
	}
	
	public boolean regiUser(UserDto dto) {
		int n = dao.regiUser(dto);
		return n > 0 ? true : false;
	}
	
	public UserDto getUserById(String userid) {
		return dao.getUserById(userid);
	}
	
	public boolean checkStart(String userid) {
		int n = dao.checkStart(userid);
		return n > 0 ? true : false;
	}
	
	public boolean checkEnd(String userid) {
		int n = dao.checkEnd(userid);
		return n > 0 ? true : false;
	}
	
	public boolean regiStart(WorknoteDto dto) {
		int n = dao.regiStart(dto);
		return n > 0 ? true : false;
	}
	
	public boolean regiEnd(WorknoteDto dto) {
		int n = dao.regiEnd(dto);
		return n > 0 ? true : false;
	}
}
