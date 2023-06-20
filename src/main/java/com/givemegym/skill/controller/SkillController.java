package com.givemegym.skill.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.givemegym.skill.service.SkillService;
import com.givemegym.skill.vo.Skill;

@Controller
@RequestMapping("/frontend_skill")
public class SkillController {

	@Autowired
	private SkillService skillService;

	@GetMapping("/listAll")
	public String findAllSkill(Model model) {
		List<Skill> skillList = skillService.findAll();
		model.addAttribute("skillList", skillList);
		return "frontend/skill/Skill";
	}
}
