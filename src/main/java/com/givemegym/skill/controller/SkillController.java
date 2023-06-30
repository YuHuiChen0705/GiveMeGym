package com.givemegym.skill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.givemegym.skill.service.SkillServiceImpl;
import com.givemegym.skill.vo.Skill;

@Controller
@RequestMapping("/skill")
public class SkillController {

	private SkillServiceImpl skillserviceImpl;

	@Autowired
	public SkillController(SkillServiceImpl skillserviceImpl) {
		this.skillserviceImpl = skillserviceImpl;
	}

	@GetMapping("/adm/list")
	public String showTheSkillPage(Model theModel) {

		List<Skill> theSkills = skillserviceImpl.showTheSkillList();

		theModel.addAttribute("skillList", theSkills);

		theModel.addAttribute("newSkill", new Skill());

		return "backend/skill/addSkill";
	}

	@PostMapping("/addSkill")
	public String addNewSkill(@ModelAttribute("newSkill") Skill theSkill) {

		skillserviceImpl.save(theSkill);

		return "redirect:/skill/adm/list";
	}

	@GetMapping("/removeSkill")
	public String deleteSkill(@RequestParam("skillId") int theId) {

		skillserviceImpl.deleteById(theId);

		return "redirect:/skill/adm/list";
	}

	@PostMapping("/updateSkill")
	public String updateSkillData(@RequestParam("skillId") int skillId, @RequestParam("skillName") String skillName) {

		Skill theSkill = skillserviceImpl.findById(skillId);

		theSkill.setSkillName(skillName);

		skillserviceImpl.save(theSkill);

		return "redirect:/skill/adm/list";
	}
}
