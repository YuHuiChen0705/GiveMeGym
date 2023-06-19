//package com.givemegym.courseorder.controller;
//
//import com.givemegym.courseorder.service.CourseOrderService;
//import com.givemegym.courseorder.vo.CourseOrder;
//import com.givemegym.period.service.PeriodService;
//import com.givemegym.period.vo.Period;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.validation.Valid;
//import java.util.List;
//import java.util.Optional;
//
//@Controller
//@RequestMapping("/backend_courseOrder")
//public class CourseOrderController {
//
//    @Autowired
//    private CourseOrderService courseOrderService;
//
//    @Autowired
//    private PeriodService periodService;
//
//    // 列表訂單
//    @GetMapping("/listAll")
//    public String findAllCourseOrder(Model model) {
//        List<CourseOrder> courseOrderList = courseOrderService.findAll();
//        model.addAttribute("courseOrderList", courseOrderList);
//        return "backend/courseorder/courseOrderList";
//    }
//
//    // 導入新增團課訂單的頁面
//    @GetMapping("/add")
//    public String toAdd() {
//        return "前台新增團課訂單的頁面";
//    }
//
//
//    // 導入修改團課訂單的頁面
//    @GetMapping("/update/{courseOrderId}")
//    public String toUpdate(@PathVariable Integer courseOrderId, ModelMap model) {
//        Optional<CourseOrder> findCourseOrder = courseOrderService.findById(courseOrderId);
//        model.addAttribute("CourseOrder", findCourseOrder.orElseThrow());
//        // 查詢完成後轉交修改團課訂單的頁面
//        return "前台修改團課訂單的頁面";
//    }
//
//    // 新增或修改團課訂單
//    @PostMapping("/saveOrUpdate")
//    public String saveOrUpdate(@Valid CourseOrder courseOrder) {
//        courseOrderService.saveOrUpdate(courseOrder);
//        return "redirect:/backend_courseOrder/listAll";
//    }
//
//
//    //查看一報名時段有幾筆訂單
//    @GetMapping(path = "/findCourseOrder/{periodId}")
//    public String findCourseOrderByPeriodId(@PathVariable("periodId") Integer periodId, Model model){
////        model.addAttribute("memberList", memberService.getAllMembers());
////        List<CourseOrder> courseOrderList = courseOrderService.findByPeriodId(periodId);
////        model.addAttribute("courseOrderList",courseOrderList);
//        List<Member> members = orderService.getMembersByPeriodId(id);
//        model.addAttribute("members", members);
//        return "members_list"; // 返回Thymeleaf模板的视图名
//        return "backend_courseOrder/orderdetail";
//    }
//
//
//    // 根據PK查詢一筆時段
////    @GetMapping("/findOne/{periodId}")
////    public String findPeriodById(@PathVariable Integer periodId, Model model) {
////        List<Period> periodList = new ArrayList<Period>();
////        Optional<Period> findPeriod = periodService.findById(periodId);
////        periodList.add(findPeriod.orElseThrow());
////        model.addAttribute("period", periodList);
////        return "backend/period/periodList";
////    }
//
//
//
//}
