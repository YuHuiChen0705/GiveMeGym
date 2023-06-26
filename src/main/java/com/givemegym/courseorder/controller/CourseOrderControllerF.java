package com.givemegym.courseorder.controller;

import com.givemegym.coach_B.vo.Coach;
import com.givemegym.courseorder.service.CourseOrderService;
import com.givemegym.courseorder.vo.CourseOrder;
import com.givemegym.courseschedule.vo.CourseSchedule;
import com.givemegym.faqs.vo.Faq;
import com.givemegym.member_B.vo.Member;
import com.givemegym.period.service.PeriodService;
import com.givemegym.period.vo.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/frontend_courseOrder")
public class CourseOrderControllerF {

    @Autowired
    private CourseOrderService courseOrderService;

    @Autowired
    private PeriodService periodService;

    //下單頁面
    @GetMapping("/addOrders/{periodId}")
    public String toAdd(@PathVariable Integer periodId, ModelMap model) {
        Optional<Period> period = periodService.findById(periodId);
        model.addAttribute("period", period);
        return "frontend/courseOrder/addCourseOrder";
    }


    // 會員下單某時段的課程
//    @PostMapping("/addCourseOrder/{periodId}")
//    public String orderSave(@PathVariable Integer periodId, HttpServletRequest request) {
//        Member loginMember = (Member) request.getSession().getAttribute("loginMember");
//        courseOrderService.saveOrder(periodId,loginMember);
//         return "redirect:/frontend_courseOrder/addOrders/" + periodId;
//    }

    // 會員下單某時段的課程(先寫死)
    @PostMapping("/addOrder/{periodId}")
    public String orderSave(@PathVariable Integer periodId, @ModelAttribute("member") Member member) {

        member.setMemberId(2);
        courseOrderService.saveOrder(periodId, member);
        return "redirect:/frontend_courseOrder/addOrders/" + periodId;
    }

    // 會員團課課表(渲染頁面)
//    @GetMapping("/listAll")
//    public String findAllOrder() {
//        return "frontend/courseOrder/courseOrderDetail";
//    }

    @GetMapping("/orderList/{memberId}")
    public String orderListAll(@PathVariable Integer memberId,ModelMap model){
        List<CourseOrder> orders = courseOrderService.findByMemberId(memberId);
        model.addAttribute("orders",orders);
        return "frontend/order/shop_order_detail";
    }


}

