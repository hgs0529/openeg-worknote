package open.eg.worknote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import open.eg.worknote.service.WorknoteService;
import open.eg.worknote.util.hexrandom;

@RestController
public class WorknoteController {
	
	@Autowired
	WorknoteService service;

	@PostMapping("/regi")
	public String addWorker(String worker) {
		System.out.println("addWorker");
		System.out.println(worker);
		String num = hexrandom.getRandomHexString(10);
		int n = service.test();
		System.out.println(n);
		return num;
	}
}
