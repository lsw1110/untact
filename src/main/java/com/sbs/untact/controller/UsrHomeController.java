package com.sbs.untact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@~~ 치고 "Ctrl + Shift + O" 누르면 자동으로 임포트 됨.
//명령어 일부만 치고 "Ctrl + Space" 누르면 전체 명령어가 뜨고, 그것을 선택하면 임포트까지 같이 된다.

@Controller
public class UsrHomeController {
	
	// 자동 줄 정리 "Ctrl + Shift + F"
	// RUN AS -> Spring Boot App 선택해서 실행.
	// 사이트 접속 주소 => http://localhost:8021/usr/home/main
	@RequestMapping("/usr/home/main")
	@ResponseBody
	public String showMain() {
		return "안녕! DreamIS";
	}
}

