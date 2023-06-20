package com.givemegym.coach.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.givemegym.coach.service.CoachService;
import com.givemegym.coach.vo.Coach;
import com.givemegym.skill.service.SkillService;
import com.givemegym.skill.vo.Skill;

@Controller
@RequestMapping("/coach")
public class CoachController {

	private CoachService theCoachService;
	private SkillService theSkillService;
	
	@Autowired
	public CoachController(CoachService theCoachService, SkillService theSkillService) {
		this.theCoachService = theCoachService;
		this.theSkillService = theSkillService;
	}

	// add mapping for "/list"
	@GetMapping("/list")
	public String listCoach(Model theModel) {
		
		// get coaches from db
		List<Coach> theCoaches = theCoachService.findAll();
		
		// add to the spring model
		theModel.addAttribute("coaches", theCoaches);
		
		return "frontend/coach";
	}
	
	@GetMapping("/detail/{coachId}")
	public String theCoach(@PathVariable(value = "coachId") int coachId, Model theModel) {
		
		// 調用教練的Controller，讀取教練的資料
		Coach theCoach = theCoachService.findById(coachId);

		// 取得該教練所有的技能
		List<Skill> allSkills = theSkillService.findAlltheSkills(coachId);

		// 將教練資料收到物件裡面
		theModel.addAttribute("theCoach", theCoach);
		
		// 將技能資料收到物件裡面
		theModel.addAttribute("allSkills", allSkills);
		
		return "frontend/coach/coach_detail";
	}
}
