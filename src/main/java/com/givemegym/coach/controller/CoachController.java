package com.givemegym.coach.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.givemegym.coach.service.CoachService;
import com.givemegym.coach.vo.CoachVo;

import aj.org.objectweb.asm.Attribute;

import java.util.*;

@Controller
@RequestMapping("/backend_coachmanager")
public class CoachController{

@Autowired
 private CoachService coachService;
@GetMapping("/coachList")
public String findAllCoachVo (Model model) {
    List<CoachVo> coachList = coachService.findAll();
    model.addAttribute("coachList", coachList);
    return "backend/coach/coachList";
}
@GetMapping("/addCoach")
public String addCoach (Model model) {
    List<CoachVo> coachList = coachService.findAll();
    model.addAttribute("coachList", coachList);
    return "backend/coach/addCoach";
}

@GetMapping("/addPeriod")
public String addPeriod() {
    return "back-end/period/addPeriod";
}
@ModelAttribute("coachListData")
protected List<CoachVo> referenceListData() {
//DeptService deptSvc = new DeptService();
    List<CoachVo> list = coachService.findAll();
    return list;
}

}
