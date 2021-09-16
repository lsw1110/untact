package com.sbs.untact.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.untact.dto.Article;

//@~~ 치고 "Ctrl + Shift + O" 누르면 자동으로 임포트 됨.
//명령어 일부만 치고 "Ctrl + Space" 누르면 전체 명령어가 뜨고, 그것을 선택하면 임포트까지 같이 된다.

@Controller
public class UsrArticleController {
	private int articlesLaseId;
	private List<Article> articles;
	
	public UsrArticleController() {
		// 멤버변수 초기화
		articlesLaseId = 0;
		articles = new ArrayList<>();
		
		// 게시물 3개 생성
		articles.add(new Article(++articlesLaseId, "2021-09-16 16:32", "제목1", "내용1"));
		articles.add(new Article(++articlesLaseId, "2021-09-16 16:33", "제목2", "내용2"));
		articles.add(new Article(++articlesLaseId, "2021-09-16 16:34", "제목3", "내용3"));
		
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
	
	//http://localhost:8021/usr/article/doAdd?regDate=2021-09-16 17:50:05&title=추가된 제목&body=추가된 내용
	// 위 내용을 입력하면 게시물이 추가 된다.
	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public Map<String, Object> doAdd(String regDate, String title, String body) {
		articles.add(new Article(++articlesLaseId, regDate, title, body));
		
		Map<String, Object> rs = new HashMap<>();
		rs.put("resultCode", "S-1");
		rs.put("msg", "성공하였습니다.");
		rs.put("id", articlesLaseId);
		
		return rs;
	}
	
	//http://localhost:8021/usr/article/doDelete?id=1
	// 위 내용을 입력하면 1번 게시물이 삭제된다.
	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public Map<String, Object> doDelete(int id) {
		boolean deleteArticleRs = deleteArticle(id);
		
		Map<String, Object> rs = new HashMap<>();
		
		if(deleteArticleRs) {
			rs.put("resultCode", "S-1");
			rs.put("msg", "성공하였습니다.");
		}else {
			rs.put("resultCode", "F-1");
			rs.put("msg", "해당 게시물은 존재하지 않습니다.");
		}
		rs.put("id", id);
		
		return rs;
	}

	private boolean deleteArticle(int id) {
		for(Article article : articles) {
			if(article.getId() == id) {
				articles.remove(article);
				return true;
			}
		}
		
		return false;
		
	}
	
}

