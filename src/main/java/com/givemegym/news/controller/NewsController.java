package com.givemegym.news.controller;

import com.givemegym.news.dao.NewsDao;
import com.givemegym.news.service.NewsService;
import com.givemegym.news.vo.NewsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
@Controller
public class NewsController {
	private final NewsService newsService;
	private final NewsDao newsDao;

	@Autowired
	public NewsController(NewsService newsService,
						  NewsDao newsDao) {
		this.newsService = newsService;
		this.newsDao = newsDao;
	}

	// 查詢全部
	@GetMapping("/FindNewsList")
	public String findAll(Model model) {
		List<NewsVo> newsList = newsService.findAll();
		model.addAttribute("newsList", newsList);
		return "/backend/news/FindNewsList";
	}
//	===========================================================================

	//		 新增
	@GetMapping("/AddNews")
	public String addNews(ModelMap model) {
		NewsVo newsVo = new NewsVo();
		LocalDate currentDate = LocalDate.now();
		model.addAttribute("currentDate", currentDate);
		model.addAttribute("newsVo", newsVo);
		return "/backend/news/AddNews";
	}

	@PostMapping("/AddNews")
	public String addNews(@Valid NewsVo newsVo, BindingResult result, ModelMap model,
						  @RequestParam("newsImg") MultipartFile newsImg) throws IOException {
		List<FieldError> errorsListToKeep = result.getFieldErrors().stream()
				.filter(fieldError -> !fieldError.getField().equals("newsImg"))
				.collect(Collectors.toList());
		result = new BeanPropertyBindingResult(newsVo, "newsVo");
		for (FieldError fieldError : errorsListToKeep) {
			result.addError(fieldError);
		}
		if (newsImg.isEmpty()) {
			model.addAttribute("newsVo", newsVo);

		}
		if (result.hasErrors()) {
			model.addAttribute("newsVo", newsVo);
			return "/backend/news/AddNews";
		}
		byte[] image = newsImg.getBytes();
		newsVo.setNewsImg(image);
		newsService.save(newsVo);

		// 保留除了"newsImg")
		return "redirect:/FindNewsList";
	}

//	=====================================================================================


	//修改


	@GetMapping("/getOne_For_Update/{newsId}")
	public String getOne_For_Update(@PathVariable("newsId") String newsId, ModelMap model) {

		NewsVo newsVo = newsService.getOne_For_Update(Integer.valueOf(newsId));
		model.addAttribute("newsVo", newsVo);
		return "backend/news/UpdateNews";
	}

	@PostMapping("/UpdateNews")
	public String updateNews(@Valid NewsVo newsVo, BindingResult result, ModelMap model,
							 @RequestParam("newsImg") MultipartFile[] parts) throws IOException {


		List<FieldError> errorsListToKeep = result.getFieldErrors().stream()
				.filter(fieldError -> !fieldError.getField().equals("newsImg"))
				.collect(Collectors.toList());
		result = new BeanPropertyBindingResult(newsVo, "newsVo");
		for (FieldError fieldError : errorsListToKeep) {
			result.addError(fieldError);
		}
		if (parts[0].isEmpty()) {
			byte[] image = newsService.getOne_For_Update(newsVo.getNewsId()).getNewsImg();
			newsVo.setNewsImg(image);
		} else {
			for (MultipartFile multipartFile : parts) {
				byte[] image = multipartFile.getBytes();
				newsVo.setNewsImg(image);
			}
		}
		if (result.hasErrors()) {
			System.out.println("here");
			return "backend/news/UpdateNews";
		}
		newsService.update(newsVo);
		model.addAttribute("success", "修改成功");
		model.addAttribute("newsVo", newsVo);
		System.out.println("success");
		return "redirect:/FindNewsList";
	}





	//	 刪除
	@GetMapping("/newsList/{newsId}")
	public String deleteNews(@PathVariable Integer newsId) {
		newsService.deleteNewsById(newsId);
		return "redirect:/FindNewsList";

	}



	@GetMapping("/images/{newsId}")
	public List<String> getImageList(Integer newsId) {
		List<byte[]> imagePaths = newsService.findByNewsId(newsId);
		List<String> imageList = new ArrayList<>();
		for (byte[] imagePath : imagePaths) {
			String base64Image = Base64.getEncoder().encodeToString(imagePath);
			imageList.add(base64Image);
		}
		return imageList;
	}
//放到前台輪播


@GetMapping("/AllNewsList")
	public String AllNewsList(ModelMap model) {
        List<NewsVo> newsList = newsService.findAll();
        model.addAttribute("newsList", newsList);
        return "/frontend/index";
    }





}





