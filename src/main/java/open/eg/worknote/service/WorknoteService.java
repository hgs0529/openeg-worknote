package open.eg.worknote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import open.eg.worknote.dao.WorknoteDao;

@Service
@Transactional
public class WorknoteService {
	
	@Autowired
	WorknoteDao dao;

	public int test() {
		return dao.test();
	}
}
