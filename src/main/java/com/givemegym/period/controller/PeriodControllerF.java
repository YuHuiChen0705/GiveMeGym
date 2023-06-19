package com.givemegym.period.controller;


import com.givemegym.course.vo.Course;
import com.givemegym.period.service.PeriodService;
import com.givemegym.period.vo.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/frontend_period")
public class PeriodControllerF {

    @Autowired
    private PeriodService periodService;


    // 前端頁面點選課程會列出該課程的所有時段
    @GetMapping("/detail/{course}")
    public String showDetail(@PathVariable Course course, Model model) {

        List<Period> findCourse = periodService.findByCourse(course);
        model.addAttribute("findCourse", findCourse);
        model.addAttribute("courseSchedules", findCourse.stream()
                .map(Period::getSchedules)
                .collect(Collectors.toList()));
        return "frontend/period/periodDetail";
    }


}
