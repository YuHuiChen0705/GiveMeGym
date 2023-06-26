package com.givemegym.period.controller;

import com.givemegym.coach.service.CoachService;
import com.givemegym.coach.vo.Coach;
import com.givemegym.course.service.CourseService;
import com.givemegym.course.vo.Course;
import com.givemegym.courseorder.service.CourseOrderService;
import com.givemegym.courseorder.vo.CourseOrder;
import com.givemegym.courseschedule.service.CourseScheduleService;
import com.givemegym.courseschedule.vo.CourseSchedule;
import com.givemegym.period.PeriodForm;
import com.givemegym.period.service.PeriodService;
import com.givemegym.period.vo.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class PeriodController {

    @Autowired
    private PeriodService periodService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseScheduleService courseScheduleService;

    @Autowired
    private CoachService coachService;

    @Autowired
    private CourseOrderService courseOrderService;

    //==================================後台=========================================//
    // 查詢報名時段列表
    @GetMapping("/backend_period/listAll")
    public String findAllPeriod(Model model) {
        List<Period> periodList = periodService.findAll();
        model.addAttribute("periodList", periodList);
        for (Period period : periodList) {
            Set<CourseOrder> orderList = courseOrderService.findByCourseOrderStateAndPeriod("已成立", period);
            period.setOrders(orderList);
        }
        return "backend/period/periodList";
    }


    // 執行新增導入新增團課時段的頁面
    @GetMapping("/backend_period/addPeriod")
    public String toAdd(ModelMap model) {
        Period period = new Period();
        model.addAttribute("period", period);
        PeriodForm periodForm = new PeriodForm();

        for (int i = 1; i <= 4; i++) {
            periodForm.addCourseSchedule(new CourseSchedule());
        }
        model.addAttribute("form", periodForm);
        Coach coach = new Coach();
        model.addAttribute("coach", coach);
        // 轉交新增團課的頁面
        return "backend/period/addPeriod";
    }

    // 新增報名時段
    @PostMapping("/backend_period/save")
    public String save(
            @ModelAttribute("form") @Valid PeriodForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "backend/period/addPeriod";
        }

        Period period = form.getPeriod();
        periodService.save(period);

        List<CourseSchedule> courseSchedules = form.getCourseSchedules();
        for (CourseSchedule schedule : courseSchedules) {
            schedule.setPeriod(period);
            schedule.setCourseScheduleState("已成立");
        }
        courseScheduleService.saveAll(form.getCourseSchedules());
        return "redirect:/backend_period/listAll";
    }

    ;


    // 導入修改團課的頁面
    @GetMapping("/backend_period/updatePeriod/{periodId}")
    public String toUpdate(@PathVariable Integer periodId, ModelMap model) {
        Optional<Period> findPeriod = periodService.findById(periodId);
        model.addAttribute("Period", findPeriod.orElseThrow());
        model.addAttribute("courseSchedule", findPeriod.orElseThrow().getSchedules());
        List<Course> courseList = courseService.findAll();
        model.addAttribute("courseList", courseList);
        // 查詢完成後轉交修改團課時段的頁面
        return "backend/period/updatePeriod";
    }

    // 修改報名時段
    @PostMapping("/backend_period/update")
    public String updatePeriod(@Valid Period period, BindingResult periodResult) {
        // 驗證報名時段的结果
        if (periodResult.hasErrors()) {
            return "backend/period/addPeriod";
        }
        // 如果沒有錯誤驗證則可進行修改報名時段
        periodService.update(period);

        // 如果報名時段的狀態為"下架"
        if (Objects.equals(period.getCourseState(), "下架")) {
            // 則將上課時段改為"已取消"
            courseScheduleService.updateCourseScheduleStateToOffByPeriod(period);
            courseOrderService.updateCourseOrderStateToOffByPeriod(period);

        } else {
            // 則將上課時段改為"已成立"
            courseScheduleService.updateCourseScheduleStateToOnByPeriod(period);
            courseOrderService.updateCourseOrderStateToOnByPeriod(period);
        }
        return "redirect:/backend_period/listAll";
    }

    @ModelAttribute("courseListData")
    protected List<Course> referenceListData() {
        return courseService.findAll();
    }


    @ModelAttribute("coachListData")
    protected List<Coach> referenceCoachListData() {
        return coachService.findAll();
    }


    @ResponseBody
    @GetMapping("/getCoachList'")
    protected List<Coach> CoachListData() {
        return coachService.findAll();
    }


    //==================================前台=========================================//
    // 前端頁面點選課程會列出該課程的所有時段
    @GetMapping("/frontend_period/detail/{course}")
    public String showDetail(@PathVariable Course course, Model model) {
        List<Period> findAllCourse = periodService.findByCourse(course);
        List<Period> findCourse = new ArrayList<Period>();

        for (Period period : findAllCourse) {
            if (Objects.equals(period.getCourseState(), "上架")) {
                findCourse.add(period);
            }
        }

        model.addAttribute("findCourse", findCourse);
        model.addAttribute("courseSchedules", findCourse.stream()
                .map(Period::getSchedules)
                .collect(Collectors.toList()));

        return "frontend/period/periodDetail";
    }


}
