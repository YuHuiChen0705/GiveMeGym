package com.givemegym.news.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.givemegym.news.service.NewsService;
import com.givemegym.news.vo.NewsVo;



public class NewsController {
	
	@Controller
	@RequestMapping("/frontend_news")
	public class Newscontroller {
		
		@Autowired
		 private NewsService newsService;
		
//		@Autowired
//		private MemberService memberService
	//
		
		
//查詢全部==============================================================
		
		 @GetMapping("/listAllnews")//是該映射的 URL 路徑，表示當使用者訪問該 URL 時，該方法將被執行。
		    public String findAllnews(Model model) {    
		        List<NewsVo> newsList = newsService.findAll();//找列表
		        model.addAttribute("newsList", newsList);//利用MODEL放進
		        return "backend/newsList";//想要呈現的位置(HTML)
		    }
		 
//查詢單個
		 
		 
		 
		 
		 
//

	}

}
