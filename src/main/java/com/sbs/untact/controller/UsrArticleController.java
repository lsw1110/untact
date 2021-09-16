package com.sbs.untact.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.untact.dto.Article;

//@~~ 치고 "Ctrl + Shift + O" 누르면 자동으로 임포트 됨.
//명령어 일부만 치고 "Ctrl + Space" 누르면 전체 명령어가 뜨고, 그것을 선택하면 임포트까지 같이 된다.

@Controller
public class UsrArticleController {
	private List<Article> articles;
	
	public UsrArticleController() {
		articles = new ArrayList<>();
		
		articles.add(new Article(1, "2021-09-16 16:32", "제목1", "내용1"));
		articles.add(new Article(2, "2021-09-16 16:32", "제목2", "내용2"));
		articles.add(new Article(3, "2021-09-16 16:32", "제목3", "내용3"));
		
	}
	
	@RequestMapping("/usr/article/detail")
	@ResponseBody
	public Article showDetail(int id) {
		return articles.get(id-1);
	}
	// 자동 줄 정리 "Ctrl + Shift + F"
	// RUN AS -> Spring Boot App 선택해서 실행.
	// 사이트 접속 주소 => http://localhost:8021/usr/home/main
	@RequestMapping("/usr/article/list")
	@ResponseBody
	public List<Article> showList() {
		return articles;
	}
}
