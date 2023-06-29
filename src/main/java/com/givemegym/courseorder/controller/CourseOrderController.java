package com.givemegym.courseorder.controller;

import com.givemegym.courseorder.service.CourseOrderService;
import com.givemegym.courseorder.vo.CourseOrder;
import com.givemegym.courseschedule.vo.CourseSchedule;
import com.givemegym.mem.service.MemberService;
import com.givemegym.mem.vo.MemberVO;
import com.givemegym.orderDetail.vo.OrderDetail;
import com.givemegym.period.service.PeriodService;
import com.givemegym.period.vo.Period;
import com.givemegym.shopCart.vo.DetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Controller
public class CourseOrderController {

    @Autowired
    private CourseOrderService courseOrderService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private PeriodService periodService;

//    =============================後台================================

    // 查詢此時段有幾筆訂單
    @GetMapping("/backend_courseOrder/findByPeriod/{period}")
    public String findCourseOrderByPeriod(@PathVariable Period period, Model model) {
        List<CourseOrder> courseOrderByPeriod = courseOrderService.findCourseOrderByPeriod(period);
        model.addAttribute("courseOrderByPeriod", courseOrderByPeriod);
        model.addAttribute("courseOrderCounts", courseOrderByPeriod.size());
        return "backend/courseOrder/courseOrderList";
    }


    // 導入修改團課訂單的頁面
    @GetMapping("/backend_courseOrder/update/{courseOrderId}")
    public String toUpdate(@PathVariable Integer courseOrderId, ModelMap model) {
        Optional<CourseOrder> findCourseOrder = courseOrderService.findById(courseOrderId);
        model.addAttribute("courseOrder", findCourseOrder.orElseThrow());
        // 查詢完成後轉交修改團課訂單的頁面
        return "backend/courseOrder/updateOrder";
    }

    // 新增或修改團課訂單
    @PostMapping("/backend_courseOrder/saveOrUpdate")
    public String saveOrUpdate(@Valid CourseOrder courseOrder) {
        courseOrderService.saveOrUpdate(courseOrder);
        Period period = courseOrder.getPeriod();
        Integer periodId = period.getPeriodId();
        return "redirect:/backend_courseOrder/findByPeriod/" + periodId;
    }


    //查看該會員有的訂單(不是燈箱)
//    @GetMapping("/backend_courseOrder/orders/{memberId}")
//    public String memberOrder(@PathVariable Integer memberId, Model model) {
//        List<CourseOrder> orderByMember = courseOrderService.findByMemberId(memberId);
//        model.addAttribute("orderByMember", orderByMember);
//        return "backend/courseOrder/courseOrderMemberList";
//    }

    //查看該會員有的訂單(想用燈箱)
    @ResponseBody
    @GetMapping("/backend_courseOrder/orders/{memberId}")
    public List<CourseOrder> memberOrder(@PathVariable Integer memberId) {
        List<CourseOrder> orderByMember = courseOrderService.findByMemberId(memberId);
        return orderByMember;
    }


    //    =============================前台================================

    //會員下單頁面
    @GetMapping("/frontend_courseOrder/addOrders/{periodId}")
    public String toAdd(@PathVariable Integer periodId, ModelMap model, HttpSession session) {
        Optional<Period> period = periodService.findById(periodId);
        model.addAttribute("period", period);

        Integer memberId = (Integer) session.getAttribute("memberId");
        MemberVO memberVO = memberService.findByMemberId(memberId);
        model.addAttribute("memberVO", memberVO);

        List<CourseOrder> courseOrders = courseOrderService.findByMemberId(memberId);
        model.addAttribute("courseOrders", courseOrders);
        return "frontend/courseOrder/addCourseOrder";
    }


    // 會員下單某時段的課程
    @PostMapping("/frontend_courseOrder/addOrder/{periodId}")
    public String orderSave(@PathVariable Integer periodId, HttpSession session) {
        Integer memberId = (Integer) session.getAttribute("memberId");
        MemberVO memberVO = memberService.findByMemberId(memberId);
        courseOrderService.saveOrder(periodId, memberVO);
        return "redirect:/frontend_courseOrder/orderList/" + memberId;
    }


    //ajax (jquery)檢查訂單否重複，並回傳JSON物件給前端，顯示PERIOD
    @PostMapping("/frontend_courseOrder/checkOrder")
    @ResponseBody
    public Object checkCourseOrder(@RequestBody Period period, HttpSession session) {
        Integer memberId = (Integer) session.getAttribute("memberId");
        MemberVO memberVO = memberService.findByMemberId(memberId);
        Period periods = periodService.findById(period.getPeriodId()).orElse(null);
        CourseOrder exCourseOrder = courseOrderService.findCourseOrderByMemberAndPeriod(memberVO, period);

        return exCourseOrder != null ? exCourseOrder.getCourseOrderId() : false;
    }


    // 會員查看團課課表
    @GetMapping("/frontend_courseOrder/orderList")
    public String orderListAll(HttpSession session, Model model) {
        Integer memberId = (Integer) session.getAttribute("memberId");
        List<CourseOrder> orders = courseOrderService.findByMemberId(memberId);
        model.addAttribute("orders", orders);

        for (CourseOrder order : orders) {
            Set<CourseSchedule> schedules = order.getPeriod().getSchedules();

            List<String> timeSlots = schedules.stream()
                    .map(schedule -> schedule.getCourseScheduleDate() + " " + schedule.getCourseScheduleTime())
                    .collect(Collectors.toList());

            String courseName = order.getPeriod().getCourse().getCourseName();

            model.addAttribute("timeSlots", timeSlots);
            model.addAttribute("courseName", courseName);
        }
        return "frontend/courseOrder/course_order_detail";
    }


}
