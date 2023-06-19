package com.givemegym.courseshowoff.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.givemegym.courseshowoff.service.CourseShowOffService;
import com.givemegym.courseshowoff.vo.CourseShowOffVo;


public class CourseShowOffcontroller {
	
	@Controller
	@RequestMapping("/backend_courseshowoff")
	public class courseshowoffController {
		
		@Autowired
		 private CourseShowOffService courseshowoffService;
		
//		@Autowired
//		private MemberService memberService
	//	
		 @GetMapping("/listAllcourseshowoff")
		    public String findAllPeriod(Model model) {    
		        List<CourseShowOffVo> courseshowoffList = courseshowoffService.findAll();//找列表
		        model.addAttribute("courseshowoffList", courseshowoffList);//利用MODEL放進
		        return "backend/courseshowoff/courseshowoffList";//想要呈現的位置(HTML)
		    }
//		 @ModelAttribute("courseListData")
//		 protected List<Course> refer
		 
		 
//		 導入新增頁面
@GetMapping("/addcourseshowoff")
public String addcourseshowoff() {return "backend/courseshowoff/addcourseshowoff";}


// 新增
@PostMapping("/saveOrUpdate")
public String saveOrUpdate(@Valid CourseShowOffVo courseshowoff) {
	courseshowoffService.saveOrUpdate(courseshowoff);
	return"redirect:/backend_courseshowoff/listALL";//從導到list這個方法
	
	
	
//	 @PostMapping("/saveOrUpdate")
//	    public String saveOrUpdate(@Valid Period period) {
//	        periodService.saveOrUpdate(period);
//	        return "redirect:/period/listAll";
//	    }
//	 @ModelAttribute("courseListData")
//	    protected List<Course> referenceListData() {
//	//  DeptService deptSvc = new DeptService();
//	        List<Course> list = courseService.findAll();
//	        return list;
//	    }
	
	
}





		 
	}
}
