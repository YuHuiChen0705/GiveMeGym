package com.givemegym.period.controller;

import com.givemegym.coach.service.CoachService;
import com.givemegym.coach.vo.CoachVo;
import com.givemegym.course.service.CourseService;
import com.givemegym.course.vo.Course;
import com.givemegym.courseschedule.service.CourseScheduleService;
import com.givemegym.courseschedule.vo.CourseSchedule;
import com.givemegym.period.service.PeriodService;
import com.givemegym.period.vo.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/backend_period")
public class PeriodControllerB {

    @Autowired
    private PeriodService periodService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseScheduleService courseScheduleService;

    @Autowired
    private CoachService coachService;


    // 查詢團課時段列表
    @GetMapping("/listAll")
    public String findAllPeriod(Model model) {
        List<Period> periodList = periodService.findAll();
        model.addAttribute("periodList", periodList);
        return "backend/period/periodList";
    }

    // 根據PK查詢一筆時段
//    @GetMapping("/findOne/{periodId}")
//    public String findPeriodById(@PathVariable Integer periodId, Model model) {
//        List<Period> periodList = new ArrayList<Period>();
//        Optional<Period> findPeriod = periodService.findById(periodId);
//        periodList.add(findPeriod.orElseThrow());
//        model.addAttribute("period", periodList);
//        return "backend/period/periodList";
//    }


    // 導入新增團課時段的頁面
    @GetMapping("/addPeriod")
    public String toAdd(ModelMap model) {
        Period period = new Period();
        model.addAttribute("period", period);
        CourseSchedule courseSchedule = new CourseSchedule();
        model.addAttribute("courseSchedule", courseSchedule);
        CoachVo coach = new CoachVo();
        model.addAttribute("coach", coach);
        // 轉交新增團課的頁面
        return "backend/period/addPeriod";
    }

    // 導入修改團課的頁面
    @GetMapping("/updatePeriod/{periodId}")
    public String toUpdate(@PathVariable Integer periodId, ModelMap model) {
        Optional<Period> findPeriod = periodService.findById(periodId);
        model.addAttribute("Period", findPeriod.orElseThrow());
        model.addAttribute("courseSchedule", findPeriod.orElseThrow().getSchedules());
        List<Course> courseList = courseService.findAll();
        model.addAttribute("courseList", courseList);
        // 查詢完成後轉交修改團課時段的頁面
        return "backend/period/updatePeriod";
    }


    @PostMapping("/saveOrUpdate")
    public String saveOrUpdatePeriod(
            @Valid Period period, BindingResult periodResult,
            @Valid CourseSchedule courseSchedule, BindingResult scheduleResult
    ) {


        // 驗證 Period 的结果
        if (periodResult.hasErrors() || scheduleResult.hasErrors()) {
            return "backend/period/addPeriod";
        }
        period.setCourseState("上架");
        periodService.saveOrUpdate(period);
        courseSchedule.setPeriod(period);
        courseSchedule.setCourseScheduleState("已成立");
        courseScheduleService.saveOrUpdate(courseSchedule);
        return "redirect:/backend_period/listAll";
    }


    // 刪除
    @DeleteMapping("/delete/{periodId}")
    public String delete(@PathVariable Integer periodId, ModelMap model) {
        // 開始刪除
        periodService.deleteById(Integer.valueOf(periodId));
        // 刪除完成,準備轉交(Send the Success view)
        List<Period> list = periodService.findAll();
        model.addAttribute("periodListData", list);
        model.addAttribute("success", "- (刪除成功)");
        return "redirect:/period/listAll";
    }

    //日期
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        // java.sql.Date
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        CustomDateEditor ce = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(java.util.Date.class, ce);
    }

    @ModelAttribute("courseListData")
    protected List<Course> referenceListData() {
//		DeptService deptSvc = new DeptService();
        return courseService.findAll();
    }


    @ModelAttribute("coachListData")
    protected List<CoachVo> referenceCoachListData() {
//		DeptService deptSvc = new DeptService();
        return coachService.findAll();
    }


}
