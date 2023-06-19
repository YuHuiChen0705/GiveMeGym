package com.givemegym.period.controller;

import com.givemegym.course.service.CourseService;
import com.givemegym.course.vo.Course;
import com.givemegym.period.service.PeriodService;
import com.givemegym.period.vo.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/backend_period")
public class PeriodController {

    @Autowired
    private PeriodService periodService;

    @Autowired
    private CourseService courseService;


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


    // 前端頁面點選課程會列出該課程的所有時斷
    @GetMapping("/detail/{course}")
    public String showDetail(@PathVariable Course course, Model model) {
        List<Period> findCourse = periodService.findByCourse(course);
        model.addAttribute("findCourse", findCourse);
        return "frontend/period/periodDetail";
    }

    // 導入新增團課時段的頁面
    @GetMapping("/addPeriod")
    public String toAdd() {
        return "backend/period/addPeriod";
    }

    // 導入修改團課的頁面
    @GetMapping("/updatePeriod/{periodId}")
    public String toUpdate(@PathVariable Integer periodId, ModelMap model) {
        Optional<Period> findPeriod = periodService.findById(periodId);
        model.addAttribute("Period", findPeriod.orElseThrow());
        // 查詢完成後轉交修改團課時段的頁面
        return "backend/period/updatePeriod";
    }

    // 新增或修改團課時段
    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(@Valid Period period, BindingResult result) {
        periodService.saveOrUpdate(period);
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
        List<Course> list = courseService.findAll();
        return list;
    }

}
