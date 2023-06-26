package com.givemegym.proclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.givemegym.proclass.service.ProclassService;
import com.givemegym.proclass.vo.Proclass;
import com.givemegym.skill.service.SkillService;
import com.givemegym.skill.vo.Skill;

@Controller
@RequestMapping("/proclass")
public class ProclassController {

	private ProclassService proclassService;
	private SkillService theSkillService;

	@Autowired
	public ProclassController(ProclassService proclassService, SkillService theSkillService) {
		this.proclassService = proclassService;
		this.theSkillService = theSkillService;
	}

	// add mapping for "/list"
	@GetMapping("/list")
	public String listCoach(Model theModel) {

		// 取出所有一對一課程
		List<Proclass> allClasses = proclassService.getAllProclasses();
		List<Skill> theSkills = theSkillService.showTheSkillList();

		// 寫入model中
		theModel.addAttribute("allClasses", allClasses);
		theModel.addAttribute("skillList", theSkills);

		// 新增一對一課程
		theModel.addAttribute("newProclass", new Proclass());

		// 輸出至頁面
		return "backend/proclass/proclassList";
	}

	@PostMapping("/addProclass")
	public String addNewProclass(@ModelAttribute("newProclass") Proclass theClass) {

		proclassService.save(theClass);

		return "redirect:/proclass/list";
	}

	@GetMapping("/removeClass")
	public String removeProclass(@RequestParam("proclassId") int theId) {

		System.out.println("Proclass Id:" + theId);
		proclassService.deleteById(theId);

		return "redirect:/proclass/list";
	}
}
