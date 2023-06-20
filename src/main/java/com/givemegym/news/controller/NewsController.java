package com.givemegym.news.controller;



import com.givemegym.news.vo.NewsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import com.givemegym.news.service.NewsService;
import org.springframework.web.multipart.MultipartFile;



import java.io.IOException;
import java.util.List;



@Controller
public class NewsController {
	@Autowired
	private NewsService newsService;


	public NewsController(NewsService newsService) {

		this.newsService = newsService;
	}

	//查詢全部==============================================================

	@GetMapping("/FindNewsList")//映射 URL 路徑，表示當使用者訪問該 URL 時，該方法將被執行。
	public String findAll(Model model) {
		List<NewsVo> newsList = newsService.findAll();
		model.addAttribute("newsList", newsList);//利用MODEL放進
		return "/backend/News/FindNewsList";//想要呈現的位置(HTML)
	}

	//新增=================================================================
	@GetMapping("/AddNews")
	public String addNews(ModelMap model) {
		NewsVo newsVo = new NewsVo();
		model.addAttribute("newsVo", newsVo);
		return "/backend/News/AddNews";
	}

	@PostMapping("/saveOrUpdateNews")
	public String saveOrUpdateNews(@Value("value") NewsVo newsVo, BindingResult result, ModelMap model,
								   @RequestParam("newsImg") MultipartFile[] parts) throws IOException {

		List<FieldError> errorsListToKeep = result.getFieldErrors().stream()
				.filter(fieldName -> !fieldName.getField().equals("newsImg")).toList();
		result = new BeanPropertyBindingResult(newsVo, "newsVo");
		for (FieldError fieldError : errorsListToKeep) {
			result.addError(fieldError);
		}
		if (parts[0].isEmpty()) {
			model.addAttribute("errorMessage", "請上傳圖片");
		} else {
			for (MultipartFile multipartFile : parts) {
				byte[] buf = multipartFile.getBytes();
				newsVo.setNewsImg(buf);
			}
		}
		if (result.hasErrors() || parts[0].isEmpty()) {
			return "backend/News/AddNews";
		}

			newsService.saveOrUpdate(newsVo);

			List<NewsVo> list = newsService.findAll();
			model.addAttribute("newsList", list);
			model.addAttribute("Message", "success");
			return "redirect:/backend/News/FindNewsList";
		}
	}
//	更新==================================================================


// 刪除===================================================================










