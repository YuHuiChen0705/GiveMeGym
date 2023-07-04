package com.givemegym.news.controller;

import com.givemegym.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Controller
@RequestMapping("/reader")
public class ReaderController {

    @Autowired
    NewsService newsService;

    @GetMapping("/NewsReader")
    public void NewsReader(@RequestParam("newsId") String newsId, HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        res.setContentType("image/gif");
        ServletOutputStream out = res.getOutputStream();

        try {
            out.write(newsService.getOneNews(Integer.valueOf(newsId)).getNewsImg());
        } catch (Exception e) {
            byte[] buf = java.util.Base64.getDecoder().decode("R0lGODlhAQ");
            out.write(buf);
        }
    }
}
