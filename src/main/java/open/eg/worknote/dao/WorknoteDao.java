package open.eg.worknote.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import open.eg.worknote.dto.UserDto;
import open.eg.worknote.dto.WorknoteDto;

@Mapper
@Repository
public interface WorknoteDao {

	int checkUsername(UserDto dto);
	int checkUser(UserDto dto);
	String getUserId(UserDto dto);
	
	int regiUser(UserDto dto);
	UserDto getUserById(String userid);
	
	int checkStart(String userid);
	int checkEnd(String userid);
	
	int regiStart(WorknoteDto dto);
	int regiEnd(WorknoteDto dto);
}
