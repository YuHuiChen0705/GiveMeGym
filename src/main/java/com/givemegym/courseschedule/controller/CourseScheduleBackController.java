package com.givemegym.courseschedule.controller;

import java.sql.Date;
import com.givemegym.coach.service.CoachService;
import com.givemegym.coach.vo.Coach;
import com.givemegym.course.service.CourseService;
import com.givemegym.course.vo.Course;
import com.givemegym.courseschedule.service.CourseScheduleService;
import com.givemegym.courseschedule.vo.CourseSchedule;
import com.givemegym.period.service.PeriodService;
import com.givemegym.period.vo.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/backend_courseSchedule")
public class CourseScheduleBackController {

    @Autowired
    private CourseScheduleService courseScheduleService;

    @Autowired
    private CoachService coachService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private PeriodService periodService;

    // 查詢上課時段列表
    @GetMapping("/listAll")
    public String findAllCourseSchedule(Model model) {
        List<CourseSchedule> courseScheduleList = courseScheduleService.findAll();
        model.addAttribute("courseScheduleList", courseScheduleList);
        return "backend/courseSchedule/courseScheduleList";
    }

    // 根據報名時段查詢上課時段列表
    @GetMapping("/findByPeriod/{period}")
    public String findCourseScheduleByPeriod(@PathVariable Period period, Model model) {
        List<CourseSchedule> courseScheduleByPeriod = courseScheduleService.findCourseScheduleByPeriod(period);
        model.addAttribute("courseScheduleByPeriod", courseScheduleByPeriod);
        return "backend/courseSchedule/courseScheduleList";
    }

    // 導入修改上課時段的頁面
    @GetMapping("/update/{courseScheduleId}")
    public String toUpdate(@PathVariable Integer courseScheduleId, ModelMap model) {
        Optional<CourseSchedule> findCourseSchedule = courseScheduleService.findById(courseScheduleId);
        model.addAttribute("CourseSchedule", findCourseSchedule.orElseThrow());
        // 查詢完成後轉交修改團課時段的頁面
        return "backend/courseSchedule/updateSchedule";
    }


    // 修改上課時段
    @PostMapping("/update")
    public String update(@Valid CourseSchedule courseSchedule) {
        courseScheduleService.update(courseSchedule);
        Period period = courseSchedule.getPeriod();
        Integer periodId = period.getPeriodId();
        return "redirect:/backend_courseSchedule/findByPeriod/" + periodId;
    }



    @ModelAttribute("coachListData")
    protected List<Coach> referenceListData() {
        return coachService.findAll();
    }

    @ModelAttribute("courseListData")
    protected List<Course> ListData() {
        return courseService.findAll();
    }



}
