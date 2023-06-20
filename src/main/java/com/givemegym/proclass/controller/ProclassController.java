package com.givemegym.proclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.givemegym.proclass.service.ProclassService;
import com.givemegym.proclass.vo.Proclass;


@Controller
@RequestMapping("/proclass")
public class ProclassController {

	private ProclassService proclassService;

	@Autowired
	public ProclassController(ProclassService proclassService) {
		this.proclassService = proclassService;
	}

	// add mapping for "/list"
	@GetMapping("/list")
	public String listCoach(Model theModel) {

		// 取出所有一對一課程
		List<Proclass> allClasses = proclassService.getAllProclasses();

		// 寫入model中
		theModel.addAttribute("allClasses", allClasses);

		// 輸出至頁面
		return "backend/proclass/proclassList";
	}
}
