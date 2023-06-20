package com.givemegym.course.controller;


import com.givemegym.course.service.CourseService;
import com.givemegym.course.vo.Course;
import com.givemegym.period.service.PeriodService;
import com.givemegym.period.vo.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/frontend_course")
public class CourseControllerF {

    @Autowired
    private CourseService courseService;


    // 查詢團課列表
    @GetMapping("/listAll")
    public String findAllCourse(Model model) {
        List<Course> courseList = courseService.findAll();
        model.addAttribute("courseList", courseList);
        return "frontend/course/courseList";
    }


    // 根據PK查詢一筆團課
//    @GetMapping("/findOne/{courseId}")
//    public String findCourseById(@PathVariable Integer courseId, Model model) {
//        Optional<Course> findCourse = courseService.findById(courseId);
//        Course course = findCourse.orElseThrow();
//        model.addAttribute("course", course);
//        return "frontend/period/periodDetail"; // 返回课程详情页面的视图名称
//    }


}
