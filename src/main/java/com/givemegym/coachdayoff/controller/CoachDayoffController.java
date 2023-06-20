package com.givemegym.coachdayoff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.givemegym.coachdayoff.service.CoachDayoffService;
import com.givemegym.coachdayoff.vo.CoachDayoffVo;


public class CoachDayoffController {
	@Controller
	@RequestMapping("/backend_coachmanager")
	public class CoachController{

	@Autowired
	 private CoachDayoffService coachDayoffService;
	@GetMapping("/coachcenter_dayoff")
	public String findAllCoachDayoffVo (Model model) {
	    List<CoachDayoffVo> coachList = coachDayoffService.findAll();
	    model.addAttribute("coachDayoffList", coachList);
	    return "backend/coachDayoff/coachcenter_dayoff";
	}
	@GetMapping("/addCoachDayoff")
	public String addCoachDayoff (Model model) {
	    List<CoachDayoffVo> coachList = coachDayoffService.findAll();
	    model.addAttribute("coachList", coachList);
	    return  "backend/coachDayoff/coachcenter_dayoff";
	}


	@ModelAttribute("coachListData")
	protected List<CoachDayoffVo> referenceListData() {
	//DeptService deptSvc = new DeptService();
	    List<CoachDayoffVo> list = coachDayoffService.findAll();
	    return list;
	}
	
	@GetMapping("/coach-dayoff-records")
    public List<CoachDayoffVo> getCoachDayoffRecordsOrderByTime() {
		  List<CoachDayoffVo> list = coachDayoffService.getAllCoachDayoffRecordsOrderByTime();
        return null;
    }
	}
}