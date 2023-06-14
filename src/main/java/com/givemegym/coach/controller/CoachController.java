package com.givemegym.coach.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.givemegym.coach.service.CoachService;
import com.givemegym.coach.vo.Coach;

@Controller
@RequestMapping("/frontend_coach")
public class CoachController {

	@Autowired
	private CoachService coachService;

	@GetMapping("/listAll")
	public String findAllCoach(Model model) {
		List<Coach> coachList = coachService.findAll();
		model.addAttribute("coachList", coachList);
		return "frontend/coach/coach";
	}

	// 導入新增教練時段的頁面
	@GetMapping("/coach")
	public String addCoach() {
		return "frontend/coach/addcoach";
	}

	// 導入修改教練的頁面
//	@GetMapping("/getOne_For_Update/{periodId}")
//	public String toUpdate(@PathVariable Integer periodId, ModelMap model) {
//		Optional<Period> findPeriod = CoachService.findById(periodId);
//		model.addAttribute("Period", findPeriod.orElseThrow());
//		return "frontend/coach/coach";// 查詢完成後轉交修改教練時段的頁面
//	}

	// 新增教練時段
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(@Valid @ModelAttribute("coach") Coach coach) {
		coachService.saveOrUpdate(coach);
		return "redirect:/frontend_coach/addcoach";
	}

//	動態生成	
//		  @ModelAttribute("coachListData")
//		    protected List<Coach> coachListData() {
////				DeptService deptSvc = new DeptService();
//		        List<Coach> list = CoachService.findAll();
//		        return list;
//		    }
//	}
}
