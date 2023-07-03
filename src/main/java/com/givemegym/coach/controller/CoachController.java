package com.givemegym.coach.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.givemegym.coach.service.CoachService;
import com.givemegym.coach.vo.Coach;
import com.givemegym.coachskill.service.CoachSkillService;
import com.givemegym.coachskill.vo.CoachSkill;
import com.givemegym.skill.service.SkillService;
import com.givemegym.skill.vo.Skill;

@Controller
@RequestMapping("/coach")
public class CoachController {

	private CoachService theCoachService;
	private SkillService theSkillService;
	private CoachSkillService theCoachSkillService;

	@Autowired
	public CoachController(CoachService theCoachService, SkillService theSkillService,
			CoachSkillService theCoachSkillService) {
		this.theCoachService = theCoachService;
		this.theSkillService = theSkillService;
		this.theCoachSkillService = theCoachSkillService;
	}

	// add mapping for "/list"
	@GetMapping("/list")
	public String listCoach(Model theModel) {

		List<Coach> theCoaches = theCoachService.findAll();

		theModel.addAttribute("coaches", theCoaches);

		return "frontend/coach/coach";
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

	@GetMapping("/adm/list")
	public String coachManagement(Model theModel) {

		List<Coach> theCoaches = theCoachService.findAll();
		List<Skill> theSkills = theSkillService.showTheSkillList();

		theModel.addAttribute("theDetails", theCoaches);
		theModel.addAttribute("skillList", theSkills);

		theModel.addAttribute("newCoach", new Coach());

		return "backend/coach/addCoach";
	}

	@PostMapping("/addCoach")
	public String addNewCoach(@ModelAttribute("newCoach") Coach newCoach, BindingResult result,
			@RequestParam("skillId") List<Integer> newSkill, @RequestParam("coachPic") MultipartFile[] thePhoto) {

		System.out.println("Skill Id:" + newSkill);
		result = new BeanPropertyBindingResult(newCoach, "newCoach");
		try {
			if (!thePhoto[0].isEmpty()) {
				for (MultipartFile multipartFile : thePhoto) {
					byte[] buf = multipartFile.getBytes();
					newCoach.setCoachPic(buf);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		theCoachService.save(newCoach);

		List<CoachSkill> prefessions = new ArrayList<>();
		for (Integer theSkillId : newSkill) {
			prefessions.add(new CoachSkill(newCoach, theSkillService.findById(theSkillId)));
		}

		theCoachSkillService.save(prefessions);

		return "redirect:/coach/adm/list";
	}

	@PostMapping("/updateCoach")
	public String updateCoachData(@RequestParam("coachId") int coachId, @RequestParam("coachName") String coachName,
			@RequestParam("coachPhoto") MultipartFile[] coachPhoto, @RequestParam("coachIntro") String coachIntro)
			throws IOException {

		Coach theCoach = theCoachService.findById(coachId);

		theCoach.setCoachName(coachName);
		theCoach.setCoachDetail(coachIntro);

		if (coachPhoto[0].isEmpty()) {
			byte[] thePhoto = theCoach.getCoachPic();
			theCoach.setCoachPic(thePhoto);
		} else {
			for (MultipartFile multipartFile : coachPhoto) {
				byte[] buf = multipartFile.getBytes();
				theCoach.setCoachPic(buf);
			}
		}

		theCoachService.save(theCoach);

		return "redirect:/coach/adm/list";
	}
}
