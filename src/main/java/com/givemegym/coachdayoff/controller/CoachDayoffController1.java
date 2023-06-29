package com.givemegym.coachdayoff.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.givemegym.coach.service.CoachService;
import com.givemegym.coach.vo.Coach;
import com.givemegym.coachdayoff.service.CoachDayoffService1;
import com.givemegym.coachdayoff.vo.CoachDayOff;

@Controller
@RequestMapping("/coachdayoff")
public class CoachDayoffController1 {

	private CoachDayoffService1 theCoachDayoffService;
	private CoachService theCoachService;

	@Autowired
	public CoachDayoffController1(CoachDayoffService1 theCoachDayoffService, CoachService theCoachService) {
		this.theCoachDayoffService = theCoachDayoffService;
		this.theCoachService = theCoachService;
	}

	@GetMapping("/adm/list")
	public String allDayoff(Model theModel) {

		// get coaches from db
		List<CoachDayOff> theDayOff = theCoachDayoffService.findAll();
		List<Coach> theCoaches = theCoachService.findAll();

		// add to the spring model
		theModel.addAttribute("coachDayoff", theDayOff);
		theModel.addAttribute("coaches", theCoaches);

		theModel.addAttribute("newDayoff", new CoachDayOff());

		return "backend/coachdayoff/addCoachDayoff";
	}

	@PostMapping("/addCoachDayoff")
	public String addNewDayoff(@ModelAttribute("newDayoff") CoachDayOff theDayoff, BindingResult result,
			@RequestParam("offdate") String theDate) {

		LocalDate localDate = LocalDate.parse(theDate);
		theDayoff.setDate(localDate);
		result = new BeanPropertyBindingResult(theDayoff, "newDayoff");

		theCoachDayoffService.addDayoff(theDayoff);

		return "redirect:/coachdayoff/adm/list";
	}
}
