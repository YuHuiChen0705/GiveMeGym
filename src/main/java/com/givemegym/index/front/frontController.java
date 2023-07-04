package com.givemegym.index.front;

import com.givemegym.news.service.NewsService;
import com.givemegym.news.vo.NewsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/GiveMeGym")
@Controller
public class frontController {

    @Autowired
    NewsService newsService;

    @GetMapping("/index")
    public String frontIndex(ModelMap model){
        List<NewsVo> newsList = newsService.findAll();
        model.addAttribute("newsList", newsList);

        return "frontend/index";
    }
}
