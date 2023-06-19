package com.givemegym.coachschedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.givemegym.coachschedule.service.CoachScheduleService;
import com.givemegym.coachschedule.vo.CoachScheduleVo;
@Controller
@RequestMapping("/coachcenter_schedule")
public class CoachScheduleController {

	
	@Autowired
	 private CoachScheduleService  coachScheduleService;
	@GetMapping("/coachList")
	public String findAllCoachVo (Model model) {
	    List<CoachScheduleVo> coachList = coachScheduleService.findAll();
	    model.addAttribute("coachList", coachList);
	    return "backend/coach/coachList";
	}
	@GetMapping("/addCoach")
	public String addCoach (Model model) {
	    List<CoachScheduleVo> coachList = coachScheduleService.findAll();
	    model.addAttribute("coachList", coachList);
	    return "backend/coach/addCoach";
	}

	@GetMapping("/addPeriod")
	public String addPeriod() {
	    return "back-end/period/addPeriod";
	}
	@ModelAttribute("coachListData")
	protected List<CoachScheduleVo> referenceListData() {
	//DeptService deptSvc = new DeptService();
	    List<CoachScheduleVo> list = coachScheduleService.findAll();
	    return list;
	}
}
