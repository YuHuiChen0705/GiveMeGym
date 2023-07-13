package com.givemegym.coachschedule.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.givemegym.coachdayoff.service.CoachDayoffService;
import com.givemegym.coachdayoff.vo.CoachDayoffVo;
import com.givemegym.courseschedule.service.CourseScheduleService;
import com.givemegym.courseschedule.vo.CourseSchedule;
import com.givemegym.proclassorder.service.ProclassOrderService;
import com.givemegym.proclassorder.vo.ProclassOrderVo;
@Controller
@RequestMapping("/coachcenter_schedule")
public class CoachScheduleController {

	@Autowired
    private CoachDayoffService coachDayoffService;
	@Autowired
	   private CourseScheduleService courseScheduleService;
	@Autowired
    	private ProclassOrderService proclassOrderService;
	
	//列出教練所有排程
	@GetMapping("/coachschList/{coachid}")
	public String findByCoachId(@PathVariable Integer coachid, Model model) { 
		List<CoachDayoffVo> dayoffList = coachDayoffService.findByCoachId(coachid);
	    List<ProclassOrderVo> proclassList = proclassOrderService.findByCoachId(coachid);
	    List<CourseSchedule> courseScList=courseScheduleService.findByCoachId(coachid);
	    model.addAttribute("dayoffList", dayoffList);
	    model.addAttribute("proclassList", proclassList);
	    model.addAttribute("courseScList", courseScList);
	    
	    List<Object> events = new ArrayList<>(); // 建立一個新的列表來儲存事件
	    
	    // 迭代dayoffList並將每個元素轉換為事件物件並新增到events列表中
	    for (CoachDayoffVo dayoff : dayoffList) {
	        Map<String, Object> event = new HashMap<>();
	        event.put("title", "休假"+dayoff.getCoachDayoffTime());
	        event.put("start", dayoff.getCoachDayoffDate());
	        events.add(event);
	    }
	    
	    // 迭代proclassList並將每個元素轉換為事件物件並新增到events列表中
	    for (ProclassOrderVo proclass : proclassList) {
	        Map<String, Object> event = new HashMap<>();
	        event.put("title", proclass.getProClassName()+proclass.getProClassTime());
	        event.put("start", proclass.getProClassDate());

	        events.add(event);
	    }
	    
	    // 迭代courseList並將每個元素轉換為事件物件並新增到events列表中
	    for (CourseSchedule course : courseScList) {
	        Map<String, Object> event = new HashMap<>();
	        event.put("title", "團課"+course.getCourseScheduleTime());
	        event.put("start", course.getCourseScheduleDate());

	        events.add(event);
	    }
	    
	    model.addAttribute("dayoffList", dayoffList);
	    model.addAttribute("proclassList", proclassList);
	    model.addAttribute("courseScList", courseScList);
	    model.addAttribute("events", events); // 將事件列表新增到模型中
	    
	    return "frontend/proclassorder/frontend_proclassorder";
	};
	    

}
