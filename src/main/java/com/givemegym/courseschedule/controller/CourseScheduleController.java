package com.givemegym.courseschedule.controller;

import java.util.*;

import com.givemegym.courseschedule.vo.CourseSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.givemegym.courseschedule.service.CourseScheduleService;

@Controller
@RequestMapping("/frontend/CourseSchedule")
public class CourseScheduleController {

    @Autowired
    private CourseScheduleService coursescheduleService;

    @GetMapping("/listAllCourseSchedule")
    public String findAllPeriod(Model model) {
        List<CourseSchedule> coursescheduleList = coursescheduleService.findAll();//找列表
        model.addAttribute("coursescheduleList", coursescheduleList);//利用MODEL放進
        return "backend/courseschedule/coursescheduleList";//想要呈現的位置(HTML)

    }

}