package com.givemegym.coachschedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.givemegym.coachdayoff.service.CoachDayoffService;
import com.givemegym.coachdayoff.vo.CoachDayoffVo;
import com.givemegym.courseorder.service.CourseOrderService;
import com.givemegym.courseorder.vo.CourseOrder;
import com.givemegym.proclassorder.service.ProclassOrderService;
import com.givemegym.proclassorder.vo.ProclassOrderVo;
@Controller
@RequestMapping("/coachcenter_schedule")
public class CoachScheduleController {

	@Autowired
    private CoachDayoffService coachDayoffService;
	@Autowired
	   private CourseOrderService courseOrderService;
	@Autowired
    	private ProclassOrderService proclassOrderService;
	
	//列出教練所有排程
	@GetMapping("/coachschList/{coachid}")
	public String findByCoachId(@PathVariable Integer coachid, Model model) { 
		List<CoachDayoffVo> dayoffList = coachDayoffService.findByCoachId(coachid);
	    List<ProclassOrderVo> proclassList = proclassOrderService.findByCoachId(coachid);
	    List<CourseOrder> courseList=courseOrderService.findByCoachId(coachid);
	    model.addAttribute("coachList", dayoffList);
	    model.addAttribute("proclassList", proclassList);
	    model.addAttribute("courseList", courseList);
	    return "frontend/proclassorder/frontend_proclassorder";
	}
	
}
