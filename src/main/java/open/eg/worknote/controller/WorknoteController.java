package open.eg.worknote.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import open.eg.worknote.dto.UserDto;
import open.eg.worknote.dto.WorknoteDto;
import open.eg.worknote.service.WorknoteService;
import open.eg.worknote.utils.Utils;

@RestController
public class WorknoteController {
	
	@Autowired
	WorknoteService service;

	@PostMapping("/regi")
	public String addUser(@RequestBody UserDto user) {
		System.out.println("regi");
		System.out.println(user.toString());
		
		boolean checkUsername = service.checkUsername(user);
		if(!checkUsername) {
			return "NO";
		}
		
		boolean checkUser = service.checkUser(user);
		if(checkUser) {
			String id = service.getUserId(user);
			return id;
		} else {
			String id = Utils.getRamdomPassword(10);
			user.setUserid(id);
			boolean regiUser = service.regiUser(user);
			if(regiUser) {
				return id;
			} else {
				return "FAIL";
			}
			
		}
	}
	
	@GetMapping("/status/{userid}")
	public UserDto getStatus(@PathVariable String userid) {
		System.out.println("getStatus");
		
		UserDto user = service.getUserById(userid);
		
		boolean checkStart = service.checkStart(userid);
		if(checkStart) {
			boolean checkEnd = service.checkEnd(userid);
			if(checkEnd) {
				// 오늘 퇴근 이력있음 
				user.setStatus(1);
			} else {
				// 오늘 출근 이력만 있음 
				user.setStatus(2);
			}
		} else {
//			오늘 출근 이력 없음 
			user.setStatus(3);
		}
		
		return user;
	}
	
	@PostMapping("/start")
	public String regiStart(@RequestBody WorknoteDto dto) {
		System.out.println("regiStart");
		
		boolean checkStart = service.checkStart(dto.getUserid());
		if(checkStart) {
			return "ALREADY";
		} else {
			boolean b = service.regiStart(dto);
			if(b) {
				return "YES";
			} else {
				return "FAIL";
			}
		}
	}
	@PostMapping("/end")
	public String regiEnd(@RequestBody WorknoteDto dto) {
		System.out.println("regiEnd");
		
		boolean checkStart = service.checkStart(dto.getUserid());
		if(checkStart) {
			boolean checkEnd = service.checkEnd(dto.getUserid());
			if(checkEnd) {
				return "ALREADY";
			} else {
				boolean b = service.regiEnd(dto);
				if(b) {
					return "YES";
				} else {
					return "FAIL";
				}
			}
		} else {
			return "NO";
		}
	}
}
