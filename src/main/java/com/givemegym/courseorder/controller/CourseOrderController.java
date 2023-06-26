package com.givemegym.courseorder.controller;

import com.givemegym.courseorder.service.CourseOrderService;
import com.givemegym.courseorder.vo.CourseOrder;
import com.givemegym.mem.vo.MemberVO;
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
public class CourseOrderController {

    @Autowired
    private CourseOrderService courseOrderService;

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


    //查看該會員有的訂單(想用燈箱)
    @ResponseBody
    @GetMapping("/backend_courseOrder/orders/{memberId}")
    public List<CourseOrder> memberOrder(@PathVariable Integer memberId) {
        return courseOrderService.findByMemberId(memberId);
    }


    //    =============================前台================================

    //下單頁面
    @GetMapping("/frontend_courseOrder/addOrders/{periodId}")
    public String toAdd(@PathVariable Integer periodId, ModelMap model) {
        Optional<Period> period = periodService.findById(periodId);
        model.addAttribute("period", period);
        return "frontend/courseOrder/addCourseOrder";
    }


    // 會員下單某時段的課程
//    @PostMapping("/addOrder/{periodId}")
//    public String orderSave(@PathVariable Integer periodId, HttpServletRequest request) {
//        Member loginMember = (Member) request.getSession().getAttribute("loginMember");
//        courseOrderService.saveOrder(periodId,loginMember);
//         return "redirect:/frontend_courseOrder/addOrders/" + periodId;
//    }

    // 會員下單某時段的課程(先寫死)
    @PostMapping("/frontend_courseOrder/addOrder/{periodId}")
    public String orderSave(@PathVariable Integer periodId, @ModelAttribute("member") MemberVO member) {

        member.setMemberId(2);
        courseOrderService.saveOrder(periodId, member);
        return "redirect:/frontend_course/listAll";
    }

    // 會員團課課表(渲染頁面)
//    @GetMapping("/listAll")
//    public String findAllOrder() {
//        return "frontend/courseOrder/courseOrderDetail";
//    }

    @GetMapping("/frontend_courseOrder/orderList/{memberId}")
    public String orderListAll(@PathVariable Integer memberId, ModelMap model) {
        List<CourseOrder> orders = courseOrderService.findByMemberId(memberId);
        model.addAttribute("orders", orders);
        return null;
    }

}
