package com.givemegym.courseschedule.controller;

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


    // 查詢團課上課時段列表
    @GetMapping("/listAll")
    public String findAllCourseSchedule(Model model) {
        List<CourseSchedule> courseScheduleList = courseScheduleService.findAll();
        model.addAttribute("courseScheduleList", courseScheduleList);
        return "backend/courseSchedule/courseScheduleList";
    }

    // 根据PK查詢一筆時段
//    @GetMapping("/findOne/{courseScheduleId}")
//    public String findCourseScheduleById(@PathVariable Integer courseScheduleId, Model model) {
//
//        CourseSchedule courseSchedule = courseScheduleService.findById(courseScheduleId).orElseThrow();
//        model.addAttribute("courseScheduleVO", courseSchedule);
//
//        return "backend/courseSchedule/courseScheduleList";
//    }

    @GetMapping("/findByPeriod/{period}")
    public String findCourseScheduleByPeriod(@PathVariable Period period, Model model) {
        List<CourseSchedule> courseScheduleByPeriod = courseScheduleService.findCourseScheduleByPeriod(period);
        model.addAttribute("courseScheduleByPeriod", courseScheduleByPeriod);
        return "backend/courseSchedule/courseScheduleList";
    }

    // 導入新增上課時段的頁面
    @GetMapping("/add")
    public String toAdd() {
        return "backend/courseSchedule/addCourseSchedule";
    }

    // 導入修改上課時段的頁面
    @GetMapping("/update/{courseScheduleId}")
    public String toUpdate(@PathVariable Integer courseScheduleId, ModelMap model) {
        Optional<CourseSchedule> findCourseSchedule = courseScheduleService.findById(courseScheduleId);
        model.addAttribute("CourseSchedule", findCourseSchedule.orElseThrow());
        // 查詢完成後轉交修改團課時段的頁面
        return "backend/courseSchedule/updateCourseSchedule";
    }


    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(@Valid CourseSchedule courseSchedule) {
           courseScheduleService.saveOrUpdate(courseSchedule);
        return "redirect:/backend_courseSchedule/listAll";
    }


    //ajax (jquery)檢查上課日期及時間是否重複，並回傳JSON物件給前端，顯示上課時段編號幾號與之重複
//    @PostMapping(path = "/checkDateTime", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public ResponseEntity<CourseSchedule> findByCourseName(@RequestBody CourseSchedule courseSchedule) {
//        CourseSchedule bean = courseScheduleService.findCourseScheduleByCourseScheduleDateAndCourseScheduleTime(courseSchedule.getCourseScheduleDate(), courseSchedule.getCourseScheduleTime());
//        if (bean != null) {
//            return ResponseEntity.status(HttpStatus.OK).body(bean);
//        } else {
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//        }
//    }


    @ModelAttribute("coachListData")
    protected List<Coach> referenceListData() {
//		DeptService deptSvc = new DeptService();
        return coachService.findAll();
    }

    @ModelAttribute("courseListData")
    protected List<Course> ListData() {
//		DeptService deptSvc = new DeptService();
        return courseService.findAll();
    }

//    @ModelAttribute("periodListData")
//    protected List<Period> ListData() {
////		DeptService deptSvc = new DeptService();
//        return periodService.findAll();
//    }


}
